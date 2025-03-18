package com.honors.assignmentf.controller;

import com.honors.assignmentf.dto.Flight;
import com.honors.assignmentf.dto.Ticket;
import com.honors.assignmentf.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping()
    Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.creteTicket(ticket);
    }

    @GetMapping("/{id}")
    ResponseEntity<Ticket> getTicketById(@PathVariable String id){
        System.out.println("controller "+id);

        try{
            return ResponseEntity.ok().body(ticketService.getTicketById(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    String deleteTicket(@PathVariable String id){
        return ticketService.deleteTicket(id);
    }
}
