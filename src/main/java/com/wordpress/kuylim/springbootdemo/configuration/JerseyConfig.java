package com.wordpress.kuylim.springbootdemo.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api/v2")
public class JerseyConfig extends ResourceConfig {
  public JerseyConfig(){
    packages("com.wordpress.kuylim.springbootdemo.resources");
  }
}
