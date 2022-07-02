package com.example.community.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community.model.Admin;
import com.example.community.repository.AdminRepository;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements CrudService<Admin> {


    @Autowired
    private AdminRepository adminRepository;
    
    @Override
    public void deleteEntityById(UUID id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void deleteAllEntities() {
        adminRepository.deleteAll();        
    }

    @Override
    public List<Admin> findAllEntities() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findById(UUID id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin findByName(String name) {
        return adminRepository.getAdminByName(name);
    }

    @Override
    public boolean isEntityExist(Admin admin) {
        return adminRepository.existsById(admin.getId());
    }

    @Override
    public void saveEntity(Admin admin) {
        adminRepository.save(admin);        
    }

    @Override
    public void updateEntity(Admin admin) {
        saveEntity(admin);        
    }
}
