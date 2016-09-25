package org.bedoing.blog.facade;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.bedoing.blog.constant.Constant;
import org.bedoing.blog.constant.UriConstant;
import org.bedoing.blog.entity.LoginAccount;
import org.bedoing.blog.repository.UserRepository;
import org.bedoing.blog.security.EndecryptUtil;
import org.bedoing.blog.service.IUserService;
import org.bedoing.blog.vo.UserRegVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 
 * @author Ken
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	private static final Logger log = Logger.getLogger(UserController.class);
	
	@Resource
	private IUserService userService;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/login", method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String userLogin(@RequestBody LoginAccount loginAccount, HttpServletRequest request) {
		String returnUrl = UriConstant.ADMIN_INDEX;
		String msg = "";
		if(StringUtils.isBlank(loginAccount.getAccountName())) {
			msg = "登陆账号不能为空      ";
		}
		if(StringUtils.isBlank(loginAccount.getPassword())) {
			msg += "密码不能为空";
		}
		
		if(StringUtils.isNotBlank(msg)) {
			returnUrl = UriConstant.ADMIN_LOGIN;
			/*return new ModelAndView(UriConstant.ADMIN_LOGIN).addObject(Constant.MSG, msg)
					.addObject("loginAccount", loginAccount)
					.addObject("password", loginAccount.getPassword());*/
		}
		
		LoginAccount user = userRepository.findByAccountName(loginAccount.getAccountName());
		if(null == user || !user.getPassword().equals(EndecryptUtil.encrypt(loginAccount.getPassword()))) {
			returnUrl = UriConstant.ADMIN_LOGIN;
			/*return new ModelAndView(UriConstant.ADMIN_LOGIN).addObject(Constant.MSG, "不存在账号或密码错误")
					.addObject("loginAccount", loginAccount)
					.addObject("password", loginAccount.getPassword());*/
		}
		
		setSessionAttribute(Constant.SESSION_USER, user, request);
		
//		return new ModelAndView(UriConstant.ADMIN_INDEX);
		return returnUrl;
	}
	
	@RequestMapping(value = "/logout", method = {GET, POST}, produces = MediaType.APPLICATION_JSON_VALUE)
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		Object obj = getSessionValue(Constant.SESSION_USER, request);
		if(null != obj) {
			setSessionAttribute(Constant.SESSION_USER, null, request);
			request.setAttribute(Constant.MSG, "登出成功!");
		}
		try {
			request.getRequestDispatcher("/app/place/login").forward(request, response);
		} catch (ServletException | IOException e) {
			log.error(e);
		}
	}
	
	@RequestMapping(value = "/join", method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView registe(@Valid UserRegVO user, BindingResult br, HttpServletRequest request){
		log.info(JSON.toJSONString(user));
		String msg = "";
		if(br.hasErrors()){
			for (int i = br.getFieldErrors().size() - 1; i >= 0; i--) {
				FieldError fe = br.getFieldErrors().get(i);
				msg += fe.getDefaultMessage() + ", ";
			}
		}else{
			int sum = userService.countByLoginAccount(user.getLoginAccount());
			if(sum > 0) {
				msg = "已存在账号";
			}
		}
		
		if(StringUtils.isNotBlank(msg)) {
			return new ModelAndView(UriConstant.DEFAULT_REGISTE).addObject(Constant.MSG, msg).addObject(Constant.PAGE_USER, user);
		}
		
		userService.saveLoginAccount(user);
		
		return new ModelAndView(UriConstant.DEFAULT_DEFAULT);
	}
}
