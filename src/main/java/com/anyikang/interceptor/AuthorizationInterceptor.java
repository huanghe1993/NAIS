/**
 * 
 */
package com.anyikang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.anyikang.model.AppUser;

/**
 * @author wangwei
 * @date 2017年6月8日
 */
public class AuthorizationInterceptor implements HandlerInterceptor {
	
	private Logger logger = Logger.getLogger(AuthorizationInterceptor.class);

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.debug("=====preHandle====");
		response.setStatus(HttpStatus.SC_OK);
//		 String handlerValue = handler.toString();
//	        String[] methodStringArray = StringUtils.split(handlerValue);
//	        String methodName = methodStringArray[methodStringArray.length - 1];
	        
//	        String token = request.getHeader("token");
	        String token=request.getParameter("token");
	        if (token == null){
	        	response.sendError(0, "token非法");
	        	return false;
	        } 
	        
	        AppUser appUser = (AppUser) SecurityUtils.getSubject().getSession().getAttribute("user");
	        if (appUser == null){
	        	response.sendError(0, "该用户不存在");
	        	return false;
	        }
	        
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("=====postHandle====");

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("=====afterCompletion====");

	}

}
