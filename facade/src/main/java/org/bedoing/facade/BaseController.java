package org.bedoing.facade;

import org.bedoing.constant.Constant;
import org.bedoing.entity.LoginAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {

	@SuppressWarnings("unchecked")
	protected <T> T getSessionValue(String sessionKey,HttpServletRequest request){
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(sessionKey);
		if(null != obj){
			return (T)obj;
		}		
		return null;
	}
	
	 protected LoginAccount getUserInfo(HttpServletRequest request){
		return getSessionValue(Constant.SESSION_USER, request);
	 }
	 
	 protected void setSessionAttribute(String name, Object objValue, HttpServletRequest request) {
		 HttpSession session = request.getSession();
		 session.setAttribute(name, objValue);
	}
}
