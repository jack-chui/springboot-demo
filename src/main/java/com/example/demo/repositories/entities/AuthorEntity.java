package com.example.demo.repositories.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Author")
public class AuthorEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "authors")                           // for ManyToMany case, mappedBy vs JoinTable are the same
//    @ManyToMany
//    @JoinTable(
//            name = "BookAuthor",
//            joinColumns = @JoinColumn(name = "AuthorId"),
//            inverseJoinColumns = @JoinColumn(name = "BookId")
//    )
    private List<BookEntity> wroteBooks;
}
