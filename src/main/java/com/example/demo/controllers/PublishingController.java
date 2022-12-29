package com.example.demo.controllers;

import com.example.demo.repositories.entities.PublishingEntity;
import com.example.demo.services.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publishing")
public class PublishingController {
    @Autowired
    private PublishingService publishingService;

    @GetMapping
    public List<PublishingEntity> getPublishings() {
        return publishingService.getPublishings();
    }
}
