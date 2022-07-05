package com.example.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    public Admin getAdminByName(String name);
}
