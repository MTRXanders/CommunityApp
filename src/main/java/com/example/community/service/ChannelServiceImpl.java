package com.example.community.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.community.model.Channel;
import com.example.community.repository.ChannelRepository;

public class ChannelServiceImpl implements CrudService<Channel> {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public void deleteAllEntities() {
       channelRepository.deleteAll();        
    }

    @Override
    public void deleteEntityById(UUID id) {
       channelRepository.deleteById(id);        
    }

    @Override
    public List<Channel> findAllEntities() {
       return channelRepository.findAll();
    }

    @Override
    public Optional<Channel> findById(UUID id) {
       return channelRepository.findById(id);
    }

    @Override
    public Channel findByName(String name) {
        return channelRepository.getChannelByName(name);
    }

    @Override
    public boolean isEntityExist(Channel entity) {
        return channelRepository.existsById(entity.getId());
    }

    @Override
    public void saveEntity(Channel entity) {
        channelRepository.save(entity);
    }

    @Override
    public void updateEntity(Channel entity) {
        saveEntity(entity);
    }
    
}
