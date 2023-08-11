package com.example.airline_api.controllers;


import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
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

    //    CREATE - NEW PASSENGER
    @PostMapping
    public ResponseEntity<Passenger> addPassenger(@RequestBody PassengerDTO passengerDTO){
        return new ResponseEntity<>(passengerService.addPassenger(passengerDTO), HttpStatus.CREATED);
    }
//    READ - INDEXES
    @GetMapping // GET all passengers
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.OK);
    }

//    READ - SHOW BY INDEX
    @GetMapping(value = "/{id}") // get passenger by Id
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Integer id){
        return new ResponseEntity(passengerService.findPassenger(id), HttpStatus.OK);
    }



//    DELETE
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<String> deletePassenger(@PathVariable Integer id){
//        passengerService.deletePassenger(id);
//        return new ResponseEntity<>("Passenger has been deleted", HttpStatus.GONE);
//    }

}
