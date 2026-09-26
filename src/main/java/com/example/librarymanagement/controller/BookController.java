package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.BookModel;
import com.example.librarymanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookModel> createBook(
            @RequestBody BookModel model) {

        BookModel response = bookService.createBook(model);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {

        return ResponseEntity.ok(
                bookService.getAllBooks()
        );
    }
}