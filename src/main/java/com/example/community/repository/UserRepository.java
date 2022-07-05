package com.example.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    public User findByName(String name);

}
