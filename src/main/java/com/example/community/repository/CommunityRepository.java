package com.example.community.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community, UUID>{

   public Community getCommunityByName(String name);
    
}
