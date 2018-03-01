package com.anyikang.service.admin;

import com.anyikang.model.admin.AdminRolePermission;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public interface AdminRolePermissionService   extends IService<AdminRolePermission>{
    int deleteBatch(List<AdminRolePermission> list);
    int deleteRoleId(Integer roleId);
    int deletePermissionId(Integer permissionId);
}
