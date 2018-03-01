package com.anyikang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.Constants;
import com.anyikang.base.BaseResponse;
import com.anyikang.model.admin.AdminRole;
import com.anyikang.model.admin.AdminUser;
import com.anyikang.model.vo.admin.UserCredentials;
import com.anyikang.service.admin.AdminRoleService;
import com.anyikang.service.admin.AdminUserService;
import com.anyikang.utils.AssertUtil;
import com.anyikang.utils.StringRedisUtil;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AdminRoleService adminRoleService;
    
    
    @PostMapping(value = "/login")
    public BaseResponse<?> login(HttpServletRequest request, String userName, String password){
    	System.out.print("userName= " + userName+ "  passwordssss== " + password);
        BaseResponse<UserCredentials> responseMessage = new BaseResponse<>();
        if(userName == null ){
            return  responseMessage.error( "帐号或密码不能为空");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_name", userName);
//        map.put("user_password", password);
        
      //加密后进行匹配
        Md5Hash md5Hash=new Md5Hash(password, userName,2);
        map.put("user_password", md5Hash.toString());
        
        List<AdminUser> userList =  adminUserService.selectByMap(map);
        AssertUtil.notEmpty(userList, "账号或密码错误");
        UserCredentials userCredentials = new UserCredentials();
//        userCredentials.setUserId(userList.get(0).getUserId());
        List<AdminRole> roleList = adminRoleService.selectByUserId(userList.get(0).getUserId());
        if(roleList != null && roleList.size() > 0){
            userCredentials.setRoleId(roleList.get(0).getRoleId());
        }
        String tokenId =  StringRedisUtil.get(Constants.CACHE_TOKNID+userList.get(0).getUserId());//从缓存获取token
        userCredentials.setTokenId(tokenId);

        responseMessage.setData(userCredentials);
        return responseMessage;
    }

    /**
     * 退出登录
     */
    @RequestMapping(value="/logout")
    public BaseResponse<?>  logout() {
        BaseResponse<String> responseMessage = new BaseResponse<>();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return responseMessage.success("退出成功");
    }
}
