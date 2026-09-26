package com.example.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue
    Long id;
    String title;
    double price;
    int publishedYear;
    @ManyToOne
    Author author;
}
