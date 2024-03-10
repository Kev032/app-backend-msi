package com.cibertec.repo;

import com.cibertec.models.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpedienteRepo extends JpaRepository<Expediente, Integer> {

    Expediente findByAsunto(String asunto);

}
