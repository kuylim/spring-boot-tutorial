package com.wordpress.kuylim.springbootdemo.services;

import com.wordpress.kuylim.springbootdemo.entity.Role;
import com.wordpress.kuylim.springbootdemo.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RoleService {
  private final RoleRepository roleRepository;

  @Inject
  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public void saveRole(List role){
    roleRepository.save(role);
  }

  public List<Role> getAllRole(){
    return (List<Role>) roleRepository.findAll();
  }
}
