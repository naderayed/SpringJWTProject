package com.example.springjwtproject.services;


import com.example.springjwtproject.repo.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepo roleRepo;
}
