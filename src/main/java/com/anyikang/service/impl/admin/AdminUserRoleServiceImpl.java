package com.anyikang.service.impl.admin;
import com.anyikang.dao.admin.AdminUserRoleMapper;
import com.anyikang.model.admin.AdminUserRole;
import com.anyikang.service.admin.AdminUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@Service
public class AdminUserRoleServiceImpl extends ServiceImpl<AdminUserRoleMapper, AdminUserRole> implements AdminUserRoleService {
    @Override
    public int deleteRoleId(Integer roleId) {
        return baseMapper.deleteRoleId(roleId);
    }

    @Override
    public int deleteUserId(Integer userId) {
        return baseMapper.deleteUserId(userId);
    }

    @Override
    public int deleteUserIdRoleId( Integer userId, Integer roleId) {
        return baseMapper.deleteUserIdRoleId(userId, roleId);
    }
}
