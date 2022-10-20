package com.example.springmongodb.repository;

import com.example.springmongodb.model.ZipCode;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZipRepo extends MongoRepository<ZipCode, Integer> {
}
