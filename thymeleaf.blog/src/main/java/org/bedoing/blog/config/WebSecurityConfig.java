package org.bedoing.blog.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.bedoing.blog.handler.LoginSuccessHandler;
import org.bedoing.blog.repository.UserRepository;
import org.bedoing.blog.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource datasource;
    @Autowired
    private UserRepository userRepository;

    private static String[] authenUris = new String[]{"", ""};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin**", "/admin/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                //指定登录页是”/login”
                .loginPage("/login")
                .permitAll()
                //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
                .successHandler(loginSuccessHandler())//code3
                .and()
                .logout()
                //退出登录后的默认网址是”/home”
                .logoutSuccessUrl("/login")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                //登录后记住用户，下次自动登录
                //数据库中必须存在名为persistent_logins的表
                //建表语句见code15
                .rememberMe()
                .tokenValiditySeconds(1209600)
                //指定记住登录信息所使用的数据源
                .tokenRepository(tokenRepository());//code4

        //允许所有用户访问”/”和”/home”
        /*http.authorizeRequests().antMatchers("/", "/home", "/css/", "/js/", "/img/").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页是”/login”
                .loginPage("/login")
                .failureUrl("/login")
                .permitAll()
                //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
                .successHandler(loginSuccessHandler())//code3
                .and()
                .logout()
                //退出登录后的默认网址是”/home”
                .logoutSuccessUrl("/home")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                //登录后记住用户，下次自动登录
                //数据库中必须存在名为persistent_logins的表
                //建表语句见code15
                .rememberMe()
                .tokenValiditySeconds(1209600)
                //指定记住登录信息所使用的数据源
                .tokenRepository(tokenRepository());//code4*/

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(datasource);
        //指定密码加密所使用的加密器为passwordEncoder()
        //需要将密码加密后写入数据库 //code13
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());//code5
        auth.jdbcAuthentication().dataSource(datasource);
        //不删除凭据，以便记住用户
//        auth.eraseCredentials(false);*/
        auth.jdbcAuthentication().dataSource(datasource);
    }

    // Code5----------------------------------------------
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    // Code4----------------------------------------------
    @Bean
    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl j=new JdbcTokenRepositoryImpl();
        j.setDataSource(datasource);
        return j;
    }

    // Code3----------------------------------------------
    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();//code6
    }

}