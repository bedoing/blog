package org.bedoing.service.impl;

import org.bedoing.constant.TableAttrConstant;
import org.bedoing.entity.LoginLog;
import org.bedoing.repository.LoginLogRepository;
import org.bedoing.service.ILoginLogService;
import org.bedoing.util.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class LoginLogService implements ILoginLogService{

	@Autowired
	private LoginLogRepository loginLogRepository;
	
	@Override
	public void saveLoginLog(LoginLog loginLog) {
		ValidateUtils.validateObject(TableAttrConstant.LOGIN_LOG, loginLog);

		loginLog.setOprTime(new Date());
		loginLogRepository.save(loginLog);
	}
}
