package com.cibertec.service;

import com.cibertec.models.Contribuyente;

import java.util.List;
import java.util.Optional;

public interface ContribuyenteService {

	public List<Contribuyente> list();
	public Contribuyente add(Contribuyente c);
	public Optional<Contribuyente> find(int id);
	Contribuyente getContribuyenteById(int id);
	public Contribuyente update(Contribuyente c);
	public void delete(int id);

}
