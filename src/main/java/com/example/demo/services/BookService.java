package com.example.demo.services;

import com.example.demo.models.BookType;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.entities.BookEntity;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Page<BookEntity> getBooks(String bookName, BookType type, String publishingName, String authorName, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        Specification<BookEntity> specification = new Specification<BookEntity>() {
            // root: use to get BookEntity column object
            // query: use to 組成頂層的查詢語句如select，from，where，order by，group by，having，distinct。
            // criteriaBuilder: use to create query conditions

            @Override
            public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                // join table rather than LAZY
                // if you don't fetch, it will:
                //      1. get book entity
                //      2. get publishing
                //      3. get authors which join BOOK_AUTHOR table (N + 1)
                // but if you fetch, it will lose some record since it joined all table, e.g.:
                //      A book contains 2 author Jack and Peter. If query by authorName = "Ja", then the result only show book with Jack
                //      If you don't use fetch(), then the result show both Jack and Peter
                root.fetch("publishing");
                root.fetch("authors");

                if(bookName != null) {
                    predicates.add(cb.like(root.get("name"), "%" + bookName + "%"));
                }

                if(type != null) {
                    predicates.add(cb.equal(root.get("type"), type));
                }

                if(publishingName != null) {
//                    Join<BookEntity, PublishingEntity> bookPublishingJoin = root.join("publishing");             // refer to BookEntity.publishing
//                    predicates.add(cb.like(bookPublishingJoin.get("name"), "%" + publishingName + "%"));         // this name column refer to publishing.name
                    predicates.add(cb.like(root.get("publishing").get("name"), "%" + publishingName + "%"));    // this is same as the above statement
                }

                if(authorName != null) {
//                    Join<BookEntity, AuthorEntity> bookAuthorJoin = root.join("authors");
//                    predicates.add(cb.like(bookAuthorJoin.get("name"), "%" + authorName + "%"));
                    predicates.add(cb.like(root.get("authors").get("name"), "%" + authorName + "%"));           // this is same as the above statement
                }

                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };

        return bookRepository.findAll(specification, pageable);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
