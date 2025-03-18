package com.honors.assignmentf.service;

import com.honors.assignmentf.dto.Flight;
import com.honors.assignmentf.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.getAllUsers();
    }

}
