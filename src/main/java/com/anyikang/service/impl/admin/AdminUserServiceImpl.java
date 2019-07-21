package com.anyikang.service.impl.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.admin.AdminUserMapper;
import com.anyikang.model.admin.AdminUser;
import com.anyikang.model.admin.AdminUserRole;
import com.anyikang.model.vo.PublicReturnVo;
import com.anyikang.model.vo.admin.UserVo;
import com.anyikang.service.admin.AdminUserRoleService;
import com.anyikang.service.admin.AdminUserService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@Service
public class AdminUserServiceImpl  extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService{
    private static final Logger logger = LoggerFactory.getLogger(AdminUserServiceImpl.class);
    @Autowired
    private AdminUserRoleService adminUserRoleService;

    @Override
	public PublicReturnVo<List<AdminUser>> selectAdminUserList(Page<AdminUser> page) {
        PublicReturnVo<List<AdminUser>> vo = null;
        page.setRecords(baseMapper.selectAdminUserList(page));
        vo = PublicReturnVo.conversionPublicReturn(page);
        return vo;
    }

    @Override
    public AdminUser findByUsername(String name) {
        return  baseMapper.findByUsername(name);
    }

    public List<AdminUser> selectAdminUserAll(int roleId,String userName) {
        Map<String,Object> ps =new HashMap<String,Object>();
        ps.put("roleId", roleId);
        ps.put("userName", userName);
        List<AdminUser> list = baseMapper.selectAdminUserAll(ps);
        return list;
    }


    @Override

    public int insert(UserVo userVo) {
        AdminUser adminUser = new AdminUser();
        adminUser.setUserName(userVo.getUserName());
        Md5Hash md5Hash=new Md5Hash(userVo.getUserPassword(), userVo.getUserName(),2);
        adminUser.setUserPassword(md5Hash.toString());
//        adminUser.setUserPassword(userVo.getUserPassword());
        adminUser.setNickName(userVo.getNickName());
        adminUser.setUserStatus(true);
        adminUser.setCreateTime(new Date());

        int result = baseMapper.insert(adminUser);
        if(StringUtils.isNotEmpty(userVo.getRoleId())){
            AdminUserRole adminUserRole = new AdminUserRole();
            adminUserRole.setRoleId(Integer.parseInt(userVo.getRoleId()));
            logger.info("adminUser.getUserId():" + adminUser.getUserId());
            adminUserRole.setUserId(adminUser.getUserId());
            adminUserRoleService.insert(adminUserRole);
        }
        return result;
    }

    @Override
    public int update(UserVo userVo) {
        logger.info("userVo=" + userVo.toString());
        AdminUser adminUser = new AdminUser();
        if(StringUtils.isNotEmpty(userVo.getUserName())&&!userVo.getUserName().equals(userVo.getOriginalUserName())){
            adminUser.setUserName(userVo.getUserName());
        }
//        adminUser.setUserPassword(userVo.getUserPassword());
        if(StringUtils.isNotEmpty(userVo.getUserPassword())){
        	 Md5Hash md5Hash=new Md5Hash(userVo.getUserPassword());
             adminUser.setUserPassword(md5Hash.toString());
        }
                
        adminUser.setNickName(userVo.getNickName());
        adminUser.setCreateTime(new Date());
        adminUser.setUserId(userVo.getUsersId());

        int result = baseMapper.updateById(adminUser);
        if(StringUtils.isNotEmpty(userVo.getOriginalRoleId()) ){
            if(!userVo.getOriginalRoleId().equals(userVo.getRoleId())){
                adminUserRoleService.deleteUserIdRoleId(userVo.getUsersId(), Integer.parseInt(userVo.getOriginalRoleId()));
                AdminUserRole adminUserRole = new AdminUserRole();
                adminUserRole.setUserId(userVo.getUsersId());
                adminUserRole.setRoleId(Integer.parseInt(userVo.getRoleId()));
                adminUserRoleService.insert(adminUserRole);
            }
        }else if (StringUtils.isNotEmpty(userVo.getRoleId())){
            AdminUserRole adminUserRole = new AdminUserRole();
            adminUserRole.setUserId(userVo.getUsersId());
            adminUserRole.setRoleId(Integer.parseInt(userVo.getRoleId()));
            adminUserRoleService.insert(adminUserRole);
        }


        return result;
    }

    @Override
    public int delete(Integer userId) {
        adminUserRoleService.deleteUserId(userId);
       int result = baseMapper.deleteById(userId);
        return result;
    }

	@Override
	public int findByUserId(int userId) {
		int number = baseMapper.findByUserId(userId);
		return number;
	}
}
