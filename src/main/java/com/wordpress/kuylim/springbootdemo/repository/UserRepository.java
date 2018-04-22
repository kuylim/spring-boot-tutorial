package com.wordpress.kuylim.springbootdemo.repository;

import com.wordpress.kuylim.springbootdemo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
  User findByUsername(String username);
}
