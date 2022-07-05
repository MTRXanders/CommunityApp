package com.example.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Leadership;

@Repository
public interface LeadershipRepository extends JpaRepository<Leadership, Long>{
    public Leadership getLeadershipByName(String name);
}
