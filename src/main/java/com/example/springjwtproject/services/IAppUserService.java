package com.example.springjwtproject.services;

import com.example.springjwtproject.domain.AppUser;
import com.example.springjwtproject.domain.Role;

import java.util.List;

public interface IAppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role user);
    void addRoleToUser(String username, String roleName);
    AppUser getUser (String username);
    List<AppUser> getUsers();
}
