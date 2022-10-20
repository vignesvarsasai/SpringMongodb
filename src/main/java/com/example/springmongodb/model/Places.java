package com.example.springmongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



public class Places {

    @JsonProperty("place name")
    String place_name;
    @JsonProperty("longitude")
    String longitude;
    @JsonProperty("state")
    String state;
    @JsonProperty("state abbreviation")
    String state_abreviation;
    @JsonProperty("latitude")
    String latitude;

    @Override
    public String toString() {
        return "place_name='" + place_name + '\'' +
                ", longitude='" + longitude + '\'' +
                ", state='" + state + '\'' +
                ", state_abreviation='" + state_abreviation + '\'' +
                ", latitude='" + latitude + '\'';
    }
}
