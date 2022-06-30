package com.example.community.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.community.model.Post;
import com.example.community.repository.PostRepository;

public class PostServiceImpl implements CrudService<Post>{
    @Autowired
    private PostRepository repo;

    @Override
    public void deleteAllEntities() {
        repo.deleteAll();
    }

    @Override
    public void deleteEntityById(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public List<Post> findAllEntities() {
        return repo.findAll();
    }

    @Override
    public Optional<Post> findById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public Post findByName(String name) {
       return repo.getPostByTitle(name);
    }

    @Override
    public boolean isEntityExist(Post entity) {
        return repo.existsById(entity.getId());
    }

    @Override
    public void saveEntity(Post entity) {
        repo.save(entity);
    }

    @Override
    public void updateEntity(Post entity) {
        saveEntity(entity);
    }
    
}
