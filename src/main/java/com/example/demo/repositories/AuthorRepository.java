package com.example.demo.repositories;

import com.example.demo.repositories.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
