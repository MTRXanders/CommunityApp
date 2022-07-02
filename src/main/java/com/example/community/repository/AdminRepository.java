package com.example.community.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID>{
    public Admin getAdminByName(String name);
}
