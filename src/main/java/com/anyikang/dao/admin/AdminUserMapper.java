package com.anyikang.dao.admin;

import com.anyikang.model.admin.AdminUser;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public interface AdminUserMapper  extends BaseMapper<AdminUser> {
    /**
     * <p>
     * 查询 state 状态，用户列表，分页显示
     * </p>
     *
     * @param page
     *            翻页对象，可以作为 xml 参数直接使用，传递参数 Pages 即自动分页
     *            状态
     * @return
     */
    List<AdminUser> selectAdminUserList(Pagination page);
    /*
    * 根据用户名查询
    * */
    AdminUser  findByUsername(String name);

    List<AdminUser> selectAdminUserAll(Map<String, Object> map);
    /**
     * 根据userId查询
     * @param userId
     * @return
     */
	int findByUserId(int userId);
}