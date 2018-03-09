package com.anyikang.controller.web;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.BaseController;
import com.anyikang.base.BaseResponse;
import com.anyikang.base.Constants;
import com.anyikang.base.ResponseMSG;
import com.anyikang.model.Payer;
import com.anyikang.model.vo.admin.UserCredentials;
import com.anyikang.service.PaymentService;
import com.anyikang.utils.AssertUtil;
import com.anyikang.utils.StringRedisUtil; 



/**
 * 支付业务处理
 * @author LvXiaoxiong
 * @date 2017/08/25
 *
 */
@RestController
@RequestMapping("web/payer")
public class PaymentController extends BaseController {
	
	
    @Autowired
    private PaymentService paymentService;
    
    /**
     * 注册
     * @param phone
     * @param password
     * @param nickName
     * @return
     */
	@PostMapping(value = "/register")
	public Object register(@RequestParam("mobile") String mobile,
			               @RequestParam("password") String password) {
		BaseResponse<Payer> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
		if (paymentService.findByPhone(mobile) != null) {
			return new BaseResponse<Object>(ResponseMSG.ERROR, "手机号已占用！", null);
		}
		Payer appUser = new Payer();
		appUser.setCreateTime(new Date());
		appUser.setMobile(mobile);
		appUser.setPassword(password);
		boolean flag =paymentService.insertPayer(appUser);
		if(flag){
			baseResponse.setData(appUser);
			baseResponse.setStatus(1);
			return baseResponse;
		}
		baseResponse.setData(appUser);
		baseResponse.setStatus(0);
		return baseResponse;
	}
    
    
	 /**
     * 监护人登录
     * @param request
     * @param userName
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public BaseResponse<?> appUserLogin(HttpServletRequest request,String userName, String password){
    	BaseResponse<UserCredentials> responseMessage = new BaseResponse<>();
    	responseMessage.setTime(System.currentTimeMillis());
        if(userName == null||password==null ){
        	responseMessage.setStatus(0);
        	responseMessage.setMsg("用户名或者密码不能为空");
            return  responseMessage;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mobile", userName);
        map.put("password", password);
//        Md5Hash md5Hash=new Md5Hash(password, userName,2);
//        map.put("password", md5Hash.toString());
        
        List<Payer> userList =  paymentService.selectByMap(map);
        AssertUtil.notEmpty(userList, "账号或密码错误");
        String tokenId =  StringRedisUtil.get(Constants.CACHE_TOKNID+userList.get(0).getUserId());//从缓存获取token
        
        
        Map<String,Object> maps=new HashMap<>(); 
        maps.put("userId", userList.get(0).getUserId());
        maps.put("mobile", userList.get(0).getMobile());
        maps.put("password", userList.get(0).getPassword());
        maps.put("token", tokenId);
        maps.put("userCreateTime", userList.get(0).getCreateTime().getTime());
        
        responseMessage.setStatus(1);
        responseMessage.setObjectbean(maps);
        responseMessage.setMsg("登录成功！");
        responseMessage.setTime(System.currentTimeMillis());
        return responseMessage;
    }
    
    
    /**
     * 忘记密码
     * @param phone
     * @param newpw
     * @return
     */
    @PostMapping(value = "/forgetpw")
	public BaseResponse<?> forgetpw(@RequestParam(name = "mobile") String mobile,
			                         @RequestParam(name = "newpw") String newpw) {
    	BaseResponse<Object> baseResponse =new BaseResponse<>();
    	baseResponse.setTime(System.currentTimeMillis());
		Payer appUser = paymentService.findByPhone(mobile);
		if (appUser == null){
			baseResponse.setStatus(0);
			baseResponse.setMsg("您的账号未注册,请先注册");
            return  baseResponse;
		}
		boolean flag =paymentService.modifypwById(appUser.getUserId(), newpw);
        if(flag){
        	baseResponse.setStatus(1);
			baseResponse.setMsg("您的密码修改成功");
            return  baseResponse;
        }
        baseResponse.setStatus(1);
		baseResponse.setMsg("修改失败");
        return  baseResponse;
	}

    
    /**
     * 退出登录
     * @return
     */
    @PostMapping(value="/logout")
    public BaseResponse<?>  logout() {
        BaseResponse<String> responseMessage = new BaseResponse<>();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        responseMessage.setStatus(1);
        responseMessage.setMsg("退出成功");
        responseMessage.setTime(System.currentTimeMillis());
        return responseMessage;
    }
    


}
