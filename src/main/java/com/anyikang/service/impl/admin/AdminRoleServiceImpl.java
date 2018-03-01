package com.anyikang.service.impl.admin;

import com.anyikang.components.shiro.MyShiroRealm;
import com.anyikang.dao.admin.AdminRoleMapper;
import com.anyikang.model.admin.AdminRole;
import com.anyikang.model.admin.AdminRolePermission;
import com.anyikang.model.vo.PublicReturnVo;
import com.anyikang.model.vo.admin.RoleVo;
import com.anyikang.service.admin.AdminRolePermissionService;
import com.anyikang.service.admin.AdminRoleService;
import com.anyikang.service.admin.AdminUserRoleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;












import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
    private static final Logger logger = LoggerFactory.getLogger(AdminRoleServiceImpl.class);
    @Autowired
    private AdminRolePermissionService adminRolePermissionService;

    @Autowired
    private AdminUserRoleService adminUserRoleService;

    @Autowired 
    private MyShiroRealm myShiroRealm;

    @Override
    public List<AdminRole> selectByUserId(Integer userId) {
        return baseMapper.selectByUserId(userId);
    }

    @Override
    public List<AdminRole> queryRoleAll() {
        List list=baseMapper.queryRoleAll();
        return list;
    }

    @Override
    public List<AdminRole> selectRoleAll() {
      return baseMapper.selectRoleAll();
    }


    @Override
    @Transactional
    public int insert(RoleVo roleVo) {
        AdminRole adminRole = new AdminRole();
        adminRole.setRoleName(roleVo.getRoleName());
        adminRole.setRoleDescription(roleVo.getRoleDescription());
        adminRole.setCreateTime(new Date());
        adminRole.setStatus(true);
        int result = baseMapper.insert(adminRole);
        logger.info("result = " + result +"  id=" + adminRole.getRoleId());
        if(org.apache.commons.lang.StringUtils.isEmpty(roleVo.getAddId())){
            return result;
        }
        String []ids = roleVo.getAddId().split(",");
        List<AdminRolePermission>list = getRolePermission(adminRole.getRoleId(), ids);
        adminRolePermissionService.insertBatch(list);
        return result;
    }

    @Override
    public int update(RoleVo roleVo, Integer userId) {
        AdminRole adminRole = new AdminRole();
        if(!roleVo.getOriginalRoleName().equals(roleVo.getRoleName())){
            adminRole.setRoleName(roleVo.getRoleName());
        }
        adminRole.setRoleDescription(roleVo.getRoleDescription());
        adminRole.setCreateTime(new Date());
        adminRole.setStatus(true);
        adminRole.setRoleId(roleVo.getRoleId());
        int result = baseMapper.updateById(adminRole);
        EntityWrapper ew=new EntityWrapper();
        ew.setEntity(new AdminRole());
       // int result =   baseMapper.update(adminRole, ew);

        if(org.apache.commons.lang.StringUtils.isNotEmpty(roleVo.getAddId())){
            String []ids = roleVo.getAddId().split(",");
            List<AdminRolePermission>list = getRolePermission(roleVo.getRoleId(), ids);
            adminRolePermissionService.insertBatch(list);//新增
        }
        if(org.apache.commons.lang.StringUtils.isNotEmpty(roleVo.getDelId())){
            String []ids = roleVo.getDelId().split(",");
            List<AdminRolePermission>list = getRolePermission(roleVo.getRoleId(), ids);
            adminRolePermissionService.deleteBatch(list);//删除
        }

        clearCachedAuthorizationInfo(userId);//更新缓存
        return result;
    }

    private  List<AdminRolePermission> getRolePermission(int roleId, String []ids){
        int size = ids.length;
        List<AdminRolePermission>list = new ArrayList<AdminRolePermission>();
        for(int i=0; i< size; i++){
            AdminRolePermission adminRolePermission = new AdminRolePermission();
            adminRolePermission.setPermissionId(Integer.parseInt(ids[i]));
            adminRolePermission.setRoleId(roleId);
            list.add(adminRolePermission);
        }
        return list;
    }

    @Override
    @Transactional
    public int deleteById(Integer roleId) {
        adminRolePermissionService.deleteRoleId(roleId);
        adminUserRoleService.deleteRoleId(roleId);
        return baseMapper.deleteById(roleId);
    }

    /**
     * 重新加载权限
     */
    public void clearCachedAuthorizationInfo(Integer userId){
        myShiroRealm.clearCachedAuthorizationInfo(userId);
    }
}
