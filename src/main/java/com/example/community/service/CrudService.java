package com.example.community.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
    Optional<T> findById(Long id);
 
    T findByName(String name);
 
    void saveEntity(T entity);
 
    void updateEntity(T entity);
 
    void deleteEntityById(Long id);
 
    void deleteAllEntities();
 
    List<T> findAllEntities();
 
    boolean isEntityExist(T entity);
}
