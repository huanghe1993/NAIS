package com.anyikang.service.admin;

import com.anyikang.model.admin.AdminRole;
import com.anyikang.model.vo.PublicReturnVo;
import com.anyikang.model.vo.admin.RoleVo;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public interface AdminRoleService extends IService<AdminRole> {
    List<AdminRole> selectByUserId(Integer userId);
    List<AdminRole> queryRoleAll();
    List<AdminRole> selectRoleAll();
    int insert(RoleVo roleVo);
    int update(RoleVo roleVo, Integer userId);
    int deleteById(Integer roleId);
}
