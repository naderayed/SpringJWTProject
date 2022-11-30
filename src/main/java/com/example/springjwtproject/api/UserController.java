package com.example.springjwtproject.api;

import com.example.springjwtproject.domain.AppUser;
import com.example.springjwtproject.domain.Role;
import com.example.springjwtproject.services.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final AppUserService appUserService;

    @GetMapping("/users")
     @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<AppUser>> getUsers(){
       return ResponseEntity.ok().body(appUserService.getUsers());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<AppUser> getUser(@PathVariable("username") String username){
        return ResponseEntity.ok().body(appUserService.getUser(username));
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appuser){
        URI  uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveUser(appuser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> addRole(@RequestBody Role role){
        URI  uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        appUserService.addRoleToUser(form.getUsername(), form.getRoleName() );
        return ResponseEntity.ok().build();


    }



}
@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}

