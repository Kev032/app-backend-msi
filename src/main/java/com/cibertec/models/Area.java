package com.cibertec.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Areas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArea;

    @Column(name = "nombre_area", nullable = false)
    private String nombreArea;

}
