package com.company.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="book")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int book_id;
    private String isbn;

    private LocalDate publish_date;
    @Column(name = "author_id")
    private int authorId;
    private String title;
    @Column(name = "publisher_id")
    private int publisher_id;
    private float price;

    // no join column

    public Book() {
    }

    public Book(int book_id, String isbn, LocalDate publish_date, int authorId, String title, int publisher_id, float price) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.publish_date = publish_date;
        this.authorId = authorId;
        this.title = title;
        this.publisher_id = publisher_id;
        this.price = price;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(LocalDate publish_date) {
        this.publish_date = publish_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id == book.book_id && authorId == book.authorId && publisher_id == book.publisher_id && price == book.price && Objects.equals(isbn, book.isbn) && Objects.equals(publish_date, book.publish_date) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id, isbn, publish_date, authorId, title, publisher_id, price);
    }
}
