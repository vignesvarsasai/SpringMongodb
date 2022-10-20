package com.example.springmongodb.controller;


import com.example.springmongodb.model.Puniversity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UniversityController {

    private String UNI_API = "https://api.nationalize.io?name=nathaniel";

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/uni")
    public String UniDisplay()
    {
       String JsonResponce = restTemplate.getForObject(UNI_API, String.class);
        return "Uni Details are" + JsonResponce;
    }

}
