package com.example.community.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community.model.Membership;
import com.example.community.repository.MembershipRepository;

@Service("membershipService")
@Transactional
public class MembershipServiceImpl implements CrudService<Membership> {

    @Autowired
    private MembershipRepository repo;

    @Override
    public void deleteAllEntities() {
       repo.deleteAll();
    }

    @Override
    public void deleteEntityById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public List<Membership> findAllEntities() {
        return repo.findAll();
    }

    @Override
    public Optional<Membership> findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public Membership findByName(String name) {
       return repo.getMembershipByName(name);
    }

    @Override
    public boolean isEntityExist(Membership entity) {
        return repo.existsById(entity.getId());
    }

    @Override
    public void saveEntity(Membership entity) {
        repo.save(entity);
    }

    @Override
    public void updateEntity(Membership entity) {
        saveEntity(entity);
    }
    
}
