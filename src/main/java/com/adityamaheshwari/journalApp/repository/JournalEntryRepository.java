package com.adityamaheshwari.journalApp.repository;

import com.adityamaheshwari.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


// it is basically the database access layer.
@Repository
// In Spring Boot, the @Repository annotation is used to indicate that a particular class is a "Repository"
// in the context of the Spring framework. It is a specialization of the @Component annotation, which means
// that it is a Spring-managed bean. Here are some key points about the @Repository annotation
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
