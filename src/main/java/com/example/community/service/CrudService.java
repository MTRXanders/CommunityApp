package com.example.community.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CrudService<T> {
    Optional<T> findById(UUID id);
 
    T findByName(String name);
 
    void saveEntity(T entity);
 
    void updateEntity(T entity);
 
    void deleteEntityById(UUID id);
 
    void deleteAllEntities();
 
    List<T> findAllEntities();
 
    boolean isEntityExist(T entity);
}
