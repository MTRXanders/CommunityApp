package com.example.community.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.community.model.Community;
import com.example.community.repository.CommunityRepository;

public class CommunityServiceImpl implements CrudService<Community>{

    @Autowired
    private CommunityRepository repo;

    @Override
    public void deleteAllEntities() {
       repo.deleteAll();        
    }

    @Override
    public void deleteEntityById(UUID id) {
       repo.deleteById(id);
    }

    @Override
    public List<Community> findAllEntities() {
        return repo.findAll();
    }

    @Override
    public Optional<Community> findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public Community findByName(String name) {
        return repo.getCommunityByName(name);
    }

    @Override
    public boolean isEntityExist(Community entity) {
        return repo.existsById(entity.getId());
    }

    @Override
    public void saveEntity(Community entity) {
        repo.save(entity);
    }

    @Override
    public void updateEntity(Community entity) {
        saveEntity(entity);
    }
    
}
