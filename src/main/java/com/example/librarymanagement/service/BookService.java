package com.example.librarymanagement.service;

import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.model.AuthorModel;
import com.example.librarymanagement.model.BookModel;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookModel createBook(BookModel model) {

        Author author = authorRepository.findById(model.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = new Book();

        book.setTitle(model.getTitle());
        book.setPrice(model.getPrice());
        book.setPublishedYear(model.getPublishedYear());
        book.setAuthor(author);

        Book savedBook = bookRepository.save(book);

        BookModel response = new BookModel();

        response.setId(savedBook.getId());
        response.setTitle(savedBook.getTitle());
        response.setPrice(savedBook.getPrice());
        response.setPublishedYear(savedBook.getPublishedYear());
        response.setAuthorId(author.getId());

        AuthorModel authorModel = new AuthorModel();

        authorModel.setId(author.getId());
        authorModel.setName(author.getName());
        authorModel.setEmail(author.getEmail());

        response.setAuthor(authorModel);

        return response;
    }

    public List<BookModel> getAllBooks() {

        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(book -> {

                    BookModel model = new BookModel();

                    model.setId(book.getId());
                    model.setTitle(book.getTitle());
                    model.setPrice(book.getPrice());
                    model.setPublishedYear(book.getPublishedYear());

                    Author author = book.getAuthor();

                    if (author != null) {

                        AuthorModel authorModel = new AuthorModel();

                        authorModel.setId(author.getId());
                        authorModel.setName(author.getName());
                        authorModel.setEmail(author.getEmail());

                        model.setAuthor(authorModel);
                    }

                    return model;
                })
                .toList();
    }
}