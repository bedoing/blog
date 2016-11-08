package org.bedoing.util;

import org.bedoing.entity.LoginAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ken on 10/19/2016.
 */
public class SecurityUser extends LoginAccount implements UserDetails {

    public SecurityUser(LoginAccount user) {
        if(user != null) {
            this.setId(user.getId());
            this.setAccountName(user.getAccountName());
            this.setPassword(user.getPassword());
            this.setRole(user.getRole());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("" + this.getRole());
        authorities.add(authority);
        /*Set<SRole> userRoles = this.getSRoles();

        if(userRoles != null)
        {
            for (SRole role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }*/
        return authorities;

    }

    @Override
    public String getUsername() {
        return super.getAccountName();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
