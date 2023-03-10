package com.company.bookstore.repository;

import com.company.bookstore.models.Author;
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
public class AuthorRepositoryTest {

    //@MockBean
    @Autowired
    AuthorRepository authorRepo;

    @Before
    public void setUp() throws Exception {
        authorRepo.deleteAll();
    }

    @Test
    public void addAuthor() {
        //Arrange...
        Author author = new Author();
        //author.setAuthor_id(1);
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("Ohio");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        //Act...
        author = authorRepo.save(author);

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getAuthor_id());

        assertEquals(author1.get(), author);
    }

    @Test
    public void getAllAuthors() {
        //Arrange...

        //Act...
        Author author = new Author();
        //author.setAuthor_id(1);
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("Ohio");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        authorRepo.save(author);

        Author author2 = new Author();
        author.setAuthor_id(2);
        author.setFirst_name("Jane");
        author.setLast_name("Doe");
        author.setStreet("1234 Random Address");
        author.setCity("Sunnyvale");
        author.setState("California");
        author.setPostal_code("94043");
        author.setPhone("408-123-4567");
        author.setEmail("JaneDoe@gmail.com");

        authorRepo.save(author2);

        List<Author> authorList = authorRepo.findAll();

        //Assert...
        assertEquals(2, authorList.size());
    }

    @Test
    public void updateAuthor() {
        //Arrange...
        Author author = new Author();
        //author.setAuthor_id(1);
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("Ohio");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        authorRepo.save(author);

        //Act...
        author.setFirst_name("UPDATED");

        authorRepo.save(author);

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getAuthor_id());

        assertEquals(author1.get(), author);
    }

    @Test
    public void deleteAuthor() {
        //Arrange...
        Author author = new Author();
        //author.setAuthor_id(1);
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("Ohio");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        authorRepo.save(author);

        //Act...
        authorRepo.deleteById(author.getAuthor_id());

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getAuthor_id());
        assertFalse(author1.isPresent());
    }

    @org.junit.Test
    public void findAuthorById() {
        Author author = new Author();
        //author.setAuthor_id(1);
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("Ohio");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        authorRepo.save(author);

        //Assert...
        Optional<Author> author1 = authorRepo.findById(author.getAuthor_id());

        assertEquals(author1.get(), author);
    }

}