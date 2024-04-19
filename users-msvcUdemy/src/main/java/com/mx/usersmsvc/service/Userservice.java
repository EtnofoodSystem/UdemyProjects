package com.mx.usersmsvc.service;

import com.mx.usersmsvc.entity.Users;

import java.util.List;
import java.util.Optional;

public interface Userservice {
    List<Users> listUsers();
    Optional<Users> getUser(Long id);
    Users createUser(Users user);
    Users updateUser(Users user);
    void deleteUser(Long id);
}
