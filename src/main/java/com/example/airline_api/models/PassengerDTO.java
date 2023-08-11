package com.example.airline_api.models;

import java.util.List;

public class PassengerDTO {

    private String fullName;
    private String email;
    private List<Integer> flightIds;


    public PassengerDTO(String fullName, List<Integer> flightIds) {
        this.fullName = fullName;

        this.flightIds = flightIds;
    }

    public PassengerDTO(String fullName) {
        this.fullName = fullName;
    }

    public PassengerDTO() {
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getFlights() {
        return flightIds;
    }

    public void setFlights(List<Integer> flights) {
        this.flightIds = flightIds;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
