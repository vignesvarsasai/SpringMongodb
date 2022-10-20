package com.example.springmongodb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "Joke")
public class Joke {

    @Id
    private Integer id;
    private String type;
    private String setup;
    private String punchline;
}
