package com.example.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Membership;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    public Membership getMembershipByName(String name);
}
