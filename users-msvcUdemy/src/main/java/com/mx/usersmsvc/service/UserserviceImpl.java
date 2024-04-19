package com.mx.usersmsvc.service;

import com.mx.usersmsvc.entity.Users;
import com.mx.usersmsvc.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserserviceImpl implements  Userservice{
    @Autowired
    UsersRepo usersRepo;
    @Override
    @Transactional(readOnly = true)
    public List<Users> listUsers() {
        return (List<Users>) usersRepo.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Users> getUser(Long id) {
        return usersRepo.findById(id);
    }

    @Override
    @Transactional
    public Users createUser(Users user) {
        return usersRepo.save(user);
    }

    @Override
    public Users updateUser(Users user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        usersRepo.deleteById(id);
    }
}
