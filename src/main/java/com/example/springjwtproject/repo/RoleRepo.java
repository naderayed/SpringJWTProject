package com.example.springjwtproject.repo;

import com.example.springjwtproject.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByNamerole(String roleName);
}
