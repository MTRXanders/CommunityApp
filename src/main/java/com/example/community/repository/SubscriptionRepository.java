package com.example.community.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, UUID>{

    public Subscription getSubscriptionByName(String name);
}
