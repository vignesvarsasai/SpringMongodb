package com.example.springmongodb.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter

@JsonIgnoreProperties
public class Puniversity {

        public List<String> domains = null;
        public String country;
        public String stateProvince;
        public List<String> webPages = null;
        public String name;
        public String alphaTwoCode;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();





}
