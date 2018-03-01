package com.anyikang.service.impl.admin;

import com.anyikang.dao.admin.AdminRolePermissionMapper;
import com.anyikang.model.admin.AdminRolePermission;
import com.anyikang.service.admin.AdminRolePermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@Service
public class AdminRolePermissionServiceImpl extends ServiceImpl<AdminRolePermissionMapper, AdminRolePermission> implements AdminRolePermissionService  {
    @Override
    public int deleteBatch(List<AdminRolePermission> list) {
      return  baseMapper.deleteBatch(list);
    }

    @Override
    public int deleteRoleId(Integer roleId) {
        return baseMapper.deleteRoleId(roleId);
    }

    @Override
    public int deletePermissionId(Integer permissionId) {
        return baseMapper.deletePermissionId(permissionId);
    }
}
