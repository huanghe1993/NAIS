/**
 * 
 */
package com.anyikang.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.anyikang.interceptor.ResponseInterceptor;

/**
 * @author wangwei
 * @date 2017年6月8日
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	
	private Logger logger = Logger.getLogger(InterceptorConfig.class);

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

//		registry.addInterceptor(new AuthorizationInterceptor())
//		.addPathPatterns("/api/**")
//		.excludePathPatterns("/api/user/login")
		
		registry.addInterceptor(new ResponseInterceptor()).addPathPatterns("/api/**")
		.excludePathPatterns("/web/**");
		
		
		super.addInterceptors(registry);
	}
	
	
	

}
