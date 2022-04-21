package com.example2.demo1.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.annotation.Resource;

@Configuration
@EnableResourceServer
public class ResourceServiceConfig  extends ResourceServerConfigurerAdapter {

//    @Resource
//    private UserAuthenticationEntryPoint userAuthenticationEntryPoint;
//
//    @Resource
//    private UserAccessDeniedHandler userAccessDeniedHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("rid");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 放行oauth2的请求
        http.authorizeRequests()
                .antMatchers("/mobile/homepage/json").permitAll();

        http.authorizeRequests()
                .antMatchers("/type/**").hasAnyRole("admin","ADMIN")
                .antMatchers("/type2/**").hasRole("ADMIN")
                .anyRequest().authenticated();

          // 异常处理
//        //access deny
//        http.exceptionHandling().accessDeniedHandler(userAccessDeniedHandler);
//        //unauthorized
//        http.exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint);
    }
}
