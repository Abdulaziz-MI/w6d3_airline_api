package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

public Flight saveFlight(FlightDTO flightDTO){
    
    Flight flight =new Flight(
            flightDTO.getDestination(),
            flightDTO.getCapacity(),
            flightDTO.getDepartureDate(),
            flightDTO.getDepartureTime());
    for (Integer passengersId : flightDTO.getPassengerIds() ){
        Passenger passenger = passengerRepository.findById(passengersId).get();
        flight.addPassenger(passenger);
    }
    
    flightRepository.save(flight);
    return flight;
}

    public Flight findFlight(Integer id){
    return flightRepository.findById(id).get();
    }

    public List<Flight> findAllFlights(){
    return flightRepository.findAll();
    }

    public Flight updateFlight(FlightDTO flightDTO, Integer id){ // ADDED
        Flight flightToUpdate = flightRepository.findById(id).get();
        flightToUpdate.setCapacity(flightDTO.getCapacity());

        // remove all existing passengers
        flightToUpdate.setPassengers(new ArrayList<Passenger>());
        // find and add passengers
        for (Integer passengerId : flightDTO.getPassengerIds()){
            Passenger passenger = passengerRepository.findById(passengerId).get();
            flightToUpdate.addPassenger(passenger);
        }
        flightRepository.save(flightToUpdate);
        return flightToUpdate;
    }

    public void deleteFlight(Flight flight){
    flightRepository.delete(flight);
    }

}
