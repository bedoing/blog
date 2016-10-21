package org.bedoing.service;

import org.bedoing.entity.LoginLog;
import org.bedoing.vo.LoginAccountVO;
import org.bedoing.vo.UserRegVO;

import java.util.List;


public interface IUserService {
	
	void saveLoginLog(LoginLog loginLog);
	void saveLoginAccount(UserRegVO user);
	int countByLoginAccount(String loginAccount);
	List<LoginAccountVO> findUserByCriteria(Object obj);
	
}
