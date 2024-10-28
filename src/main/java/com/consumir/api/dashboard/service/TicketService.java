package com.consumir.api.dashboard.service;

import com.consumir.api.dashboard.model.Cliente;
import com.consumir.api.dashboard.model.Modulo;
import com.consumir.api.dashboard.model.Ticket;
import com.consumir.api.dashboard.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> findTicketsForMonthAndYear(int month, int year) {

        LocalDate dataInicio = LocalDate.of(year, month, 1);
        LocalDate dataFinal = dataInicio.with(TemporalAdjusters.lastDayOfMonth());

        return ticketRepository.findByOpeningDateBetween(dataInicio, dataFinal);
    }

    public Map<String, Object> getRetornoMapeado(List<Ticket> tickets) {

        Map<String, Object> response = new HashMap<>();
        response.put("tickets", tickets);
        response.put("ticketsPorCliente", agruparTicketsPorCliente(tickets));
        response.put("ticketsPorModulo", agruparTicketsPorModulo(tickets));

        return response;
    }

    public Ticket cadastrarTicket(Ticket ticket) {

        return ticketRepository.save(ticket);
    }

    private Map<Cliente, Long> agruparTicketsPorCliente(List<Ticket> tickets) {

        Map<Cliente, Long> ticketsPorCliente = new HashMap<>();

        tickets.stream().forEach(ticket -> ticketsPorCliente.put(ticket.getCliente(),
                        ticketsPorCliente.getOrDefault(ticket.getCliente(), 0L) + 1));

        return ticketsPorCliente;
    }

    private Map<Modulo, Long> agruparTicketsPorModulo(List<Ticket> tickets) {

        Map<Modulo, Long> ticketsPorModulo = new HashMap<>();

        tickets.stream().forEach(ticket -> ticketsPorModulo.put(ticket.getModulo(),
                ticketsPorModulo.getOrDefault(ticket.getModulo(), 0L) + 1));

        return ticketsPorModulo;

    }
}