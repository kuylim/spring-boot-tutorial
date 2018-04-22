package com.wordpress.kuylim.springbootdemo.services;

import com.wordpress.kuylim.springbootdemo.entity.User;
import com.wordpress.kuylim.springbootdemo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Service("CustomUserDetailService")
@Transactional
public class CustomUserService implements UserDetailsService {

  private final UserRepository userRepository;

  @Inject
  public CustomUserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

    User user = userRepository.findByUsername(s);

    if(user == null){
      System.out.println("User not found!!");
    }
    return user;
  }
}
