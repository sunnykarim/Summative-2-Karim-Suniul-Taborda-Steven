package com.company.bookstore.controller;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphController {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    PublisherRepository publisherRepo;

    @Autowired
    AuthorRepository authorRepo;

    @QueryMapping
    public Book findBookById(@Argument int id) {
        return bookRepo.findById(id).get();
    }

    @QueryMapping
    public Publisher findPublisherById(@Argument int id) {
        return publisherRepo.findById(id).get();
    }

    @QueryMapping
    public Author findAuthorById(@Argument int id) {
        return authorRepo.findById(id).get();
    }
}
