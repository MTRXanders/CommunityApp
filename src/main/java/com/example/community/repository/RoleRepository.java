package com.example.community.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    public Role getRoleByName(String name);
}
