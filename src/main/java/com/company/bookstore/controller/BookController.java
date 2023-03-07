package com.company.bookstore.controller;

import com.company.bookstore.models.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @QueryMapping
    public List<Book> books() {
        return bookRepository.getBooks();
    }

    @QueryMapping
    public Book findBookById(@Argument int id) {
        return bookRepository.getBookById(id);
    }

    @QueryMapping
    public List<Book> findBooksByAuthorId(@Argument int authorId) {
        return bookRepository.getBooksByAuthorId(authorId);
    }

    @QueryMapping
    public List<Book> findBooksByPublisherId(@Argument int publisherId) {
        return bookRepository.getBooksByPublisherId(publisherId);
    }

    @MutationMapping
    public void addBook(
            @Argument int book_id,
            @Argument String isbn,
            @Argument String publish_date,
            @Argument int author_id,
            @Argument String title,
            @Argument int publisher_id,
            @Argument int price) {
        Book book = new Book(book_id, isbn, publish_date, author_id, title, publisher_id, price);
        bookRepository.addBook(book);
    }

    @MutationMapping
    public void updateBook(
            @Argument int book_id,
            @Argument String isbn,
            @Argument String publish_date,
            @Argument int author_id,
            @Argument String title,
            @Argument int publisher_id,
            @Argument int price) {
        Book updatedBook = new Book(book_id, isbn, publish_date, author_id, title, publisher_id, price);
        bookRepository.updateBook(updatedBook);
    }

    @MutationMapping
    public void deleteBookById(@Argument int id) {
        bookRepository.deleteBook(id);
    }
}
