package com.example.demo.controllers;

import com.example.demo.repositories.entities.AuthorEntity;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    private List<AuthorEntity> getAuthors() {
        return authorService.getAuthors();
    }
}
