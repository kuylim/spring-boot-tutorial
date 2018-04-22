package com.wordpress.kuylim.springbootdemo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

  @Inject
  @Qualifier(value = "CustomUserDetailService")
  private UserDetailsService userDetailsService;

  @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
    authenticationManagerBuilder.eraseCredentials(false)
      .userDetailsService(userDetailsService)
      .passwordEncoder(passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    return  passwordEncoder;
  }

  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception{
    httpSecurity
      .authorizeRequests()
      .antMatchers("/").permitAll()
      .antMatchers("/home/**").hasAnyRole("USER");

    httpSecurity
      .formLogin()
      .loginPage("/login")
      .usernameParameter("username")
      .passwordParameter("password")
      .permitAll();

    httpSecurity.csrf().disable();
  }
}
