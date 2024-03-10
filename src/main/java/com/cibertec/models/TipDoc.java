package com.cibertec.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TipDoc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipDoc {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipDoc;

    @Column(name = "nombre_tipoDoc", nullable = false)
    private String nombreTipoDoc;

}
