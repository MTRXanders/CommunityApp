package com.example.community.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long>{
    public Channel getChannelByName(String name);
}
