package com.example.community.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.community.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, UUID>{
    public Admin getAdminByName(String name);
}
