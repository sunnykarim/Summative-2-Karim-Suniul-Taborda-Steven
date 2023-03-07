package com.company.bookstore.controller;

import com.company.bookstore.models.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    PublisherRepository publisherRepository;

    @QueryMapping
    public List<Publisher> publishers() {
        return publisherRepository.getPublishers();
    }

    @QueryMapping
    public Publisher findPublisherById(@Argument int id) {
        return publisherRepository.getPublisherById(id);
    }

    @MutationMapping
    public void addPublisher(
            @Argument int publisher_id,
            @Argument String name,
            @Argument String street,
            @Argument String city,
            @Argument String state,
            @Argument String postal_code,
            @Argument String phone,
            @Argument String email) {
        Publisher publisher = new Publisher(publisher_id, name, street, city, state, postal_code, phone, email);
        publisherRepository.addPublisher(publisher);
    }

    @MutationMapping
    public void updatePublisher(
            @Argument int publisher_id,
            @Argument String name,
            @Argument String street,
            @Argument String city,
            @Argument String state,
            @Argument String postal_code,
            @Argument String phone,
            @Argument String email) {
        Publisher updatedPublisher = new Publisher(publisher_id, name, street, city, state, postal_code, phone, email);
        publisherRepository.updatePublisher(updatedPublisher);
    }

    @MutationMapping
    public void deletePublisherById(@Argument int id) {
        publisherRepository.deletePublisher(id);
    }
}
