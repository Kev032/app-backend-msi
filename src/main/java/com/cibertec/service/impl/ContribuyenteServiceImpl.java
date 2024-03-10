package com.cibertec.service.impl;

import com.cibertec.models.Contribuyente;
import com.cibertec.repo.ContribuyenteRepo;
import com.cibertec.service.ContribuyenteService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
	
	@Autowired
	ContribuyenteRepo conrepo;

	@Override
	public List<Contribuyente> list() {
		return conrepo.findAll();
	}

	@Override
	public Contribuyente add(Contribuyente c) {
		return conrepo.save(c);
	}

	@Override
	public Optional<Contribuyente> find(int id) {
		return conrepo.findById(id);
	}

	@Override
	public Contribuyente getContribuyenteById(int id) {
		return conrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contribuyente not found"));
	}

	@Override
	public Contribuyente update(Contribuyente c) {
		return conrepo.save(c);
	}

	@Override
	public void delete(int id) {
		conrepo.deleteById(id);
		
	}

}
