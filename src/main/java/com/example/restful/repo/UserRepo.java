package com.example.restful.repo;

import com.example.restful.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

  boolean existsByEmail(String email);

  User findByEmail(String email);
}
