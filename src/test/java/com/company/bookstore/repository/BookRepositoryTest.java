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
        book.setIsbn("999-1-11-123456-0");
        book.setPublish_date("01/01/1970");
        book.setTitle("BookTestName1");
        book.setPrice((float) 16.97);

        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        //Act...
        author = authorRepo.save(author);
        publisher = publisherRepo.save(publisher);
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
        book.setIsbn("111-1-11-123456-0");
        book.setPublish_date("01/02/1970");
        book.setAuthor_id(1);
        book.setTitle("BookTestName1");
        book.setPublisher_id(1);
        book.setPrice((float) 16.97);

        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        author = authorRepo.save(author);
        publisher = publisherRepo.save(publisher);
        bookRepo.save(book);

        Book book2 = new Book();
        book.setIsbn("999-1-11-123456-0");
        book.setPublish_date("01/03/1970");
        book.setTitle("BookTestName2");
        book.setPrice((float) 19.99);

        Author author2 = new Author();
        author.setFirst_name("AAAAA");
        author.setLast_name("BBBB");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        Publisher publisher2 = new Publisher();
        publisher.setName("AAA BBBB");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        author2 = authorRepo.save(author);
        publisher2 = publisherRepo.save(publisher);
        bookRepo.save(book2);

        List<Book> bookList = bookRepo.findAll();

        //Assert...
        assertEquals(2, bookList.size());
    }

    @Test
    public void updateBook() {
        //Arrange...
        Book book = new Book();
        book.setIsbn("999-1-11-123456-0");
        book.setPublish_date("01/01/1970");
        book.setTitle("BookTestName1");
        book.setPrice((float) 14.97);

        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        author = authorRepo.save(author);
        publisher = publisherRepo.save(publisher);
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
        book.setIsbn("000-1-11-123456-0");
        book.setPublish_date("01/05/1970");
        book.setTitle("BookTestName3");
        book.setPrice((float) 16.97);

        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        author = authorRepo.save(author);
        publisher = publisherRepo.save(publisher);
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
        book.setIsbn("555-1-12-123456-0");
        book.setPublish_date("01/01/1970");
        book.setTitle("BookTestName1");


        Author author = new Author();
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("OH");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("OH");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        book.setAuthor_id(author.getAuthor_id());
        book.setPublisher_id(publisher.getPublisher_id());

        author = authorRepo.save(author);
        publisher = publisherRepo.save(publisher);
        bookRepo.save(book);

        //Assert...
        Optional<Book> book1 = bookRepo.findById(book.getBook_id());

        assertEquals(book1.get(), book);
    }

}