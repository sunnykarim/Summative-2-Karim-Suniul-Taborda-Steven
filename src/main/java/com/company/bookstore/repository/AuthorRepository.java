package com.company.bookstore.repository;

import com.company.bookstore.models.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorRepository {

    public AuthorRepository() {
        seedDataStore();
    }

    private List<Author> authors = new ArrayList<>();

    private void seedDataStore() {
        Author a1 = new Author(
                1,
                "John",
                "Doe",
                "Street A",
                "City A",
                "State A",
                "12345",
                "555-1111",
                "johndoe@example.com"
        );

        Author a2 = new Author(
                2,
                "Jane",
                "Doe",
                "Street B",
                "City B",
                "State B",
                "54321",
                "555-2222",
                "janedoe@example.com"
        );

        this.authors.add(a1);
        this.authors.add(a2);
    }

    // Create
    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    // Read all
    public List<Author> getAuthors() {
        return this.authors;
    }

    // Read by ID
    public Author getAuthorById(int id) {
        for (Author a : this.authors) {
            if (a.getAuthor_id() == id) {
                return a;
            }
        }
        return null;
    }

    // TODO Test
    public void updateAuthor(Author author) {
        for (int i = 0; i < this.authors.size(); i++) {
            if (this.authors.get(i).getAuthor_id() == author.getAuthor_id()) {
                this.authors.set(i, author);
                break;
            }
        }
    }

    // Delete
    public void deleteAuthor(int id) {
        for (Author a : this.authors) {
            if (a.getAuthor_id() == id) {
                this.authors.remove(a);
                break;
            }
        }
    }
}
