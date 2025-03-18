package com.honors.assignmentf.repository;

import com.honors.assignmentf.dto.Flight;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class FlightRepository {
    Map<String, Flight> flightsTable;

    @PostConstruct
    public void init(){
        flightsTable = new HashMap<>();
        Flight fl = new Flight("f1","nagpur","delhi", LocalDateTime.parse("2025-03-20T10:00:00"),LocalDateTime.parse("2025-03-20T10:00:00"));
        flightsTable.put("1",fl);
    }

    public List<Flight> getAllFlights(@RequestParam(required = false, defaultValue = "asc", name = "sort") String sort){
//        return new ArrayList<>(flightsTable.values());
        List<Flight> flights = new ArrayList<>(flightsTable.values());

        if ("desc".equalsIgnoreCase(sort)) {
            flights.sort(Comparator.comparing(Flight::getDepartureTime).reversed());
        } else {
            flights.sort(Comparator.comparing(Flight::getDepartureTime));
        }

        return flights;
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

    public List<Flight> getFlightSchedules(String flightId, List<String> dates) {
        Flight flight = flightsTable.get(flightId);

        if (flight == null) {
            return new ArrayList<>(); // Return empty list if flight not found
        }

        // Convert string dates to LocalDate
        List<LocalDate> requestedDates = dates != null ?
                dates.stream().map(LocalDate::parse).collect(Collectors.toList()) :
                new ArrayList<>();

        // Here, we assume schedules are stored in `flight` (Modify this part based on your actual data model)
        return requestedDates.isEmpty() ?
                List.of(flight) :
                requestedDates.stream()
                        .map(date -> flight.toBuilder().departureTime(date.atTime(flight.getDepartureTime().toLocalTime())).build())
                        .collect(Collectors.toList());
    }
}
