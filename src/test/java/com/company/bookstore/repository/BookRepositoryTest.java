package com.company.bookstore.repository;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    //@MockBean
    @Autowired
    BookRepository bookRepo;

    //@MockBean
    @Autowired
    AuthorRepository authorRepo;

    //@MockBean
    @Autowired
    PublisherRepository publisherRepo;

    @Before
    public void setUp() throws Exception {
        bookRepo.deleteAll();
        authorRepo.deleteAll();
        publisherRepo.deleteAll();
    }

    @Test
    public void addBook() {
        //Arrange...
        Book book = new Book();
        book.setIsbn("9991111234560");
        book.setPublish_date(LocalDate.parse("1970-01-01"));
        book.setTitle("BookTestName1");
        book.setPrice((float) 16.97);

        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("7401234567");
        author.setEmail("JohnDoe@gmail.com");

        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("7401234567");
        publisher.setEmail("JohnDoe@gmail.com");

        publisher = publisherRepo.save(publisher);

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        //Act...
//        author = authorRepo.save(author);
//        publisher = publisherRepo.save(publisher);
        book = bookRepo.save(book);

        //Assert...
        Book book1 = bookRepo.findById(book.getBook_id()).get();

        assertEquals(book1, book);
    }

    @Test
    public void getAllBooks() {
        //Arrange...

        //Act...
        Book book = new Book();
        book.setIsbn("1111111234560");
        book.setPublish_date(LocalDate.parse("1970-01-02"));
        book.setTitle("BookTestName1");
        book.setPrice((float) 16.97);

        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("7401234567");
        author.setEmail("JohnDoe@gmail.com");
        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("7401234567");
        publisher.setEmail("JohnDoe@gmail.com");
        publisher = publisherRepo.save(publisher);

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        book = bookRepo.save(book);

        Book book2 = new Book();
        book2.setIsbn("9991111234560");
        book2.setPublish_date(LocalDate.parse("1970-01-03"));
        book2.setTitle("BookTestName2");
        book2.setPrice((float) 19.99);

        Author author2 = new Author();
        author2.setFirst_name("AAAAA");
        author2.setLast_name("BBBB");
        author2.setStreet("42 Wallaby Way, Sydney.");
        author2.setCity("Toronto");
        author2.setState("OH");
        author2.setPostal_code("43964");
        author2.setPhone("7401234567");
        author2.setEmail("JohnDoe@gmail.com");
        author2 = authorRepo.save(author2);

        Publisher publisher2 = new Publisher();
        publisher2.setName("AAA BBBB");
        publisher2.setStreet("42 Wallaby Way, Sydney.");
        publisher2.setCity("Toronto");
        publisher2.setState("OH");
        publisher2.setPostal_code("43964");
        publisher2.setPhone("7401234567");
        publisher2.setEmail("JohnDoe@gmail.com");
        publisher2 = publisherRepo.save(publisher2);

        book2.setAuthor_id(author2.getAuthor_id());
        book2.setPublisher_id(publisher2.getPublisher_id());

        book2 = bookRepo.save(book2);

        //bookRepo.save(book2);

        List<Book> bookList = bookRepo.findAll();

        //Assert...
        assertEquals(2, bookList.size());
    }

    @Test
    public void updateBook() {
        //Arrange...
        Book book = new Book();
        book.setIsbn("9991111234560");
        book.setPublish_date(LocalDate.parse("1970-01-01"));
        book.setTitle("BookTestName1");
        book.setPrice((float) 14.97);

        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("7401234567");
        author.setEmail("JohnDoe@gmail.com");
        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("7401234567");
        publisher.setEmail("JohnDoe@gmail.com");
        publisher = publisherRepo.save(publisher);

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        bookRepo.save(book);

        //Act...
        book.setTitle("UPDATED");

        bookRepo.save(book);

        //Assert...
        Optional<Book> book1 = bookRepo.findById(book.getBook_id());

        assertEquals(book1.get(), book);
    }

    @Test
    public void deleteBook() {
        //Arrange...
        Book book = new Book();
        book.setIsbn("0001111234560");
        book.setPublish_date(LocalDate.parse("1970-01-05"));
        book.setTitle("BookTestName3");
        book.setPrice((float) 16.97);

        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("7401234567");
        author.setEmail("JohnDoe@gmail.com");
        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("7401234567");
        publisher.setEmail("JohnDoe@gmail.com");
        publisher = publisherRepo.save(publisher);

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        bookRepo.save(book);

        //Act...
        bookRepo.deleteById(book.getBook_id());

        //Assert...
        Optional<Book> book1 = bookRepo.findById(book.getBook_id());
        assertFalse(book1.isPresent());
    }

    @org.junit.Test
    public void findBookById() {
        Book book = new Book();
        book.setIsbn("5551121234560");
        book.setPublish_date(LocalDate.parse("1970-01-01"));
        book.setTitle("BookTestName1");


        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("7401234567");
        author.setEmail("JohnDoe@gmail.com");
        author = authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("7401234567");
        publisher.setEmail("JohnDoe@gmail.com");
        publisher = publisherRepo.save(publisher);

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        bookRepo.save(book);

        //Assert...
        Optional<Book> book1 = bookRepo.findById(book.getBook_id());

        assertEquals(book1.get(), book);
    }

}