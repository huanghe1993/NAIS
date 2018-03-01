package com.anyikang.dao.admin;

import com.anyikang.model.admin.AdminPermission;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public interface AdminPermissionMapper extends BaseMapper<AdminPermission> {
    List<AdminPermission> selectByUserId(@Param("userId")Integer userId);
    List<AdminPermission> selectPermissionMap(HashMap<String,Object> map);
    List<AdminPermission> querySubPermission(HashMap<String,Object> map);
    List<AdminPermission> selectPermissionAll(HashMap<String,Object> map);
    List<AdminPermission> selectPermissionRoleId(HashMap<String,Object> map);
    List<AdminPermission> selectPermissionRoleIds(@Param("roleId")Integer roleId);
    List<AdminPermission> selectPermissionPageParentId(Map<String, Object> map);
    List<AdminPermission> selectPermissionParentId(Integer permissionParentId);
    List<AdminPermission>  selectPermissionSuper(HashMap<String,Object> map);//超级管理员接口
}