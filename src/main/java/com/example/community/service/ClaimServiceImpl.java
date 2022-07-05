package com.example.community.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community.model.Claim;
import com.example.community.repository.ClaimRepository;

@Service("claimService")
@Transactional
public class ClaimServiceImpl implements CrudService<Claim> {

    @Autowired
    private ClaimRepository claimRepository;
    @Override
    public void deleteAllEntities() {
        claimRepository.deleteAll();
    }

    @Override
    public void deleteEntityById(Long id) {
       claimRepository.deleteById(id);        
    }

    @Override
    public List<Claim> findAllEntities() {
       return claimRepository.findAll();
    }

    @Override
    public Optional<Claim> findById(Long id) {
        return claimRepository.findById(id);
    }

    @Override
    public Claim findByName(String name) {
       return claimRepository.getClaimByName(name);
    }

    @Override
    public boolean isEntityExist(Claim entity) {
        return claimRepository.existsById(entity.getId());
    }

    @Override
    public void saveEntity(Claim entity) {
        claimRepository.save(entity);
    }

    @Override
    public void updateEntity(Claim entity) {
       saveEntity(entity);        
    }
}
