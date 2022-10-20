package com.example.springmongodb.controller;

import com.example.springmongodb.model.ZipCode;
import com.example.springmongodb.repository.ZipRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;

@RestController
public class ZipCodeController {

    @Autowired
    ZipRepo zp;

    private String ZIP_API = "https://api.zippopotam.us/us/33162";
    ObjectMapper om = new ObjectMapper();


    @GetMapping("/zip")
    public String getZipDetails() throws IOException {

        //ZipCode zipdetails = om.readValue(new URL(ZIP_API),ZipCode.class);

        ZipCode zipdetails = om.readValue(new URL(ZIP_API), ZipCode.class);
        zp.save(zipdetails);

        return zipdetails.toString();
    }


}
