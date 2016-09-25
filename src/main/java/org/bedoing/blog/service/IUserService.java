package org.bedoing.blog.service;

import java.util.List;

import org.bedoing.blog.entity.LoginAccount;
import org.bedoing.blog.entity.LoginLog;
import org.bedoing.blog.vo.LoginAccountVO;
import org.bedoing.blog.vo.UserRegVO;


public interface IUserService {
	
	void saveLoginLog(LoginLog loginLog);
	void saveLoginAccount(UserRegVO user);
	int countByLoginAccount(String loginAccount);
	List<LoginAccountVO> findUserByCriteria(Object obj);
	
}
