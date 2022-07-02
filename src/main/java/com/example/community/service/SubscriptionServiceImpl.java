package com.example.community.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community.model.Subscription;
import com.example.community.repository.SubscriptionRepository;

@Service("subscriptionService")
@Transactional
public class SubscriptionServiceImpl implements CrudService<Subscription>{

    @Autowired
    private SubscriptionRepository repo;

    @Override
    public void deleteAllEntities() {
       repo.deleteAll();
    }

    @Override
    public void deleteEntityById(UUID id) {
       repo.deleteById(id);
    }

    @Override
    public List<Subscription> findAllEntities() {
       return repo.findAll();
    }

    @Override
    public Optional<Subscription> findById(UUID id) {
       return repo.findById(id);
    }

    @Override
    public Subscription findByName(String name) {
        return repo.getSubscriptionByName(name);
    }

    @Override
    public boolean isEntityExist(Subscription entity) {
        return repo.existsById(entity.getId());
    }

    @Override
    public void saveEntity(Subscription entity) {
        repo.save(entity);
    }

    @Override
    public void updateEntity(Subscription entity) {
        saveEntity(entity);
    }
    
}
