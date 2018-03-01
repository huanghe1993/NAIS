package com.anyikang.controller.admin;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.BaseController;
import com.anyikang.base.BaseResponse;
import com.anyikang.model.admin.AdminPermission;
import com.anyikang.model.vo.admin.PermissionVo;
import com.anyikang.service.admin.AdminPermissionService;
import com.anyikang.utils.AssertUtil;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@RestController
@RequestMapping("/adminPermission/")
public class AdminPermissionController extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(AdminPermissionController.class);
    @Autowired
    private AdminPermissionService aminPermissionService;
    
    /**
     * 查询所有的权限以及相关用户的角色资源
     * @param roleId
     * @return
     */
    @RequestMapping({"/queryAdminPermission"})
    public BaseResponse<?> queryAdminPermissionAll(@RequestParam(value="roleId", required = false, defaultValue = "0") Integer roleId){
        logger.info("roleId= " + roleId);
        BaseResponse<HashMap> responseMessage = new BaseResponse<>();
        List<AdminPermission> permissionListAll =  aminPermissionService.selectPermissionAll();
        List<AdminPermission> permissionListUser =  null;
        if(roleId != 0){
            permissionListUser = aminPermissionService.selectPermissionRoseId(roleId);
        }
        HashMap<String,  List<AdminPermission>> map = new HashMap<String,  List<AdminPermission>> ();
        map.put("allList", permissionListAll);
        map.put("userList", permissionListUser);

        responseMessage.setData(map);
        return responseMessage;
    }

    @GetMapping("refresh/adminPermission")
    public BaseResponse<?>  refreshaAminPermission(Integer roleId,  Integer permissionId){
        BaseResponse<HashMap>  responseMessage = new BaseResponse<>();
        List<AdminPermission> permissionListRole =  aminPermissionService.refreshaAminPermission(roleId, permissionId);
        HashMap<String,  List<AdminPermission>> map = new HashMap<String,  List<AdminPermission>> ();
        map.put("roleList", permissionListRole);
        responseMessage.setData(map);
        return responseMessage;
    }

    /**
     * 查询菜单列表数据
     * @return
     */
    @RequestMapping({"/query/adminPermissionList"})
    @RequiresPermissions("menu:query")
    public BaseResponse<?> adminPermissionList(int size,int current,@RequestParam(required=false)String menuName){

        BaseResponse<PageInfo> responseMessage = new BaseResponse<>();
        PageMethod.startPage(current, pageSize);
        PageInfo pageInfo=page(aminPermissionService.selectPermissionPageParentId(1,menuName));
        responseMessage.setData(pageInfo);
        return responseMessage;
    }

    /**
     * 查询按钮
     * @param roleId
     * @param permissionId
     * @return
     */
    @GetMapping("query/adminPermissionButton")
    public BaseResponse<?>  queryPermissionButton(Integer roleId,  Integer permissionId){
        BaseResponse<List<AdminPermission>> responseMessage = new BaseResponse<>();
        //是否显示按钮
        List<AdminPermission> permissionButtons =  aminPermissionService.refreshaAminPermission(roleId, permissionId);
        responseMessage.setData(permissionButtons);
        return responseMessage;
    }



    /**
     * 查询菜单，不传值默认为父菜单
     * @param permissionId
     * @return
     */
    @RequestMapping({"/query/parentPermission"})
    public BaseResponse<?> queryParentPermission(@RequestParam(value="permissionId", required = false, defaultValue = "1") Integer permissionId){
        logger.info("permissionId= " + permissionId);
        BaseResponse<List<AdminPermission>> responseMessage = new BaseResponse<>();
        List<AdminPermission>  permissionList =  aminPermissionService.selectPermissionParentId(permissionId);
        responseMessage.setData(permissionList);
        return responseMessage;
    }

    /**
     * 查询子菜单详情
     * @param permissionId
     * @return
     */
    @RequestMapping({"/query/queryPermissionInfo"})
    public BaseResponse<?> queryPermissionInfo(Integer permissionId){
        logger.info("permissionId= " + permissionId);
        HashMap<String, Object> map = new HashMap<String, Object> ();
        BaseResponse<HashMap> responseMessage = new BaseResponse<>();
        AdminPermission adminPermission =  aminPermissionService.selectById(permissionId);

        List<AdminPermission>  parentPermissionList =  aminPermissionService.selectPermissionParentId(1);
        List<AdminPermission>  subPermissionList = null;
        if(adminPermission != null && adminPermission.getPermissionParentId() != 1 && adminPermission.getPermissionTypeId() == 1){//不等于父菜单也不等于按钮,初始化子菜单
            subPermissionList = aminPermissionService.querySubPermission(adminPermission.getPermissionParentId());
        }else if(adminPermission != null && adminPermission.getPermissionTypeId() == 2){//等于按钮
            AdminPermission parentPermission= aminPermissionService.selectById(adminPermission.getPermissionParentId());
            if(parentPermission != null){
                subPermissionList = aminPermissionService.querySubPermission(parentPermission.getPermissionParentId());
            }
        }

        map.put("adminPermission", adminPermission);
        map.put("parentPermissionList", parentPermissionList);
        map.put("subPermissionList", subPermissionList);
        responseMessage.setData(map);
        return responseMessage;
    }

    /**
     * 查询子菜单
     * @param roleId
     * @param permissionId
     * @return
     */
    @RequestMapping({"/query/subPermission"})
    public BaseResponse<?> querySubPermission(Integer roleId, Integer permissionId){
        BaseResponse<List<AdminPermission>> responseMessage = new BaseResponse<>();
        List<AdminPermission>  permissionList = aminPermissionService.querySubPermission(permissionId);
        responseMessage.setData(permissionList);
        return responseMessage;
    }
    
    /**
     * 添加菜单
     * @param permissionVo
     * @param request
     * @return
     */
    @RequestMapping({"/add/adminPermission"})
    @RequiresPermissions("menu:add")
    public BaseResponse<?>addAdminPermission(PermissionVo permissionVo, HttpServletRequest request){
        String roleId = request.getParameter("roleId");
        AssertUtil.notEmpty(roleId, "角色ID不能为空");
        BaseResponse<String> responseMessage = new BaseResponse<>();
        aminPermissionService.insert(permissionVo,Integer.parseInt(roleId));
        responseMessage.setData("成功");
        return responseMessage;
    }

    /**
     * 修改菜单
     * @param permissionVo
     * @return
     */
    @RequestMapping({"/edit/adminPermission"})
    @RequiresPermissions("menu:edit")
    public BaseResponse<?>editAdminPermission(PermissionVo permissionVo){
        BaseResponse<String> responseMessage = new BaseResponse<>();
        aminPermissionService.update(permissionVo);
        responseMessage.setData("成功");
        return responseMessage;
    }

    /**
     * 删除菜单
     * @param permissionId
     * @return
     */
    @RequestMapping({"/del/adminPermission"})
    @RequiresPermissions("menu:del")
    public BaseResponse<?>delAdminPermission(Integer permissionId){
        BaseResponse<String> responseMessage = new BaseResponse<>();
        int result = aminPermissionService.delete(permissionId);
        if(result != 0){
            return  responseMessage.success("删除成功");
        }else {
            return  responseMessage.error("请先删除子菜单");
        }
    }

}
