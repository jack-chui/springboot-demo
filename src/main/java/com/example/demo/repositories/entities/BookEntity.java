package com.example.demo.repositories.entities;

import com.example.demo.models.BookType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Book")
public class BookEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price", precision = 8, scale = 2)  // 字段最大8位数字，其中2位为小数点
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private BookType type;

    @JsonManagedReference                                           // @JsonManagedReference係個入口, 當遇到JsonBackReference, Set<BookEntity> books會omit 唔會再serialize, 姐係唔顯示。 所以直接call /publishing 係拎唔到book
    @ManyToOne
    @JoinColumn(name = "publishingId", referencedColumnName = "id") // join by BookEntity.publishingId and PublishingEntity.id column
                                                                    // referencedColumnName 如果不注明，默认就是引用表的主键
                                                                    // @JoinColumn use in OneToOne, OneToMany, ManyToOne
    private PublishingEntity publishing;


    @JsonManagedReference
    @ManyToMany
    @JoinTable(                                                     // @JoinTable use in ManyToMany
            name = "BookAuthor",                                    // ManyToMany will create a new table to hold these table relationship
            joinColumns = @JoinColumn(name = "BookId"),             // joinColumns refer to this entity column
            inverseJoinColumns = @JoinColumn(name = "AuthorId")     // inverseJoinColumns mean another entity column
    )
    private List<AuthorEntity> authors;
}
