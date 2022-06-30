package com.example.community.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.community.model.User;

public interface UserRepository extends JpaRepository<User,UUID>{
    public User findByName(String name);

}
