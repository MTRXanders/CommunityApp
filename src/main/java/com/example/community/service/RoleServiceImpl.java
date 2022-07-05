package com.example.community.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community.model.Role;
import com.example.community.repository.RoleRepository;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements CrudService<Role>{
    
    @Autowired
    private RoleRepository repo;

    @Override
    public void deleteAllEntities() {
       repo.deleteAll();
    }

    @Override
    public void deleteEntityById(Long id) {
       repo.deleteById(id);
    }

    @Override
    public List<Role> findAllEntities() {
       return repo.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return repo.getRoleByName(name);
    }

    @Override
    public boolean isEntityExist(Role entity) {
        return repo.existsById(entity.getId());
    }

    @Override
    public void saveEntity(Role entity) {
        repo.save(entity);
    }

    @Override
    public void updateEntity(Role entity) {
       saveEntity(entity);
    }

    
}
