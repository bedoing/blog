package org.bedoing.util;

import org.bedoing.entity.LoginAccount;
import org.bedoing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by ejiggun on 10/19/2016.
 */
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        LoginAccount user = userRepository.findByAccountName(userName);
        if(user == null)
            throw new UsernameNotFoundException("userName: " + userName + " not found.");
        return new SecurityUser(user);
    }
}
