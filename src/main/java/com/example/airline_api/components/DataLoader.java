package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){}


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight flight1 = new Flight
            ("Riyadh", 100,
                    "2023-08-10",
                 "08:00");
        flightRepository.save(flight1);

        Flight flight2 = new Flight
            ("Doha", 100,
                    "2023-08-10",
                 "09:00");
        flightRepository.save(flight1);

        Passenger passenger1 =new Passenger("John Doe");
        passengerRepository.save(passenger1);
        Passenger passenger2 =new Passenger("John Boe");
        passengerRepository.save(passenger2);
        Passenger passenger3 =new Passenger("John Loe");
        passengerRepository.save(passenger3);
        Passenger passenger4 =new Passenger("John Soe");
        passengerRepository.save(passenger4);


        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.addPassenger(passenger3);
        flight1.addPassenger(passenger4);
        flightRepository.save(flight1);

        flight2.addPassenger(passenger1);

        flightRepository.save(flight2);




    }
}
