package org.bedoing.service;

import org.bedoing.entity.LoginAccount;
import org.bedoing.vo.LoginAccountVO;
import org.bedoing.vo.UserRegVO;

import java.util.List;


public interface IUserService {

	LoginAccount saveLoginAccount(UserRegVO user);

	int countByLoginAccount(String loginAccount);

	List<LoginAccountVO> findUserByCriteria(Object obj);
	
}
