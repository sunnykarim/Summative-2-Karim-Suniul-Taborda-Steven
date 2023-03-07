package com.company.bookstore.controller;

import com.company.bookstore.models.Author;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @QueryMapping
    public List<Author> authors() {
        return authorRepository.getAuthors();
    }

    @QueryMapping
    public Author findAuthorById(@Argument int id) {
        return authorRepository.getAuthorById(id);
    }

    @MutationMapping
    public void addAuthor(
            @Argument int author_id,
            @Argument String first_name,
            @Argument String last_name,
            @Argument String street,
            @Argument String city,
            @Argument String state,
            @Argument String postal_code,
            @Argument String phone,
            @Argument String email) {
        Author author = new Author(author_id, first_name, last_name, street, city, state, postal_code, phone, email);
        authorRepository.addAuthor(author);
    }

    @MutationMapping
    public void updateAuthor(
            @Argument int author_id,
            @Argument String first_name,
            @Argument String last_name,
            @Argument String street,
            @Argument String city,
            @Argument String state,
            @Argument String postal_code,
            @Argument String phone,
            @Argument String email) {
        Author updatedAuthor = new Author(author_id, first_name, last_name, street, city, state, postal_code, phone, email);
        authorRepository.updateAuthor(updatedAuthor);
    }

    @MutationMapping
    public void deleteAuthorById(@Argument int id) {
        authorRepository.deleteAuthor(id);
    }
}
