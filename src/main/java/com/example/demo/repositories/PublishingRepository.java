package com.example.demo.repositories;

import com.example.demo.repositories.entities.PublishingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishingRepository extends JpaRepository<PublishingEntity, Integer> {
}
