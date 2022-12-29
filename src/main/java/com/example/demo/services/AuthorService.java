package com.example.demo.services;

import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.entities.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorEntity> getAuthors() {
        return authorRepository.findAll();
    }
}
