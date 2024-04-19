package com.mx.usersmsvc.controller;

import com.mx.usersmsvc.entity.Users;
import com.mx.usersmsvc.service.UserserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Users")
@CrossOrigin("*")
public class UsersController {
    @Autowired
    UserserviceImpl userservice;

    @GetMapping("listUsers")
   public List<Users> listUsers() {
        return  userservice.listUsers();
    }
    @GetMapping("searchUser/{id}")
    public ResponseEntity<?> searchUser(@PathVariable Long id) {
        Optional<Users> user = userservice.getUser(id);
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("createUser")
    ResponseEntity<?> createUser(@RequestBody Users user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userservice.createUser(user));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Users user) {
        Optional<Users> user1 = userservice.getUser(id);
        if(user1.isPresent()) {
            Users users = user1.get();
            users.setId(id);
            users.setEmail(user.getEmail());
            users.setPassword(user.getPassword());
            users.setUsername(user.getUsername());
            return ResponseEntity.status(HttpStatus.CREATED).body(userservice.createUser(users));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<Users> user = userservice.getUser(id);
        if(user.isPresent()) {
            userservice.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
