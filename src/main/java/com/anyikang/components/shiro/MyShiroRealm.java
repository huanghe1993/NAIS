package com.anyikang.components.shiro;

import com.anyikang.base.Constants;
import com.anyikang.exception.MyException;
import com.anyikang.model.admin.AdminPermission;
import com.anyikang.model.admin.AdminRole;
import com.anyikang.model.admin.AdminUser;
import com.anyikang.service.admin.AdminPermissionService;
import com.anyikang.service.admin.AdminRoleService;
import com.anyikang.service.admin.AdminUserService;
import com.anyikang.utils.AssertUtil;
import com.anyikang.utils.StringRedisUtil;
import com.anyikang.utils.TokenUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@Component
 public class MyShiroRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private AdminPermissionService adminPermissionService;

    public AdminPermissionService getAdminPermissionService() {
        return adminPermissionService;
    }

    @Override
	public boolean supports(AuthenticationToken token) {
        return token instanceof StatelessAuthenticationToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        StatelessAuthenticationToken token = (StatelessAuthenticationToken)authcToken;
        Boolean isLogin = token.getLogin();
        Map<String, Object> map = new HashMap<String, Object>();
        if(token.getLogin()){
            map.put("user_name", token.getUserName());
        }else{
            map.put("user_id", token.getUserName());
        }

        String username = (String)token.getPrincipal();

        //在服务器端生成客户端参数消息摘要
        String serverDigest;

        List<AdminUser> userList =  adminUserService.selectByMap(map);
        AdminUser adminUser = null;
        if (userList.size() != 0) {
            adminUser = userList.get(0);
        }
        if (null == adminUser) {
            throw new MyException("帐号不存在！");
        }

        if(isLogin){//登陆
            serverDigest = adminUser.getUserPassword();
            String tokenId =  StringRedisUtil.get(Constants.CACHE_TOKNID+adminUser.getUserId());//从缓存获取token
            if(StringUtils.isNotEmpty(tokenId)){
                StringRedisUtil.setHours(Constants.CACHE_TOKNID+adminUser.getUserId(), tokenId, Constants.CACHE_TOKENID_TIME);//设置Token
            }else{
//                StringRedisUtil.setHours(Constants.CACHE_TOKNID+adminUser.getUserId(),  TokenUtil.getInstance().makeToken(), Constants.CACHE_TOKENID_TIME);//设置Token
                StringRedisUtil.setHours(Constants.CACHE_TOKNID+adminUser.getUserId(),  TokenUtil.getInstance().makeToken()+adminUser.getUserId(), Constants.CACHE_TOKENID_TIME);//设置Token
            }
        }else{
           String tokenId =  StringRedisUtil.get(Constants.CACHE_TOKNID+adminUser.getUserId());//从缓存获取token
           AssertUtil.notEmpty(tokenId, "需您重新登陆");
           
            logger.info("tokenId= " + tokenId+ "    token.getTokenId()=" + token.getTokenId());
           if(!tokenId.equals(token.getTokenId())){
               AssertUtil.isFalse(true, "您的登录失效,请重新登录");
           }
            //serverDigest =  HmacSHA256Utils.digest(key, token.getParams());
            serverDigest = token.getTokenId();//先暂时不加密
        }

        logger.info(serverDigest+","+token.getCredentials());
        logger.info("username= " + username+ "    serverDigest=" + serverDigest);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                adminUser.getUserId(), //用户名
                serverDigest, //密码
               // ByteSource.Util.bytes("admin"),
              // ByteSource.Util.bytes(adminUser.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	logger.info("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        Integer userId = (Integer) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo  authorizationInfo  = new SimpleAuthorizationInfo();
        logger.info("userName= " + userId);
        
        List<AdminRole> roleList = adminRoleService.selectByUserId(userId);
        if(roleList != null && roleList.size() > 0){
            Set<String> roleSet = new HashSet<String>();
            for (AdminRole role : roleList) {
                roleSet.add(role.getRoleName());
            }
            authorizationInfo.setRoles(roleSet);
        }
        
        List<AdminPermission> permissionList = null;
        if(roleList.get(0).getRoleId() == Constants.SUPER_ADMINISTRATOR){
            permissionList = adminPermissionService.selectList(null);
        }else{
            permissionList = adminPermissionService.selectByUserId(userId);
        }
        Set<String> permissionSet = new HashSet<String>();
        for (AdminPermission permission : permissionList) {
            permissionSet.add(permission.getPermissionResource());
        }

        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }
    
    @Override
    protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
    	logger.info(" 清除认证的缓存");
        Cache cache = this.getAuthenticationCache();
        if(cache!=null){
        	for(Object key: cache.keys()) {
        		cache.remove(key);
        	}
        }
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", (Integer) principals.getPrimaryPrincipal());
        List<AdminUser> userList =  adminUserService.selectByMap(map);
        if (userList.size() != 0) {
        	AdminUser adminUser = userList.get(0);
            StringRedisUtil.del(Constants.CACHE_TOKNID+adminUser.getUserId());
        }
        
        super.clearCachedAuthenticationInfo(principals);
    }

	@Override
	protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		logger.info(" 清除授权的缓存");
		Cache cache = this.getAuthorizationCache();
		if (cache != null) {
			Set<Object> keys = cache.keys();
			for (Object key : keys) {
				cache.remove(key);
			}
		}
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	/*
	 * 清除缓存中 当前用户的权限信息
	 */
	public void clearCachedAuthorizationInfo(Integer userId) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				userId, getName());
		super.clearCachedAuthorizationInfo(principals);
	}

    
}
