package com.example.community.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community.model.Community;
import com.example.community.repository.CommunityRepository;

@Service("communityService")
@Transactional
public class CommunityServiceImpl implements CrudService<Community>{

    @Autowired
    private CommunityRepository repo;

    @Override
    public void deleteAllEntities() {
       repo.deleteAll();        
    }

    @Override
    public void deleteEntityById(Long id) {
       repo.deleteById(id);
    }

    @Override
    public List<Community> findAllEntities() {
        return repo.findAll();
    }

    @Override
    public Optional<Community> findById(Long id) {
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
