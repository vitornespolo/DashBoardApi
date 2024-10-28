package com.consumir.api.dashboard.endpoint;

import com.consumir.api.dashboard.model.Ticket;
import com.consumir.api.dashboard.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tickets")
public class TicketEndpoint {

    @Autowired
    private TicketService ticketService;

    @GetMapping()
    public ResponseEntity<Map<String, Object>>findTicketsForMonthAndYear(@RequestParam int month, @RequestParam int year) {

        List<Ticket> tickets = ticketService.findTicketsForMonthAndYear(month, year);
        Map<String, Object> response = ticketService.getRetornoMapeado(tickets);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {

        Ticket ticketSalvo = ticketService.cadastrarTicket(ticket);

        return new ResponseEntity(ticketSalvo, HttpStatus.CREATED);
    }
}
