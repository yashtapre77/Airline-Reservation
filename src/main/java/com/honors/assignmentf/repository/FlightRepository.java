package com.honors.assignmentf.repository;

import com.honors.assignmentf.dto.Flight;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FlightRepository {
    Map<String, Flight> flightsTable;

    @PostConstruct
    public void init(){
        flightsTable = new HashMap<>();
        Flight fl = new Flight("1","nagpur","delhi", LocalDateTime.parse("2025-03-20T10:00:00"),LocalDateTime.parse("2025-03-20T10:00:00"));
        flightsTable.put("ngp-delhi",fl);
    }

    public List<Flight> getAllUsers(){
        return new ArrayList<>(flightsTable.values());
    }

}
