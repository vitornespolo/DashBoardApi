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

    @NonNull
    @Column(name = "TITLE", nullable = false)
    private String title;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "FK_ID_CLIENT", nullable = false)
    private Cliente cliente;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "FK_ID_MODULE", nullable = false)
    private Modulo modulo;

    @NonNull
    @Column(name = "OPENING_DATE", nullable = false)
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
