package com.company.bookstore.controller;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PublisherRepository repo;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    // A list of publishers for testing purposes
    private List<Publisher> publisherList;

    @Before
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }

    // Testing POST /publishers
    @Test
    public void shouldReturnNewPublisherOnPostRequest() throws Exception {
        // ARRANGE
        Publisher publisher = new Publisher();
        publisher.setName("Joe Smith");
        publisher.setPhone("111-222-3456");
        publisher.setStreet("Address1");
        publisher.setCity("Los Angeles");
        publisher.setState("California");
        publisher.setPostal_code("12345");
        publisher.setEmail("JoeS@gmail.com");
        //publisher.setPublisher_id(2);

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(publisher);

        // ACT
        mockMvc.perform(
                        post("/publishers")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    // Testing GET publishers/{id}
    @Test
    public void shouldReturnPublisherById() throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Joe Smith");
        publisher.setPhone("111-222-3456");
        publisher.setStreet("Address1");
        publisher.setCity("Los Angeles");
        publisher.setState("California");
        publisher.setPostal_code("12345");
        publisher.setEmail("JoeS@gmail.com");
        //publisher.setPublisher_id(2);

        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(MockMvcRequestBuilders.get("/publishers/2")).andDo(print()).andExpect(status().isOk());
    }

    // Testing PUT /publishers/{id}
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        Publisher publisher = new Publisher();
        publisher.setName("Joe Smith");
        publisher.setPhone("111-222-3456");
        publisher.setStreet("Address1");
        publisher.setCity("Los Angeles");
        publisher.setState("California");
        publisher.setPostal_code("12345");
        publisher.setEmail("JoeS@gmail.com");
        publisher.setPublisher_id(2);

        String inputJson = mapper.writeValueAsString(publisher);

        mockMvc.perform(
                        put("/publishers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldReturnAllPublishers() throws Exception {
        // Create 3 authors
        Publisher publisher = new Publisher();
        publisher.setName("Penguin House");
        publisher.setStreet("42 Wallaby Way, Sydney.");
        publisher.setCity("Toronto");
        publisher.setState("Ohio");
        publisher.setPostal_code("43964");
        publisher.setPhone("740-123-4567");
        publisher.setEmail("JohnDoe@gmail.com");

        Publisher publisher2 = new Publisher();
        publisher2.setName("Random House");
        publisher2.setStreet("1234 Random Address");
        publisher2.setCity("Sunnyvale");
        publisher2.setState("California");
        publisher2.setPostal_code("94043");
        publisher2.setPhone("408-123-4567");
        publisher2.setEmail("JaneDoe@gmail.com");

        Publisher publisher3 = new Publisher();
        publisher3.setName("Books and Books");
        publisher3.setStreet("0000 Random Address2");
        publisher3.setCity("Mountain View");
        publisher3.setState("California");
        publisher3.setPostal_code("94039");
        publisher3.setPhone("650-123-4567");
        publisher3.setEmail("JaneDoe@gmail.com");

        repo.save(publisher);
        repo.save(publisher2);
        repo.save(publisher3);

        mockMvc.perform(MockMvcRequestBuilders.get("/publishers"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    // Testing DELETE /publishers/{id}
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/publishers/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}