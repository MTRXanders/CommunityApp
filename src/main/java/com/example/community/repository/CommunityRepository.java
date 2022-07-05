package com.example.community.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long>{

   public Community getCommunityByName(String name);
    
}
