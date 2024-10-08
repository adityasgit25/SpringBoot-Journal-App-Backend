package com.adityamaheshwari.journalApp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// we have to map this to a collection in a db, that's why we use @Document
@Document(collection = "users") // Now instance of the Journal Entry will be equal to the document.(row)

@Data // lombok : based on the annotation, it produces the required getter and setter.
// lombok analyses these annotations during compilation.
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true) // @Indexed making our searching faster, automatically it will not, we have to add something to the application.properties file.
    @NonNull
    private String userName;

    @NonNull
    private String password;


    @DBRef // it is just working as a reference(to make the link)
    private List<JournalEntry> journalEntries = new ArrayList<>();


}
