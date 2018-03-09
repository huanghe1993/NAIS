package com.anyikang.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.BaseController;
import com.anyikang.base.BaseResponse;
import com.anyikang.model.admin.AdminRole;
import com.anyikang.model.vo.admin.RoleVo;
import com.anyikang.service.admin.AdminPermissionService;
import com.anyikang.service.admin.AdminRoleService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@RestController
@RequestMapping("/role/")
public class AdminRoleController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(AdminRoleController.class);

    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private AdminPermissionService aminPermissionService;


	/**
	 * 查询分页角色列表
	 * 
	 * @return
	 */
	@RequestMapping("query/adminRole")
	@RequiresPermissions("role:queryList")
	public BaseResponse<?> queryAdminRole(int size,int current) {
		BaseResponse<PageInfo> responseMessage = new BaseResponse<>();
		PageMethod.startPage(current, size);
    	PageInfo pageInfo=page(adminRoleService.queryRoleAll());
    	responseMessage.setData(pageInfo);
		return responseMessage;
	}

	/**
	 * 查询所有角色
	 * 
	 * @return
	 */
	@RequestMapping("query/adminRoleAll")
	public BaseResponse<?> adminRoleAll() {
		BaseResponse<List<AdminRole>> responseMessage = new BaseResponse<>();
		List<AdminRole> adminRoleList = adminRoleService.selectRoleAll();

		responseMessage.setData(adminRoleList);
		return responseMessage;
	}

	/**
	 * 角色修改
	 * 
	 * @param roleVo
	 * @param userId
	 * @return
	 */
	@PostMapping("update/adminRole")
	@RequiresPermissions("role:edit")
	public BaseResponse<?> updateAdminRole(RoleVo roleVo,String tokenId) {
		BaseResponse<String> responseMessage = new BaseResponse<>();
		logger.info(roleVo.toString());
//		adminRoleService.update(roleVo, userId);
		adminRoleService.update(roleVo, Integer.parseInt(StringUtils.split(tokenId, "==")[1]));
		responseMessage.setData("操作成功");
		return responseMessage;
	}

	/**
	 * 角色删除
	 * 
	 * @param roleId
	 * @return
	 */
	@GetMapping("del/adminRole")
	@RequiresPermissions("role:del")
	public BaseResponse<?> delAdminRole(Integer roleId) {
		BaseResponse<String> responseMessage = new BaseResponse<>();
		int result = adminRoleService.deleteById(roleId);
		responseMessage.setData("");
		return responseMessage;
	}

	/**
	 * 角色添加
	 * 
	 * @param roleVo
	 * @param request
	 * @return
	 */
	@PostMapping("add/adminRole")
	@RequiresPermissions("role:add")
	public BaseResponse<?> addAdminRole(RoleVo roleVo,HttpServletRequest request) {
		BaseResponse<String> responseMessage = new BaseResponse<>();
		logger.info(roleVo.toString());
		adminRoleService.insert(roleVo);
		responseMessage.setData("");
		return responseMessage;
	}







}
