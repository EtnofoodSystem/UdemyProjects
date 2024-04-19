package com.mx.usersmsvc.repository;

import com.mx.usersmsvc.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users,Long> {
}
