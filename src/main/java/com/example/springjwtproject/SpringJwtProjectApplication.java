package com.example.springjwtproject;

import com.example.springjwtproject.domain.AppUser;
import com.example.springjwtproject.domain.Role;
import com.example.springjwtproject.services.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtProjectApplication.class, args);

    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(10);
    }
//    @Bean
//    CommandLineRunner run(AppUserService appUserService){
//        return args -> {
//
//         appUserService.saveRole(new Role(null,"ROLE_USER"));
//         appUserService.saveRole(new Role(null,"ROLE_MANAGER"));
//         appUserService.saveRole(new Role(null,"ROLE_ADMIN"));
//         appUserService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
//
//            appUserService.saveUser(new AppUser(null,"amine","1234","eamil@com",new ArrayList<>()));
//            appUserService.saveUser(new AppUser(null,"ali","1234","mail@com",new ArrayList<>()));
//            appUserService.saveUser(new AppUser(null,"med","1234","med@com",new ArrayList<>()));
//            appUserService.saveUser(new AppUser(null,"aziz","1234","aziz@com",new ArrayList<>()));
//
//             appUserService.addRoleToUser("amine","ROLE_USER");
//             appUserService.addRoleToUser("Naderayed","ROLE_MANAGER");
//             appUserService.addRoleToUser("Naderayed","ROLE_ADMIN");
//             appUserService.addRoleToUser("ali","ROLE_MANAGER");
//             appUserService.addRoleToUser("med","ROLE_ADMIN");
//             appUserService.addRoleToUser("aziz","ROLE_SUPER_ADMIN");
//
//
//        };
//    }

}
