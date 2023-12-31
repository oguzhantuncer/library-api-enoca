package com.oguzhantuncer.libraryapienoca.model.entity;

import com.oguzhantuncer.libraryapienoca.model.request.BookRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Column(name = "isbn_Number")
    private String isbnNumber;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "number_of_editions")
    private String numberOfEditions;

}
