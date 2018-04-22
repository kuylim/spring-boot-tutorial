package com.wordpress.kuylim.springbootdemo.controller.api;

import com.wordpress.kuylim.springbootdemo.entity.Role;
import com.wordpress.kuylim.springbootdemo.services.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

  private final RoleService roleService;

  @Inject
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping
  public String saveRole(){

    List<Role> roles = new ArrayList<>();

    Role role1 = new Role();
    role1.setId("1");
    role1.setName("ROLE_USER");

    Role role = new Role();
    role.setName("ROLE_ADMIN");
    role.setId("2");

    roles.add(role);
    roles.add(role1);

    roleService.saveRole(roles);

    return "Save role success!!";
  }
}
