package com.anyikang.dao.admin;

import com.anyikang.model.admin.AdminRole;
import com.anyikang.model.admin.AdminUser;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    List<AdminRole> selectByUserId(Integer userId);
    List<AdminRole> queryRoleAll();
    List<AdminRole> selectRoleAll();
    List<AdminUser> queryUserRole(Integer roleId);
}