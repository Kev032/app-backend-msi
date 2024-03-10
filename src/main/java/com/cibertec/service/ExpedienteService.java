package com.cibertec.service;

import com.cibertec.models.Expediente;

import java.util.List;

public interface ExpedienteService {

	public List<Expediente> getAllExpedientes();

	public Expediente getExpedienteById(int id);

	public Expediente createExpediente(Expediente expediente);

	public Expediente updateExpediente(Expediente expediente);

	public void deleteExpediente(int id);
}
