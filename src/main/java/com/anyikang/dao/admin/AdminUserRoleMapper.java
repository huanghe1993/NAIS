package com.anyikang.dao.admin;

import com.anyikang.model.admin.AdminUserRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public interface AdminUserRoleMapper extends BaseMapper<AdminUserRole> {
    int deleteRoleId(Integer roleId);
    int deleteUserId(Integer userId);
    int deleteUserIdRoleId(@Param("userId")Integer userId, @Param("roleId")Integer roleId);

}