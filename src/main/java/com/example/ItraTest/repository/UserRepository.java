package com.example.ItraTest.repository;

import com.example.ItraTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmail(String email);

}
