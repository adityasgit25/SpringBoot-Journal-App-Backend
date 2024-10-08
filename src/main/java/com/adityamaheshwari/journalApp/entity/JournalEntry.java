package com.adityamaheshwari.journalApp.entity;

import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// we have to map this to a collection in a db, that's why we use @Document
@Document(collection = "journal_entries") // Now instance of the Journal Entry will be equal to the document.(row)

@Data // lombok : based on the annotation, it produces the required getter and setter.
// lombok analyses these annotations during compilation.
@NoArgsConstructor // this is required for the deserialization()
public class JournalEntry {


    @Id
    private ObjectId id;

    @NonNull
    private String title;

    private String content;

    private LocalDateTime date;
}
