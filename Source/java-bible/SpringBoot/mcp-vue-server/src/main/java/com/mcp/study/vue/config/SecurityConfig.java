package com.mcp.study.vue.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcp.study.vue.model.Hr;
import com.mcp.study.vue.model.RespBean;
import com.mcp.study.vue.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: KG
 * @description:
 * @date: Created in 17:55 2022/5/21
 * @modified by:
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private HrService hrService;

    /**
     * 密码加密
     *
     * @return org.springframework.security.crypto.password.PasswordEncoder
     * @author KG
     * @date 2022/5/21 17:57
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 校验用户
     *
     * @param auth
     * @author KG
     * @date 2022/5/21 17:58
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                .successHandler(new AuthenticationSuccessHandler() {// 登陆成功的回调
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        resp.getWriter();
                        PrintWriter out = resp.getWriter();
                        Hr hr = (Hr) authentication.getPrincipal();//登录用户的信息存在authentication中，取出，并强转成hr对象
                        hr.setPassword(null);
                        RespBean ok = RespBean.ok("登录成功", hr);
                        //String s = new ObjectMapper().writeValueAsString(hr);//登录成功后的用户转成字符串，这里时返回的respBean 信息
                        String s = new ObjectMapper().writeValueAsString(ok);
                        out.write(s);//写出去
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {// 登录失败的回调
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");//设置相应头为json格式
                        response.getWriter();
                        PrintWriter out = response.getWriter();
                        RespBean respBean = RespBean.error("登录失败");
                        if (exception instanceof LockedException) {
                            respBean.setMsg("账户被锁定，请联系管理员！");
                        } else if (exception instanceof CredentialsExpiredException) {
                            respBean.setMsg("密码过期，请联系管理员");
                        } else if (exception instanceof AccountExpiredException) {
                            respBean.setMsg("账户过期，请联系管理员");
                        } else if (exception instanceof DisabledException) {
                            respBean.setMsg("账户被禁用，请联系管理员");
                        } else if (exception instanceof BadCredentialsException) {
                            respBean.setMsg("用户名或密码错误");
                        }
                        out.write(new ObjectMapper().writeValueAsString(respBean));//写出去
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        response.getWriter();
                        PrintWriter out =  response.getWriter();

                        RespBean ok = RespBean.ok("注销成功！");
                        //String s = new ObjectMapper().writeValueAsString(hr);//登录成功后的用户转成字符串，这里时返回的respBean 信息
                        String s = new ObjectMapper().writeValueAsString(ok);
                        out.write(s);//写出去
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable();
    }
}
