package org.bedoing.blog.handler;

import org.bedoing.blog.vo.ResponseVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ken on 10/10/2016.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ResponseVO res = new ResponseVO();
        res.setRetMsg(e.getMessage());
        res.setErrNum("");
        res.setRetData(request.getRequestURL().toString());

        ModelAndView mv = new ModelAndView("/blog/error/error");
        mv.addObject("res", res);

        return mv;
    }

    /*@ExceptionHandler
    @ResponseBody
    public ResponseVO jsonErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ResponseVO res = new ResponseVO();
        res.setRetMsg(e.getMessage());
        res.setErrNum("");
        res.setRetData(request.getRequestURL().toString());
        return res;
    }*/
}
