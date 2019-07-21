package com.anyikang.components.shiro;

import com.anyikang.base.BaseResponse;
import com.anyikang.base.Constants;
import com.anyikang.exception.MyException;
import com.anyikang.utils.AssertUtil;
import com.anyikang.utils.StringRedisUtil;
import com.anyikang.utils.WebUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 访问控制过滤器
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public class StatelessAccessControlFilter extends AccessControlFilter {
	private static final Logger logger = LoggerFactory.getLogger(StatelessAccessControlFilter.class);

	@Override
	protected boolean isAccessAllowed(ServletRequest request,ServletResponse response, Object mappedValue) throws Exception {
		String requestURL = getPathWithinApplication(request);
        if(requestURL.endsWith("/")){
            return  true;
        }
		return false;
	}

	/**
	 * onAccessDenied：表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；
	 * 如果返回false表示该拦截器实例已经处理了，将直接返回即可。
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request,ServletResponse response) throws Exception {
		// 1、客户端生成的消息摘要
		String clientDigest = request.getParameter("digest");
		String tokenId = request.getParameter("tokenId");
		// 2、客户端传入的用户身份
		String username = request.getParameter("userName");
//		String userId = request.getParameter("userId");
		String userId = "";
		String password = request.getParameter("password");
		
	
        
		String requestURL = getPathWithinApplication(request);// 获取url
		Boolean isLogin = false;
		// 3、客户端请求的参数列表
		Map<String, String[]> params = new HashMap<String, String[]>(request.getParameterMap());
		params.remove("digest");// 为什么要移除呢？签名或者消息摘要算法的时候不能包含digest.

		logger.info("StatelessAuthenticationToken(username= " + username + "  clientDigest= " + clientDigest);
		// 4、生成无状态Token
		// 用户名，参数，客户端需验证的密码
		try {
			StatelessAuthenticationToken token = new StatelessAuthenticationToken(username, params, clientDigest);
			// 4、如当前URL匹配拦截器名字（URL模式）
			if (requestURL.endsWith("login")) {// 如为登陆，就只对密码进行加密
				//加密后进行匹配
		        Md5Hash md5Hash=new Md5Hash(password);
		        password= md5Hash.toString();
				AssertUtil.notEmpty(username, "用户名不能为空.");
				token.setClientDigest(password);
				token.setLogin(true);
			} else {
				AssertUtil.notEmpty(tokenId, "请先登陆获取授权.");
				userId=StringUtils.split(tokenId, "==")[1];
				AssertUtil.notEmpty(userId, "用户ID不能为空.");
				token.setTokenId(tokenId);
				token.setUserName(userId);
				token.setClientDigest(tokenId);
				token.setLogin(false);
				
				String key=Constants.CACHE_TOKNID+userId;
				String value= StringRedisUtil.get(key);
				if(value!=null){
					StringRedisUtil.setHours(key,value, Constants.CACHE_TOKENID_TIME);//设置Token
				}
			}
			Subject subject = getSubject(request, response);
			subject.login(token);
		}catch (MyException ex){
			onLoginFail(response, ex.getMessage(), 5);
           return false;
       } catch (UnauthorizedException e){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            onLoginFail(response, e.getMessage(), httpResponse.SC_UNAUTHORIZED);
            return false;
        }catch (IncorrectCredentialsException e){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            onLoginFail(response, "密码错误", httpResponse.SC_UNAUTHORIZED);
        }catch (Exception e) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            if(e.getCause() != null ){
            	onLoginFail(response,e.getCause().getMessage(), Constants.SHIRO_ERROR);
            }else{
            	onLoginFail(response, e.getMessage(), httpResponse.SC_UNAUTHORIZED);
            }
           e.printStackTrace();
           return false;
       }
		return true;
	}
	
	/**
	 * 登录失败时默认返回401状态码  
	 * @param response
	 * @param message
	 * @param code
	 */
	private void onLoginFail(ServletResponse response, String message, int code){
	       HttpServletResponse httpResponse = (HttpServletResponse) response;
	       BaseResponse<String> responseMessage = new BaseResponse<>();
	       responseMessage.setCode(code);//错误码
	       responseMessage.setError(message);
	       WebUtil.responseWrit(httpResponse, responseMessage);
	    }
	

}
