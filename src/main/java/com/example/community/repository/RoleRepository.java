package com.example.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role getRoleByName(String name);
}
