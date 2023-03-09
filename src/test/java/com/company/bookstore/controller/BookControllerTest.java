package com.company.bookstore.controller;

import com.company.bookstore.models.Book;
import com.company.bookstore.repository.BookRepository;
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
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookRepository repo;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    // A list of books for testing purposes
    private List<Book> bookList;

    @Before
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }

    // Testing POST /books
    @Test
    public void shouldReturnNewBookOnPostRequest() throws Exception {
        // ARRANGE
        Book book = new Book();
        book.setBook_id(1);
        book.setIsbn("999-1-11-123456-0");
        book.setPublish_date("01/01/1970");
        book.setAuthor_id(1);
        book.setTitle("BookTestName1");
        book.setPublisher_id(1);
        book.setPrice((float) 16.97);

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(book);

        // ACT
        mockMvc.perform(
                        post("/books")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    // Testing GET books/{id}
    @Test
    public void shouldReturnBookById() throws Exception {

        Book book = new Book();
        book.setBook_id(2);
        book.setIsbn("000-1-11-123456-0");
        book.setPublish_date("01/02/1970");
        book.setAuthor_id(2);
        book.setTitle("BookTestName2");
        book.setPublisher_id(3);
        book.setPrice((float) 19.99);

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/2")).andDo(print()).andExpect(status().isOk());
    }

    // Testing PUT /books/{id}
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        Book book = new Book();
        book.setBook_id(3);
        book.setIsbn("123-1-11-123456-0");
        book.setPublish_date("01/03/1970");
        book.setAuthor_id(3);
        book.setTitle("BookTestName3");
        book.setPublisher_id(3);
        book.setPrice((float) 20.00);

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(
                        put("/books")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    // Testing DELETE /books/{id}
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/books/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}