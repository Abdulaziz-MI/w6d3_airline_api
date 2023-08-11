package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightService flightService;
    public Passenger addPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger(passengerDTO.getFullName());
        return passengerRepository.save(passenger);
    }

    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

    public Passenger findPassenger(Integer id){
        return passengerRepository.findById(id).get();
    }

    public List<Passenger> findAllPassengers(){
        return passengerRepository.findAll();
    }

//    public void deletePassenger(Integer id) {
//        Optional<Passenger> passengerOptional = passengerRepository.findById(id);
//
//        if (passengerOptional.isPresent()) {
//            Passenger passenger = passengerOptional.get();
//            passenger.getFlights().clear();
//            passengerRepository.deleteById(id);
//        }
//    }
    }





