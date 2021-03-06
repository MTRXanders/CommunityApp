package com.example.community.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community.model.Channel;
import com.example.community.repository.ChannelRepository;

@Service("channelService")
@Transactional
public class ChannelServiceImpl implements CrudService<Channel> {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public void deleteAllEntities() {
       channelRepository.deleteAll();        
    }

    @Override
    public void deleteEntityById(Long id) {
       channelRepository.deleteById(id);        
    }

    @Override
    public List<Channel> findAllEntities() {
       return channelRepository.findAll();
    }

    @Override
    public Optional<Channel> findById(Long id) {
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
