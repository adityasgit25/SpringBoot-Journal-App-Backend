package com.adityamaheshwari.journalApp.repository;

import com.adityamaheshwari.journalApp.entity.JournalEntry;
import com.adityamaheshwari.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);
}
