package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {


    @Autowired
    FlightService flightService;


    @GetMapping // Display all available flights
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}") // Display details of a specific flight
    public ResponseEntity<Optional<Flight>> getChocolate(@PathVariable Integer id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }


    @PostMapping // Add a new passenger
    public ResponseEntity<Flight> postFlight(@RequestBody FlightDTO flightDTO){
        Flight savedFlight= flightService.saveFlight(flightDTO);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}") // ADDED
    public ResponseEntity<Flight> updateFlight(@RequestBody FlightDTO flightDTO, @PathVariable Integer id){
        Flight flight = flightService.updateFlight(flightDTO,id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteFlight(@RequestBody FlightDTO flightDTO, @PathVariable Integer id){
        Flight flight = flightService.saveFlight(flightDTO);
        flightService.deleteFlight(flight);
        return new ResponseEntity<>("Flight deleted", HttpStatus.GONE);
    }
}
