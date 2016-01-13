package org.bedoing.blog.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserLoginAspect {
	private static final Logger log = Logger.getLogger(UserLoginAspect.class);
	
	@Pointcut("execution(public * org.bedoing.blog.controller.UserController.login(..))")
	public void userLoginLog(){}
	
	@Pointcut("execution(public * org.bedoing.blog.controller.UserController.logout(..))")
	public void userLogoutLog(){}
	
	@After(value = "userLoginLog()")
	public void doLoginAfter(JoinPoint joinPoint){
	}
	
	@After(value = "userLogoutLog()")
	public void doLogoutBefore(JoinPoint joinPoint){
		
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
}
