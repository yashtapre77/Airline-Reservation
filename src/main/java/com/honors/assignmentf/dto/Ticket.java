package com.honors.assignmentf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class Ticket {

    private String id;

    private String passengerName;
    private String email;
    private String seatNumber;

    private String flightId;
}
