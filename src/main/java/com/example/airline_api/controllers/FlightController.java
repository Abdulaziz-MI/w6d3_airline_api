package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.repositories.FlightRepository;
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




//    CREATE - NEW FLIGHT
    @PostMapping // Add a new flight
    public ResponseEntity<Flight> postFlight(@RequestBody FlightDTO flightDTO){
        Flight savedFlight= flightService.addFlight(flightDTO);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

//    READ - INDEXES
    @GetMapping // Display all available flights
    public ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> flights = flightService.findAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
//    READ - SHOW  BY ID
    @GetMapping(value = "/{id}") // Display details of a specific flight
    public ResponseEntity<Optional<Flight>> getFlightById(@PathVariable Integer id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }
//    READ - SHOW BY DESTINATION (ignoring letter cases)
    @GetMapping(value = "destinations/{destination}")
    public ResponseEntity<List<Flight>> getFlightsByDestination(@PathVariable String destination) {
        return new ResponseEntity<>(flightService.findAllByDestination(destination), HttpStatus.OK);
    }

//    UPDATE - EXISTING FLIGHT
    @PutMapping(value = "/{flightId}") // ADDED
    public ResponseEntity<Flight> updateFlight(@RequestBody FlightDTO flightDTO, @PathVariable Integer flightId){
        Flight flight = flightService.updateFlight(flightDTO,flightId);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

//    DELETE - FLIGHT
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Integer id){

        flightService.deleteFlight(id);
        return new ResponseEntity<>("Flight deleted", HttpStatus.GONE);
    }


}
