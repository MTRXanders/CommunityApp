package com.example.community.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community.model.User;
import com.example.community.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements CrudService<User>{


    @Autowired
    private UserRepository repo;

    @Override
    public void deleteAllEntities() {
        repo.deleteAll();
    }

    @Override
    public void deleteEntityById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public List<User> findAllEntities() {
        return repo.findAll();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public User findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public boolean isEntityExist(User entity) {
        return repo.existsById(entity.getId());
    }

    @Override
    public void saveEntity(User entity) {
        repo.save(entity);
    }

    @Override
    public void updateEntity(User entity) {
        saveEntity(entity);
    }
    
}
