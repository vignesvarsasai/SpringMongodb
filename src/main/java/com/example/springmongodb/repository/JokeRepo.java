package com.example.springmongodb.repository;

import com.example.springmongodb.model.Joke;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JokeRepo extends MongoRepository<Joke, Integer> {
    String findByType(String type);

    String dosomething();
}
