package com.example.librarymanagement.service;

import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.model.AuthorModel;
import com.example.librarymanagement.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorModel createAuthor(AuthorModel model) {

        Author author = new Author();

        author.setName(model.getName());
        author.setEmail(model.getEmail());

        Author saveAuthor = authorRepository.save(author);

        AuthorModel response = new AuthorModel();

        response.setId(saveAuthor.getId());
        response.setName(saveAuthor.getName());
        response.setEmail(saveAuthor.getEmail());

        return response;
    }

    public List<AuthorModel> getAllAuthors() {

        List<Author> authors = authorRepository.findAll();

        return authors.stream()
                .map(author -> {
                    AuthorModel model = new AuthorModel();

                    model.setId(author.getId());
                    model.setName(author.getName());
                    model.setEmail(author.getEmail());

                    return model;
                })
                .toList();
    }
}