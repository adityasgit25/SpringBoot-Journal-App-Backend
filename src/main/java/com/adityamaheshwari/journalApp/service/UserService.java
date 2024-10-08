package com.adityamaheshwari.journalApp.service;

import com.adityamaheshwari.journalApp.entity.JournalEntry;
import com.adityamaheshwari.journalApp.entity.User;
import com.adityamaheshwari.journalApp.repository.JournalEntryRepository;
import com.adityamaheshwari.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
     @Autowired
     private UserRepository userRepository;

     public void saveEntry(User user) {
         userRepository.save(user);
     }

     public List<User> getAll() {
         return userRepository.findAll();
     }
     public Optional<User> findById(ObjectId id) {
         return userRepository.findById(id);
     }
     public void deleteById(ObjectId id) {
         userRepository.deleteById(id);
     }

     public User findByUserName(String userName) {
         return userRepository.findByUserName(userName);
     }
}


// controller -> service(Main application logic) -> repository