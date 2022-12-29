package com.example.demo.controllers;

import com.example.demo.models.BookType;
import com.example.demo.repositories.entities.BookEntity;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Page<BookEntity> getBooks(
            @RequestParam(value = "bookName", required = false) String bookName,
            @RequestParam(value = "type", required = false) BookType type,
            @RequestParam(value = "publishingName", required = false) String publishingName,
            @RequestParam(value = "authorName", required = false) String authorName,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "1000") Integer size
    ) {
        return bookService.getBooks(bookName, type, publishingName, authorName, page, size);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }
}
