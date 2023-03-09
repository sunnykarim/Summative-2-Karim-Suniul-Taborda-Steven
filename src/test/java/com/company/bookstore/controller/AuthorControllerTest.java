package com.company.bookstore.controller;

import com.company.bookstore.models.Author;
import com.company.bookstore.repository.AuthorRepository;
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
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AuthorRepository repo;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    // A list of authors for testing purposes
    private List<Author> authorList;

    @Before
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }

    // Testing POST /authors
    @Test
    public void shouldReturnNewAuthorOnPostRequest() throws Exception {
        // ARRANGE
        Author author = new Author();
        author.setAuthor_id(1);
        author.setFirst_name("John");
        author.setLast_name("Doe");
        author.setStreet("42 Wallaby Way, Sydney.");
        author.setCity("Toronto");
        author.setState("Ohio");
        author.setPostal_code("43964");
        author.setPhone("740-123-4567");
        author.setEmail("JohnDoe@gmail.com");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(author);

        // ACT
        mockMvc.perform(
                        post("/authors")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    // Testing GET authors/{id}
    @Test
    public void shouldReturnAuthorById() throws Exception {

        Author author = new Author();
        author.setAuthor_id(2);
        author.setFirst_name("Jane");
        author.setLast_name("Doe");
        author.setStreet("1234 Random Address");
        author.setCity("Sunnyvale");
        author.setState("California");
        author.setPostal_code("94043");
        author.setPhone("408-123-4567");
        author.setEmail("JaneDoe@gmail.com");

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(MockMvcRequestBuilders.get("/authors/2")).andDo(print()).andExpect(status().isOk());
    }

    // Testing PUT /authors/{id}
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        Author author = new Author();
        author.setAuthor_id(3);
        author.setFirst_name("David");
        author.setLast_name("Smith");
        author.setStreet("0000 Random Address2");
        author.setCity("Mountainview");
        author.setState("California");
        author.setPostal_code("94039");
        author.setPhone("650-123-4567");
        author.setEmail("JaneDoe@gmail.com");

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(
                        put("/authors")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    // Testing DELETE /authors/{id}
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/authors/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}