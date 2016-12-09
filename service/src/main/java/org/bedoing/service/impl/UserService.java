package org.bedoing.service.impl;

import com.google.common.collect.Lists;
import org.bedoing.constant.MapperConstant;
import org.bedoing.constant.TableAttrConstant;
import org.bedoing.entity.LoginAccount;
import org.bedoing.mybatis.MyBatisDAO;
import org.bedoing.repository.UserRepository;
import org.bedoing.security.EndecryptUtil;
import org.bedoing.service.IUserService;
import org.bedoing.service.utils.Convertor;
import org.bedoing.util.ValidateUtils;
import org.bedoing.vo.LoginAccountVO;
import org.bedoing.vo.UserRegVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService{
	@Autowired
	private MyBatisDAO myBatisDAO;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public LoginAccount saveLoginAccount(UserRegVO user) {
		ValidateUtils.validateObject(TableAttrConstant.LOGIN_ACCOUNT, user);
		ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ACCOUNT_NAME, user.getLoginAccount());
		ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.PASSWORD, user.getPassword());

		LoginAccount loginAccount = Convertor.userRegVo2Po(user);

		loginAccount.setId(null);
		loginAccount.setCreateTime(new Date());
		loginAccount.setStatus(1);

		return userRepository.save(loginAccount);
	}
	
	@Override
	public int countByLoginAccount(String loginAccount) {
		ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ACCOUNT_NAME, loginAccount);

		return myBatisDAO.get(MapperConstant.LOGINACCOUNT_countByLoginAccount, loginAccount);
	}

	@Deprecated
	@Override
	public List<LoginAccountVO> findUserByCriteria(Object obj) {
		ValidateUtils.validateObject(TableAttrConstant.LOGIN_ACCOUNT, obj);

		List<LoginAccount> list = myBatisDAO.getList(MapperConstant.LOGINACCOUNT_findUserByCriteria, obj);
		List<LoginAccountVO> result = Lists.newArrayList();
		for (LoginAccount user : list) {
			LoginAccountVO vo = new LoginAccountVO();
			vo.setId(user.getId());
			vo.setAccountName(user.getAccountName());
			vo.setPassword(user.getPassword());
			vo.setRole(user.getRole());
			vo.setMobilePhone(user.getMobilePhone());
			vo.setSex(user.getSex());
			vo.setNickname(user.getNickname());
			vo.setHeadImgUrl(user.getHeadImgUrl());
			vo.setCountry(user.getCountry());
			vo.setCity(user.getCity());
			vo.setProvince(user.getProvince());
			vo.setCreateTime(user.getCreateTime());
			vo.setStatus(user.getStatus());
			
			result.add(vo);
		}
		
		return result;
	}
}
