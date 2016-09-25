package org.bedoing.blog.service.impl;

import org.bedoing.blog.commons.DictParam;
import org.bedoing.blog.constant.MapperConstant;
import org.bedoing.blog.entity.LoginAccount;
import org.bedoing.blog.entity.LoginLog;
import org.bedoing.blog.mybatis.MyBatisDAO;
import org.bedoing.blog.security.EndecryptUtil;
import org.bedoing.blog.service.IUserService;
import org.bedoing.blog.util.DateUtils;
import org.bedoing.blog.vo.LoginAccountVO;
import org.bedoing.blog.vo.UserRegVO;
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
	
	@Override
	public void saveLoginLog(LoginLog loginLog) {
		loginLog.setOprTime(new Date());
		myBatisDAO.save(MapperConstant.LOGINLOG_saveLoginLog, loginLog);
	}
	
	@Override
	public void saveLoginAccount(UserRegVO user) {
		LoginAccount loginAccount = new LoginAccount();
		
		loginAccount.setAccountName(user.getLoginAccount());
		loginAccount.setPassword(EndecryptUtil.decrypt(user.getPassword()));
		loginAccount.setRole(user.getRole());
		loginAccount.setMobilePhone(user.getMobilePhone());
		loginAccount.setSex(user.getSex());
		loginAccount.setNickname(user.getNickname());
		loginAccount.setHeadimgurl(user.getHeadimgurl());
		loginAccount.setCountry(user.getCountry());
		loginAccount.setCity(user.getCity());
		loginAccount.setProvince(user.getProvince());
		loginAccount.setCreateTime(new Date());
		loginAccount.setStatus(1);
		
		myBatisDAO.save(MapperConstant.LOGINACCOUNT_saveLoginAccount, loginAccount);
	};
	
	@Override
	public int countByLoginAccount(String loginAccount) {
		return myBatisDAO.get(MapperConstant.LOGINACCOUNT_countByLoginAccount, loginAccount);
	};

	@Override
	public List<LoginAccountVO> findUserByCriteria(Object obj) {
		List<LoginAccount> list = myBatisDAO.getList(MapperConstant.LOGINACCOUNT_findUserByCriteria, obj);
		List<LoginAccountVO> result = new ArrayList<LoginAccountVO>();
		for (LoginAccount user : list) {
			LoginAccountVO vo = new LoginAccountVO();
			vo.setId(user.getId());
			vo.setAccountName(user.getAccountName());
			vo.setPassword(user.getPassword());
			vo.setRole(user.getRole());
			vo.setMobilePhone(user.getMobilePhone());
			vo.setSex(user.getSex());
			vo.setNickname(user.getNickname());
			vo.setHeadimgurl(user.getHeadimgurl());
			vo.setCountry(user.getCountry());
			vo.setCity(user.getCity());
			vo.setProvince(user.getProvince());
			vo.setCreateTime(user.getCreateTime());
			vo.setStatus(user.getStatus());
			
			vo.setRoleStr(DictParam.getRole(user.getRole()));
			vo.setSexStr(DictParam.getSexStr(user.getSex()));
			vo.setCreateTimeStr(DateUtils.formatDate(user.getCreateTime(), DictParam.getDateFormat(0)));
			vo.setStatusStr(DictParam.getUserStatus(user.getStatus()));
			
			result.add(vo);
		}
		
		return result;
	};
	
}
