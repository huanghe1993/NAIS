package com.anyikang.dao.admin;


import com.anyikang.model.admin.AdminRolePermission;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public interface AdminRolePermissionMapper  extends BaseMapper<AdminRolePermission> {
    int deleteBatch(List<AdminRolePermission>list);
    int  deleteRoleId(Integer roleId);
    int  deletePermissionId(Integer permissionId);
}