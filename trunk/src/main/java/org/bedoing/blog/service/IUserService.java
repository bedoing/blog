package org.bedoing.blog.service;

import java.util.List;

import org.bedoing.blog.po.LoginAccount;
import org.bedoing.blog.po.LoginLog;
import org.bedoing.blog.vo.LoginAccountVO;
import org.bedoing.blog.vo.UserRegVO;


public interface IUserService {
	
	public void saveLoginLog(LoginLog loginLog);
	public void saveLoginAccount(UserRegVO user);
	public int countByLoginAccount(String loginAccount);
	public LoginAccount findUserByLoginAccount(String loginAccount);
	public List<LoginAccountVO> findUserByCriteria(Object obj);
	
}
