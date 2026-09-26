package com.example.librarymanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookModel {

    Long id;
    String title;
    double price;
    int publishedYear;
    Long authorId;
    AuthorModel author;
}