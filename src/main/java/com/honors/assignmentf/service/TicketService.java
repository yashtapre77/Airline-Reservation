package com.honors.assignmentf.service;

import com.honors.assignmentf.dto.Flight;
import com.honors.assignmentf.dto.Ticket;
import com.honors.assignmentf.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public Ticket creteTicket(Ticket ticket){
        return ticketRepository.createTicket(ticket);
    }

    public Ticket getTicketById(@PathVariable String id){
        System.out.println("service "+id);
        return ticketRepository.getTicketById(id);
    }

    public String deleteTicket(@PathVariable String id){
        return ticketRepository.deleteTicket(id);
    }
}
