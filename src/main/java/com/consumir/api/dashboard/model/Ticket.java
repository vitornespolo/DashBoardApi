package com.consumir.api.dashboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne
    @JoinColumn(name = "FK_ID_CLIENT")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FK_ID_MODULE")
    private Modulo modulo;

    @Column(name = "OPENING_DATE")
    private LocalDate openingDate;

    @Column(name = "CLOSING_DATE")
    private LocalDate closingDate;

    public Cliente getCliente() {
        return cliente;
    }

    public Modulo getModulo() {
        return modulo;
    }
}
