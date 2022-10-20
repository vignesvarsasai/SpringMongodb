package com.example.springmongodb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Collection;

@Getter
@Setter

@Document(collection = "ZipCode")
@JsonIgnoreProperties
public class ZipCode {

    @Id
    @JsonProperty("post code")
    Integer post_code;
    @JsonProperty("country")
    String country;
    @JsonProperty("country abbreviation")
    String abbreviation;
    @JsonProperty("places")
    Collection<Places> places;

    @Override
    public String toString() {
        return "ZipCode{" +
                "post_code=" + post_code +
                ", country='" + country + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", places=" + places.toString() +
                '}';
    }
}
