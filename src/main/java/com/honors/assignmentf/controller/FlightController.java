package com.honors.assignmentf.controller;

import com.honors.assignmentf.dto.Flight;
import com.honors.assignmentf.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping
    List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }
}
