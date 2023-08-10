package com.example.airline_api.controllers;


import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @GetMapping // GET all passengers
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}") // get passenger by Id
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Integer id){
        return new ResponseEntity(passengerService.findPassenger(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Passenger>> addPassenger(@RequestBody Passenger passenger){
        passengerService.savePassenger(passenger);
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.CREATED);
    }



}
