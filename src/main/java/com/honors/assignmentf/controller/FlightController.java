package com.honors.assignmentf.controller;

import com.honors.assignmentf.dto.Flight;
import com.honors.assignmentf.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/")
    List<Flight> getAllFlights(@RequestParam(required = false, defaultValue = "asc", name = "sort") String sort){
        return flightService.getAllFlights(sort);
    }

    @PostMapping()
    Flight createFlight(@RequestBody Flight flight){
        return flightService.addFlight(flight);
    }

    @GetMapping("/{id}")
    ResponseEntity<Flight> getFlightById(@PathVariable String id){
        System.out.println("controller "+id);

        try{
            return ResponseEntity.ok().body(flightService.getFlightById(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/schedules")
    public List<Flight> getFlightSchedules( @PathVariable String id, @RequestParam(required = false) List<String> dates) {

        return flightService.getFlightSchedules(id, dates);
    }
}
