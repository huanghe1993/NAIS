package com.anyikang.service.admin;

import com.anyikang.model.admin.AdminPermission;
import com.anyikang.model.vo.PublicReturnVo;
import com.anyikang.model.vo.admin.PermissionVo;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public interface AdminPermissionService extends IService<AdminPermission> {
    List<AdminPermission> selectByUserId(Integer userId);
    List<AdminPermission> selectPermissionUserId(Integer userId);
    List<AdminPermission> selectPermissionAll();
    List<AdminPermission> selectPermissionRoseId(Integer roleId);
    List<AdminPermission> refreshaAminPermission(Integer roleId,  Integer permissionId);
    List<AdminPermission> queryParentPermission(Integer roleId);
    List<AdminPermission> querySubPermission(Integer roleId,  Integer permissionId);
    List<AdminPermission> querySubPermission(Integer permissionId);
    List<AdminPermission> selectPermissionPageParentId(Integer permissionParentId, String menuName);
    List<AdminPermission>  selectPermissionParentId(Integer permissionParentId);
    AdminPermission selectById(Integer permissionId);
    int insert(PermissionVo permissionVo,Integer roleId);
    int update(PermissionVo permissionVo);
    int delete( Integer permissionId);

}
