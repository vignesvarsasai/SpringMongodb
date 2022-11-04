package com.example.springmongodb.controller;

import com.example.springmongodb.model.ZipCode;
import com.example.springmongodb.repository.ZipRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ZipCodeController {

    @Autowired
    ZipRepo zp;
    Logger logger
            = LoggerFactory.getLogger(ZipCodeController.class);


    RestTemplate rm = new RestTemplate();

    private String ZIP_API = "https://api.zippopotam.us/us/";
    ObjectMapper om = new ObjectMapper();

    @GetMapping("/zip")
    public String getZipDetails(@RequestParam(name = "pin", defaultValue = "30002") String pincode) throws IOException {

        //ZipCode zipdetails = om.readValue(new URL(ZIP_API),ZipCode.class);
        ZipCode zipdetails = om.readValue(new URL(ZIP_API + pincode), ZipCode.class);
        zp.save(zipdetails);

        return zipdetails.toString();
    }

    @GetMapping("/zip/findAll")
    public String getAllZipDetails() throws IOException {

        List responceObjectList = new ArrayList();

        int pincode = 30001;
        for (int i = 30000; i < 31000; i++, pincode++) {
            ZipCode zipdetails = om.readValue(new URL(ZIP_API + Integer.toString(pincode)), ZipCode.class);
            responceObjectList.add(zipdetails);
            zp.save(zipdetails);

        }
        return Arrays.toString(responceObjectList.toArray());
    }

    @GetMapping("/zip/error")
    public Object errorHadnling() throws IOException {

        List responceObjectList = new ArrayList();

        int pincode = 30050;
        while (pincode < 30100) {
            try {
                ZipCode zipdetails = om.readValue(new URL(ZIP_API + Integer.toString(pincode)), ZipCode.class);
                responceObjectList.add(zipdetails);
                zp.save(zipdetails);
            } catch (HttpStatusCodeException e) {
                logger.info("Error in " + pincode);
            }
            pincode++;
        }
        return Arrays.toString(responceObjectList.toArray());
    }

}
