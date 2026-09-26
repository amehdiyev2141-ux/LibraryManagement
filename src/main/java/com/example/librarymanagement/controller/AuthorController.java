package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.AuthorModel;
import com.example.librarymanagement.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorModel> createAuthor(
            @RequestBody AuthorModel model) {

        AuthorModel response = authorService.createAuthor(model);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<AuthorModel>> getAllAuthors() {

        return ResponseEntity.ok(
                authorService.getAllAuthors()
        );
    }
}