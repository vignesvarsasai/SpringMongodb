package com.example.springmongodb.controller;


import com.example.springmongodb.model.Joke;
import com.example.springmongodb.repository.BookRepo;
import com.example.springmongodb.repository.JokeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class JokesContoller {

    @Autowired
    private JokeRepo jkrepo;

    RestTemplate restTemplate = new RestTemplate();

    private String JOKE_API = "https://official-joke-api.appspot.com/random_joke";

    @GetMapping("/joke")
    public String jokeController() {
        Joke joke = restTemplate.getForObject(JOKE_API, Joke.class);
        jkrepo.save(joke);

        return "The Hilarious Joke is " + joke.toString();
    }

    @GetMapping("/jokes")
    public String jokesController() {

        ArrayList<Joke> tenJokes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Joke joke = restTemplate.getForObject(JOKE_API, Joke.class);
            tenJokes.add(joke);
            jkrepo.save(joke);
        }
        String responce = "Hillarious jokes are";
        responce += '\n';
        responce += Arrays.toString(tenJokes.toArray());
        return responce;
    }


}
