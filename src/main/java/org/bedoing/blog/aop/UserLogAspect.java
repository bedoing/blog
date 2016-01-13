package org.bedoing.blog.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.bedoing.blog.constant.Constant;
import org.springframework.stereotype.Component;

/**
 * 用户登陆日志
 * @author Ken
 *
 */
@Component
@Aspect
public class UserLogAspect {
	private static final Logger log = Logger.getLogger(UserLogAspect.class);
	
//	@Resource
//	private IUserService userService;
	
	@Pointcut("execution(public * org.bedoing.blog.controller.UserController.login(..))")
	public void userLoginLog(){}
	
	@Pointcut("execution(public * org.bedoing.blog.controller.UserController.logout(..))")
	public void userLogoutLog(){}
	
	@After(value = "userLoginLog()")
	public void doLoginAfter(JoinPoint joinPoint){
		log.info("doLoginAfter...");
		HttpServletRequest request = getRequest(joinPoint);
		
		if(null != request){
			Object obj = request.getSession().getAttribute(Constant.SESSION_USER);
		}
	}
	
	@Before(value = "userLogoutLog()")
	public void doLogoutBefore(JoinPoint joinPoint){
		log.info("doLogoutBefore...");
		HttpServletRequest request = getRequest(joinPoint);
		
		if(null != request){
			Object obj = request.getSession().getAttribute(Constant.SESSION_USER);
		}
	}
	
	private HttpServletRequest getRequest(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		HttpServletRequest request = null;
		for (int i = 0; i < args.length; i++) {
			log.info("args[i]: " + args[i]);
			if (args[i] instanceof HttpServletRequest) {
				request = (HttpServletRequest) args[i];  
            }
		}
		
		return request;
	}
	
	/**
	 * 获取客户端的IP地址
	*/
	private String getClientIp(HttpServletRequest request){
		String[] headers = {"x-forwarded-for", "Proxy-Client-IP", 
				"WL-Proxy-Client-IP", "X-Real-IP"};
		String ip = "";
		for (String header : headers) {
			ip = request.getHeader(header);
			if(StringUtils.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)){
				return ip;
			}
		}
		
		return request.getRemoteAddr();
	}
}
