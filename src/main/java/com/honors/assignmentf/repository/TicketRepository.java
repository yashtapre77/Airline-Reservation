package com.honors.assignmentf.repository;

import com.honors.assignmentf.dto.Flight;
import com.honors.assignmentf.dto.Ticket;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TicketRepository {
    Map<String, Ticket> ticketsTable;

    @PostConstruct
    public void init(){
        ticketsTable = new HashMap<>();
        Flight flight = new Flight("1","Nagpur","Delhi", LocalDateTime.now(),LocalDateTime.now());
        Ticket ticket = new Ticket("1", "Yash","abcd@gmail.com", "A001",flight);
        ticketsTable.put("1",ticket);
    }


    public Ticket createTicket(Ticket ticket){
        String TicketId = ticket.getId();
        this.ticketsTable.put(TicketId, ticket);
        return ticket.toBuilder().id(TicketId).build();
    }

    public Ticket getTicketById(String id) {
        System.out.println("repo"+id);
        System.out.println(this);
        return this.ticketsTable.getOrDefault(id, null);
    }

    public String deleteTicket(String id){
        System.out.println(getTicketById(id));
        ticketsTable.remove(id);
        System.out.println(getTicketById(id));
        return "Ticket Deleted Succesfully";
    }
}
