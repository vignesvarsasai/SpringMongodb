package com.example.springmongodb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Book")
public class Book {
    @Id
    private int id;
    private String BookName;
    private String AuthorName;
}
