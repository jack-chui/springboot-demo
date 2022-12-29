package com.example.demo.services;

import com.example.demo.models.BookType;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublishingRepository;
import com.example.demo.repositories.entities.AuthorEntity;
import com.example.demo.repositories.entities.BookEntity;
import com.example.demo.repositories.entities.PublishingEntity;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Log4j2
@Service
public class InitDatabaseService {
    @Autowired
    private PublishingRepository publishingRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @PostConstruct
    public void init() {
        AuthorEntity jack = AuthorEntity.builder().name("Jack").build();
        AuthorEntity peter = AuthorEntity.builder().name("Peter").build();
        authorRepository.save(jack);
        authorRepository.save(peter);

        PublishingEntity swire = PublishingEntity.builder().name("Swire").build();
        publishingRepository.save(swire);

        BookEntity book1 = BookEntity.builder().name("Book1").price(BigDecimal.valueOf(1.0)).type(BookType.NEW).publishing(swire).authors(List.of(jack, peter)).build();
        BookEntity book2 = BookEntity.builder().name("Book2").price(BigDecimal.valueOf(2.0)).type(BookType.SECOND_HAND).publishing(swire).authors(List.of(jack)).build();
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
