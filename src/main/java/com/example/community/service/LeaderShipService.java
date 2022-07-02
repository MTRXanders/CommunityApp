package com.example.community.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community.model.Leadership;
import com.example.community.repository.LeadershipRepository;

@Service("leadershipService")
@Transactional
public class LeaderShipService implements CrudService<Leadership>{

    @Autowired
    private LeadershipRepository repo;
    
    @Override
    public void deleteAllEntities() {
       repo.deleteAll();
    }

    @Override
    public void deleteEntityById(UUID id) {
       repo.deleteById(id);
    }

    @Override
    public List<Leadership> findAllEntities() {
       return repo.findAll();
    }

    @Override
    public Optional<Leadership> findById(UUID id) {
       return repo.findById(id);
    }

    @Override
    public Leadership findByName(String name) {
        return repo.getLeadershipByName(name);
    }

    @Override
    public boolean isEntityExist(Leadership entity) {
        return repo.existsById(entity.getId());
    }

    @Override
    public void saveEntity(Leadership entity) {
       repo.save(entity);
    }

    @Override
    public void updateEntity(Leadership entity) {
        saveEntity(entity);
    }
    
}
