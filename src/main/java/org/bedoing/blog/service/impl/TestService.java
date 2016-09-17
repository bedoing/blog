package org.bedoing.blog.service.impl;

import org.bedoing.blog.entity.LoginAccount;
import org.bedoing.blog.entity.LoginLog;
import org.bedoing.blog.service.IUserService;
import org.bedoing.blog.vo.LoginAccountVO;
import org.bedoing.blog.vo.UserRegVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
@Service
public class TestService implements IUserService {
    @Override
    public void saveLoginLog(LoginLog loginLog) {

    }

    @Override
    public void saveLoginAccount(UserRegVO user) {

    }

    @Override
    public int countByLoginAccount(String loginAccount) {
        return 0;
    }

    @Override
    public LoginAccount findUserByLoginAccount(String loginAccount) {
        return null;
    }

    @Override
    public List<LoginAccountVO> findUserByCriteria(Object obj) {
        return null;
    }
}
