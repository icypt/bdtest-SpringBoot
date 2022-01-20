package com.bdtest.learn.common.config;

import com.bdtest.learn.common.security.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;
    /**
     * 配置身份认证的数据源
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
    }

    /**
     * 配置web资源访问权限
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers("/static/**");
    }

    /**
     * 配置请求的访问权限
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
       http.authorizeRequests().//认证请求
               antMatchers("/toLogin", "/login").//匹配路径
               permitAll().//授权所有，匹配到的路径都可以访问系统
               anyRequest().//除以上允许访问的请求之外
               authenticated().// 要进行身份认证
               and().
               formLogin().//要配置自定义表单
               loginPage("/toLogin").//表单的请求路径
               loginProcessingUrl("/login").//表单提交路径
               usernameParameter("userName").//用户名称参数设置
               passwordParameter("password").//密码参数设置
               successForwardUrl("/loginSuccess").//身份认证成功以后，请求重定向到哪里
               failureForwardUrl("/loginFail").//身份认证失败以后，请求重定向到哪里
               and().
               logout().//要配置自定义退出
               logoutUrl("/loginOut").//自定义退出请求路径
               logoutSuccessUrl("/toLogin").//退出成功以后，跳转到那个页面
               invalidateHttpSession(true);//退出时，需不需要清除session
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
