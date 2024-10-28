package com.consumir.api.dashboard.repository;

import com.consumir.api.dashboard.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByOpeningDateBetween(LocalDate startDate, LocalDate endDate);
}
