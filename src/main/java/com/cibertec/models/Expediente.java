package com.cibertec.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@Entity
@Table(name = "Expedientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExpediente;

    @Column(name = "asunto", nullable = false)
    private String asunto;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_area", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "id_contribuyente", nullable = false)
    private Contribuyente contribuyente;

    @Column(name = "costo", nullable = false)
    private Double costo;

}