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


        Flight flight2 = new Flight
            ("Doha", 100,
                    "2023-08-10",
                 "09:00");

        Flight flight3 = new Flight
            ("Dubai", 100,
                    "2023-09-10",
                 "11:00");


        Passenger passenger1 =new Passenger("John Doe");
        Passenger passenger2 =new Passenger("John Boe");
        Passenger passenger3 =new Passenger("John Loe");
        Passenger passenger4 =new Passenger("John Soe");
        Passenger passenger5 =new Passenger("John Coe");
        Passenger passenger6 =new Passenger("John Moe");
        Passenger passenger7 =new Passenger("John Roe");
        Passenger passenger8 =new Passenger("John Poe");
        Passenger passenger9 =new Passenger("John Yoe");
        Passenger passenger10 =new Passenger("John Toe");


        passengerRepository.saveAll( Arrays.asList(
                passenger1,
                passenger2,
                passenger3,
                passenger4,
                passenger5,
                passenger6,
                passenger7,
                passenger8,
                passenger9,
                passenger10 ));

        flight1.addPassenger(passenger1);
        flight1.addPassenger(passenger2);
        flight1.addPassenger(passenger3);
        flight1.addPassenger(passenger4);
        flight1.addPassenger(passenger4);

        flight2.addPassenger(passenger1);
        flight2.addPassenger(passenger5);
        flight2.addPassenger(passenger6);
        flight2.addPassenger(passenger7);
        flight2.addPassenger(passenger8);

        flight3.addPassenger(passenger1);
        flight3.addPassenger(passenger8);
        flight3.addPassenger(passenger9);
        flight3.addPassenger(passenger10);

        flightRepository.saveAll(
                Arrays.asList(
                flight1,
                flight2,
                flight3 ));







    }
}
