package com.cibertec.service.impl;

import com.cibertec.models.Area;
import com.cibertec.models.Expediente;
import com.cibertec.models.TipDoc;
import com.cibertec.repo.ExpedienteRepo;
import com.cibertec.service.ExpedienteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpedienteServiceImpl implements ExpedienteService{


	@Autowired
	private ExpedienteRepo expedienteRepository;

	@Override
	public List<Expediente> getAllExpedientes() {
		return expedienteRepository.findAll();
	}

	@Override
	public Expediente getExpedienteById(int id) {
		return expedienteRepository.findById(id).orElse(null);
	}

	@Override
	public Expediente createExpediente(Expediente expediente) {
		return expedienteRepository.save(expediente);
	}

	@Override
	public Expediente updateExpediente(Expediente expediente) {
		return expedienteRepository.save(expediente);
	}

	@Override
	public void deleteExpediente(int id) {
		expedienteRepository.deleteById(id);
	}
}