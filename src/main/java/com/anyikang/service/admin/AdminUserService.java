package com.anyikang.service.admin;

import java.util.List;

import com.anyikang.model.admin.AdminUser;
import com.anyikang.model.vo.PublicReturnVo;
import com.anyikang.model.vo.admin.UserVo;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public interface AdminUserService extends IService<AdminUser>{
    PublicReturnVo selectAdminUserList(Page<AdminUser>  page);
    List<AdminUser> selectAdminUserAll(int roleId, String userName);
    AdminUser findByUsername(String name);
    int insert(UserVo userVo);
    int update(UserVo userVo);
    int delete(Integer userId);
	int findByUserId(int userId);
}
