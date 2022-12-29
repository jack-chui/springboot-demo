package com.example.demo.services;

import com.example.demo.repositories.PublishingRepository;
import com.example.demo.repositories.entities.PublishingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingService {
    @Autowired
    private PublishingRepository publishingRepository;

    public List<PublishingEntity> getPublishings() {
        return publishingRepository.findAll();
    }
}
