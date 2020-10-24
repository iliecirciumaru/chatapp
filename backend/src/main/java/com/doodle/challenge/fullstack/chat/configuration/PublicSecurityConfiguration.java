package com.doodle.challenge.fullstack.chat.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class PublicSecurityConfiguration extends WebSecurityConfigurerAdapter {
//  private final String[] loginUrl = {"/login"};
//  private final String[] healthUrls = {"/health", "/ready"};
//  private final String[] swaggerUrls = {
//      "/v2/api-docs",
//      "/configuration/ui",
//      "/swagger-resources/**",
//      "/configuration/security",
//      "/swagger-ui.html",
//      "/webjars/**",
//      "/documentation/swagger/**"
//  };

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http
////      .requestMatcher(request -> request.getMethod().equals("OPTIONS"))
//
//      .authorizeRequests()
//        .antMatchers("**")
//        .permitAll();
//  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
        .mvcMatchers("/**");
  }
}
