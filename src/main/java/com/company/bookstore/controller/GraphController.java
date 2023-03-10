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

import java.util.Optional;

@Controller
public class GraphController {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    PublisherRepository publisherRepo;

    @Autowired
    AuthorRepository authorRepo;

    @QueryMapping
    public Book findBookById(@Argument int book_id) {
        Optional<Book> book = bookRepo.findById(book_id);
        if (book.isPresent()){
            return book.get();
        }
        else {
            return null;
        }
    }

    @QueryMapping
    public Publisher findPublisherById(@Argument int publisher_id) {
        Optional<Publisher> publisher = publisherRepo.findById(publisher_id);
        if (publisher.isPresent()){
            return publisher.get();
        }
        else {
            return null;
        }
    }

    @QueryMapping
    public Author findAuthorById(@Argument int author_id) {
        Optional<Author> author = authorRepo.findById(author_id);
        if (author.isPresent()){
            return author.get();
        }
        else {
            return null;
        }
    }
}
