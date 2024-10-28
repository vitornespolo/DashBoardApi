package com.consumir.api.dashboard.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MODULO")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "NOME", nullable = false)
    private String nome;

    @Override
    public String toString() {

        return nome;
    }
}
