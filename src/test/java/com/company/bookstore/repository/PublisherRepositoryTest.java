package com.company.bookstore.repository;

import com.company.bookstore.models.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {
    //@MockBean
    @Autowired
    PublisherRepository publisherRepo;

    @Before
    public void setUp() throws Exception {
        publisherRepo.deleteAll();
    }

    @Test
    public void addPublisher() {
        //Arrange...
        Publisher publisher = new Publisher();
        //publisher.setPublisher_id(1);
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("Ohio");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        //Act...
        publisher = publisherRepo.save(publisher);

        //Assert...
        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getPublisher_id());

        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void getAllPublishers() {
        //Arrange...

        //Act...
        Publisher publisher = new Publisher();
        //publisher.setPublisher_id(1);
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("Ohio");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        publisherRepo.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher.setPublisher_id(2);
        publisher.setName("John Doe");
        publisher.setStreet("1234 Random Address");
        publisher.setCity("Sunnyvale");
        publisher.setState("California");
        publisher.setPostal_code("94043");
        publisher.setPhone("408-123-4567");
        publisher.setEmail("JaneDoe@gmail.com");

        publisherRepo.save(publisher2);

        List<Publisher> publisherList = publisherRepo.findAll();

        //Assert...
        assertEquals(2, publisherList.size());
    }

    @Test
    public void updatePublisher() {
        //Arrange...
        Publisher publisher = new Publisher();
        //publisher.setPublisher_id(1);
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("Ohio");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        publisherRepo.save(publisher);

        //Act...
        publisher.setName("Updated Name");

        publisherRepo.save(publisher);

        //Assert...
        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getPublisher_id());

        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void deletePublisher() {
        //Arrange...
        Publisher publisher = new Publisher();
        //publisher.setPublisher_id(1);
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("Ohio");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        publisherRepo.save(publisher);

        //Act...
        publisherRepo.deleteById(publisher.getPublisher_id());

        //Assert...
        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getPublisher_id());
        assertFalse(publisher1.isPresent());
    }

    @org.junit.Test
    public void findPublisherById() {
        Publisher publisher = new Publisher();
        //publisher.setPublisher_id(1);
        publisher.setName("John Doe");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("Ohio");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        publisherRepo.save(publisher);

        //Assert...
        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getPublisher_id());

        assertEquals(publisher1.get(), publisher);
    }

}