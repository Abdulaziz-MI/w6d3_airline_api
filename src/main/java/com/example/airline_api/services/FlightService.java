package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;


//    New Empty flight
    public Flight addFlight(FlightDTO flightDTO){
        Flight flight =new Flight(
            flightDTO.getDestination(),
            flightDTO.getCapacity(),
            flightDTO.getDepartureDate(),
            flightDTO.getDepartureTime());
        flightRepository.save(flight);
        return  flight;
    }
    public void saveFlight(Flight flight){
        flightRepository.save(flight);
}

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public Flight findFlight(Integer id){
        return flightRepository.findById(id).get();
    }

//    update existing flight
    public Flight updateFlight(FlightDTO flightDTO, Integer id){

        Flight flightToUpdate = flightRepository.findById(id).get();
        flightToUpdate.setDestination(flightDTO.getDestination());
        flightToUpdate.setCapacity(flightDTO.getCapacity());
        flightToUpdate.setDepartureDate(flightDTO.getDepartureDate());
        flightToUpdate.setDepartureTime(flightDTO.getDepartureTime());
        flightToUpdate.setPassengers(new ArrayList<Passenger>());

        for (Integer passengerId : flightDTO.getPassengerIds()){
            Passenger passenger = passengerRepository.findById(passengerId).get();
            flightToUpdate.addPassenger(passenger);
        }
        flightRepository.save(flightToUpdate);
        return flightToUpdate;
    }


    public Flight bookPassenger(Integer flightId, Integer passengerId) {

        Flight flight = flightRepository.findById(flightId).get();
        Passenger passenger = passengerRepository.findById(passengerId).get();
        
        if (flight.getPassengers().size()<flight.getCapacity()) {
            flight.addPassenger(passenger);
            flightRepository.save(flight);
        }
        return flight;
    }

//    derived query
    public List<Flight> findAllByDestination(String destination){
        return flightRepository.findAllByDestinationIgnoreCase(destination);
    }
    public void deleteFlight(Integer id){
        Optional<Flight> flightOptional = flightRepository.findById(id);

        if (flightOptional.isPresent()) {
            Flight flight = flightOptional.get();
          flight.getPassengers().clear();
            flightRepository.deleteById(id);
        }
    }


}
