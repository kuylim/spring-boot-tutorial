package com.wordpress.kuylim.springbootdemo.repository;

import com.wordpress.kuylim.springbootdemo.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, String> {
}
