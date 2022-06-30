package com.example.community.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.community.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, UUID> {

    public Claim getClaimByName(String name);
}
