package com.company.bookstore.repository;

import com.company.bookstore.models.Publisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherRepository {

    public PublisherRepository() { seedDataStore(); }

    private List<Publisher> publishers = new ArrayList<>();

    private void seedDataStore() {
        Publisher p1 = new Publisher(
                1,
                "Publisher A",
                "Street A",
                "City A",
                "State A",
                "12345",
                "555-1111",
                "publisherA@example.com"
        );

        Publisher p2 = new Publisher(
                2,
                "Publisher B",
                "Street B",
                "City B",
                "State B",
                "54321",
                "555-2222",
                "publisherB@example.com"
        );

        this.publishers.add(p1);
        this.publishers.add(p2);
    }

    // Create
    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);
    }

    // Read all
    public List<Publisher> getPublishers() {
        return this.publishers;
    }

    // Read by ID
    public Publisher getPublisherById(int id) {
        for (Publisher p : this.publishers) {
            if (p.getPublisher_id() == id) {
                return p;
            }
        }
        return null;
    }

    public void updatePublisher(Publisher publisher) {
        for (int i = 0; i < this.publishers.size(); i++) {
            if (this.publishers.get(i).getPublisher_id() == publisher.getPublisher_id()) {
                this.publishers.set(i, publisher);
                break;
            }
        }
    }

    // Delete
    public void deletePublisher(int id) {
        for (Publisher p : this.publishers) {
            if (p.getPublisher_id() == id) {
                this.publishers.remove(p);
                break;
            }
        }
    }
}

