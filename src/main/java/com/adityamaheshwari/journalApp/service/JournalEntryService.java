package com.adityamaheshwari.journalApp.service;

import com.adityamaheshwari.journalApp.entity.JournalEntry;
import com.adityamaheshwari.journalApp.entity.User;
import com.adityamaheshwari.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Service // for denoting that the class is of service type.
public class JournalEntryService {
    @Autowired // for using the mongoDB
    private JournalEntryRepository journalEntryRepository;

    @Autowired // for using the mongoDB
    private UserService userService;

    @Transactional // this basically means that all are successful then ok otherwise it will rollback
    // it create transactional boxes,
    // in mongoDB it important to have replication for the transaction.
    public void saveEntry(JournalEntry journalEntry, String userName) {
        try {
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved); // this line may not be saved if any error comes and that's why transaction is used.
            userService.saveEntry(user);
        }catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while saving the entry. ", e);
        }

    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    // we can name this function anything!
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll(); // using predefined functions of mongodb.
    }

    // it may be possible that we didn't find any id(it can be null also), so that's why using Optional.
    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id, String userName) {
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveEntry(user); // updating that user only.
        journalEntryRepository.deleteById(id);
    }
}


// controller -> service(Main application logic) -> repository