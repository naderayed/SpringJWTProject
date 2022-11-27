package com.example.springjwtproject.services;

import com.example.springjwtproject.domain.AppUser;
import com.example.springjwtproject.domain.Role;
import com.example.springjwtproject.repo.AppUserRepo;
import com.example.springjwtproject.repo.RoleRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserService implements IAppUserService {
    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        return appUserRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepo.findByUsername(username);
        Role role = roleRepo.findByNamerole(roleName);
        appUser.getRoles().add(role);
        //i don't have to call appUserRepo.save because this class is transactional
       // appUserRepo.save(appUser);

    }

    @Override
    public AppUser getUser(String username) {
        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return appUserRepo.findAll();
    }
}
