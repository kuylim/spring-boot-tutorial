package com.wordpress.kuylim.springbootdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter{
  @Override
  public void addViewControllers(ViewControllerRegistry registry){
    registry.addViewController("/login").setViewName("login");
  }
}
