package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private String email;

    @JsonIgnoreProperties({"passengers"})
    @ManyToMany(mappedBy = "passengers")
    private List<Flight> flights;


    public Passenger(String fullName){
        this.fullName=fullName;
        this.email=generateEmail(fullName);
        this.flights =new ArrayList<Flight>();
    }

    public Passenger(){}












    private String generateEmail(String fullName) {
        String[] names = fullName.split(" ");
        if (names.length >= 2) {
            String firstName = names[0].toLowerCase();
            String lastName = names[1].toLowerCase();
            return firstName + "." + lastName + "@email.com";
        }
        return "Error email could not be generated";
    }

    //    GETTERS AND SETTERS

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
