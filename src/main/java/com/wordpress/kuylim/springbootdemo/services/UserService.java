package com.wordpress.kuylim.springbootdemo.services;

import com.wordpress.kuylim.springbootdemo.entity.User;
import com.wordpress.kuylim.springbootdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Inject
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void saveUser(User user){
    userRepository.save(user);
  }
}
