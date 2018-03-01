package com.anyikang.controller.admin;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.BaseController;
import com.anyikang.base.BaseResponse;
import com.anyikang.model.RescueCenter;
import com.anyikang.model.RescueTeam;
import com.anyikang.model.admin.AdminRole;
import com.anyikang.model.admin.AdminUser;
import com.anyikang.model.vo.admin.UserVo;
import com.anyikang.service.RescueTeamService;
import com.anyikang.service.admin.AdminPermissionService;
import com.anyikang.service.admin.AdminRoleService;
import com.anyikang.service.admin.AdminUserService;
import com.anyikang.utils.AssertUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@RestController
@RequestMapping("/admin/")
public class AdminUserController extends BaseController{
	@Autowired
	private AdminUserService adminUserService;
	@Autowired
	private AdminPermissionService aminPermissionService;
	@Autowired
	private AdminRoleService adminRoleService;
	@Resource
	private CredentialsMatcher credentialsMatcher;
	@Autowired
	private RescueTeamService rescueTeamService;

	/**
	 * 添加用户
	 * 
	 * @param userVo
	 * @return
	 */
	@RequestMapping("add/adminUser")
	@RequiresPermissions("user:add")
	public BaseResponse<?> addAdminUser(UserVo userVo) {
		BaseResponse<String> responseMessage = new BaseResponse<>();

		int bool = adminUserService.insert(userVo);
		if (bool != 0) {
			return responseMessage.success("成功");
		} else {
			return responseMessage.error("失败");
		}
	}
	
	/**
	 * 分页查询用户
	 * 
	 * @return
	 */
	@GetMapping("query/adminUser")
	@RequiresPermissions("user:query")
    public BaseResponse<?> queryAdminUser(int size,int current,@RequestParam(required=false)String userName,String tokenId) {
		@SuppressWarnings("rawtypes")
		BaseResponse<PageInfo> responseMessage = new BaseResponse<>();
		int userId = Integer.valueOf(tokenId.split("==")[1]);
		int number = adminUserService.findByUserId(userId);
		int roleId=0;
		if(number==1){
			roleId=4;
		}
		PageMethod.startPage(current, size);
        PageInfo<?> pageInfo=page(adminUserService.selectAdminUserAll(roleId,userName));
		responseMessage.setData(pageInfo);
		return responseMessage;
	}

	/**
	 * 根据用户Id查询用户
	 * 
	 * @param usersId
	 * @return
	 */
	@GetMapping("query/adminUserId")
	public BaseResponse<?> queryAdminUserId(Integer usersId) {
		BaseResponse<HashMap> responseMessage = new BaseResponse<>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		AdminUser adminUser = adminUserService.selectById(usersId);
		List<AdminRole> adminRoleList = adminRoleService.selectRoleAll();
		
		RescueCenter rescueTeam= rescueTeamService.selectById(adminUser.getRescueTeamId());
		
		List<AdminRole> roleList=adminRoleService.selectByUserId(usersId);
		adminUser.setRoleList(roleList);
		
		map.put("adminRoleList", adminRoleList);
		map.put("adminUser", adminUser);
		map.put("rescueTeam", rescueTeam);
		responseMessage.setData(map);
		return responseMessage;
	}

	/**
	 * 修改用户
	 * @param userVo
	 * @return
	 */
    @PostMapping("update/adminUser")
    @RequiresPermissions("user:edit")
    public BaseResponse<?> updateAdminUser(UserVo userVo){
        BaseResponse<Integer> responseMessage = new BaseResponse<>();
        int result = adminUserService.update(userVo);
        responseMessage.setData(result);
        return responseMessage;
    }

    /**
     * 删除用户
     * @param usersId
     * @return
     */
    @GetMapping("del/adminUser")
    @RequiresPermissions("user:del")
    public BaseResponse<?> delAdminUser(Integer usersId){
        AssertUtil.notEmpty(usersId, "需重新登陆获取");
        BaseResponse<Integer> responseMessage = new BaseResponse<>();
        int reuslt = adminUserService.delete(usersId);
        responseMessage.setData(reuslt);
        return responseMessage;
    }


}
