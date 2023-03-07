package com.company.bookstore.repository;

import com.company.bookstore.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {

    public BookRepository() { seedDataStore(); }

    private List<Book> books = new ArrayList<>();

    private void seedDataStore() {
        Book b1 = new Book(
                1,
                "1234567890",
                "2021-01-01",
                1,
                "Book 1",
                1,
                10
        );

        Book b2 = new Book(
                2,
                "0987654321",
                "2021-02-01",
                2,
                "Book 2",
                2,
                20
        );

        this.books.add(b1);
        this.books.add(b2);
    }

    // Create
    public void addBook(Book book) {
        this.books.add(book);
    }

    // Read all
    public List<Book> getBooks() {
        return this.books;
    }

    // Read by ID
    public Book getBookById(int id) {
        for (Book b : this.books) {
            if (b.getBook_id() == id) {
                return b;
            }
        }
        return null;
    }

    // Search by Author ID
    public List<Book> getBooksByAuthorId(int authorId) {
        List<Book> result = new ArrayList<>();
        for (Book b : this.books) {
            if (b.getAuthor_id() == authorId) {
                result.add(b);
            }
        }
        return result;
    }

    // Search by Publisher ID -- BONUS?
    public List<Book> getBooksByPublisherId(int publisherId) {
        List<Book> result = new ArrayList<>();
        for (Book b : this.books) {
            if (b.getPublisher_id() == publisherId) {
                result.add(b);
            }
        }
        return result;
    }

    // Delete
    public void deleteBook(int id) {
        for (Book b : this.books) {
            if (b.getBook_id() == id) {
                this.books.remove(b);
                break;
            }
        }
    }

    // TODO test
    public void updateBook(Book book) {
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getBook_id() == book.getBook_id()) {
                this.books.set(i, book);
                break;
            }
        }
    }
}

