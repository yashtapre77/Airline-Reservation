package com.honors.assignmentf.repository;

import com.honors.assignmentf.dto.Flight;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class FlightRepository {
    Map<String, Flight> flightsTable;

    @PostConstruct
    public void init(){
        flightsTable = new HashMap<>();
        Flight fl = new Flight("f1","nagpur","delhi", LocalDateTime.parse("2025-03-20T10:00:00"),LocalDateTime.parse("2025-03-20T10:00:00"));
        flightsTable.put("1",fl);
    }

    public List<Flight> getAllFlights(){
        return new ArrayList<>(flightsTable.values());
    }

    public Flight addFlight(Flight flight){
//        String flightId = UUID.randomUUID().toString();
        String flightId = flight.getId();
        this.flightsTable.put(flightId, flight);
        return flight.toBuilder().id(flightId).build();
    }

    public Flight getFlightById(String id) {
        System.out.println("repo"+id);
        System.out.println(this);
        return this.flightsTable.getOrDefault(id, null);
    }
}
