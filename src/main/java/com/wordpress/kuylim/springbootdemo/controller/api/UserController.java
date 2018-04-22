package com.wordpress.kuylim.springbootdemo.controller.api;

import com.wordpress.kuylim.springbootdemo.entity.User;
import com.wordpress.kuylim.springbootdemo.services.RoleService;
import com.wordpress.kuylim.springbootdemo.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  private final UserService userService;
  private final RoleService roleService;

  @Inject
  public UserController(UserService userService, RoleService roleService) {
    this.userService = userService;
    this.roleService = roleService;
  }

  @GetMapping
  public String saveUser(){

    User user = new User();

    user.setId("1");
    user.setUsername("Jhon");
    user.setPassword("12345");
    user.setRoles(roleService.getAllRole());

    userService.saveUser(user);

    return "Save success!!";
  }
}
