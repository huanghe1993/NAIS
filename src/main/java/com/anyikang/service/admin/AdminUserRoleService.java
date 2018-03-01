package com.anyikang.service.admin;

import com.anyikang.model.admin.AdminUserRole;
import com.baomidou.mybatisplus.service.IService;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public interface AdminUserRoleService extends IService<AdminUserRole> {
    int deleteRoleId(Integer roleId);
    int deleteUserId(Integer userId);
    int deleteUserIdRoleId(@Param("userId")Integer userId, @Param("roleId")Integer roleId);
}
