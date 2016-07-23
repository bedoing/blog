package org.bedoing.blog.handler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.bedoing.blog.constant.Constant;
import org.bedoing.blog.constant.UriConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理
 * @author guanjy
 *
 */
@Component
public class CustomExceptionHandler implements HandlerExceptionResolver {
	private static final Logger log = Logger.getLogger(CustomExceptionHandler.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception) {
		ModelAndView mv = new ModelAndView();
		StringBuffer str = new StringBuffer();
		for (StackTraceElement e : exception.getStackTrace()) {
			str.append("at ").append(e).append("<br />");
		}
		if(exception instanceof IOException){
			mv.addObject(Constant.TITLE, "IOException");
			mv.addObject(Constant.MSG, str.toString());
			mv.setViewName(UriConstant.ERROR_PAGE);
        }else if(exception instanceof SQLException){  
        	mv.addObject(Constant.TITLE, "SQLException");
        	mv.addObject(Constant.MSG, str.toString());
			mv.setViewName(UriConstant.ERROR_PAGE);
        }else if(exception instanceof NullPointerException) {
        	mv.addObject(Constant.TITLE, "NullPointerException");
        	mv.addObject(Constant.MSG, str.toString());
			mv.setViewName(UriConstant.ERROR_PAGE);
        }else{
        	mv.addObject(Constant.TITLE, "404");
        	mv.addObject(Constant.MSG, "这不是您要找的东西！");
			mv.setViewName(UriConstant.ERROR_PAGE);
        }
		
		exception.printStackTrace();
		
		return mv;
	}

}
