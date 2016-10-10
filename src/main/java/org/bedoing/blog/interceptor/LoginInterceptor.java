package org.bedoing.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.bedoing.blog.constant.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	private static final Logger log = Logger.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		String uriStr = request.getRequestURI();
		log.debug(String.format("请求URI: %s ", uriStr));
		if(uriStr.indexOf("/admin") != -1) {
			Object obj = session.getAttribute(Constant.SESSION_USER);
			if(obj == null) {
				request.setAttribute(Constant.MSG, "登入账号过期，请重新登入！");
				request.getRequestDispatcher("/login").forward(request, response);
				
				return false;
		    }
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
}
