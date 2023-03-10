package com.company.bookstore.repository;

import com.company.bookstore.models.Book;
import com.company.bookstore.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

   // List<Book> findByAuthorId(Integer,author_id);
}

