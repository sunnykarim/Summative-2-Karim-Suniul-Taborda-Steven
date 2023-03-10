package com.company.bookstore.controller;


import com.company.bookstore.models.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class BookController {

    @Autowired
    BookRepository repo;

    //    A POST route that creates a new book. 10 pts
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return repo.save(book);
    }

    //    A PUT route that updates an existing book. 10 pts
    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book) {
        repo.save(book);
    }

    //    A DELETE route that deletes an existing book. 10 pts
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        repo.deleteById(id);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        List<Book> books = (List<Book>) repo.findAll();
        return books;
    }

    //    A GET route that returns a specific book by id. 10 pts
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        Optional<Book> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    //    A GET route that returns a list of books by author id. 10 pts
    @GetMapping("/books/author/{author_id}")
    public List<Book> getBooksByAuthorId(@PathVariable int author_id) {
        List<Book> books = (List<Book>) repo.findByAuthorId(author_id);
        return books;
    }
}
