package com.cibertec.controller;

import com.cibertec.models.Contribuyente;
import com.cibertec.service.ContribuyenteService;
import com.cibertec.util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contribuyente")
@CrossOrigin(origins = AppSettings.CrossOriginUrl)
public class ContribuyenteController{
	
	@Autowired
	ContribuyenteService contService;
	
	@GetMapping
	public ResponseEntity<List<Contribuyente>> list(){
		return  new ResponseEntity<>(contService.list(), HttpStatus.OK)  ;
	}
	
	@PostMapping
	public ResponseEntity<Contribuyente> add(@RequestBody Contribuyente c) {
		return new ResponseEntity<>(contService.add(c), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contribuyente> obtenerContribuyentePorId(@PathVariable("id") int id){
		Optional<Contribuyente> contribuyenteOptional = contService.find(id);

		if (contribuyenteOptional.isPresent()) {
			Contribuyente contribuyente = contribuyenteOptional.get();
			return new ResponseEntity<>(contribuyente, HttpStatus.OK);
		} else {
			// Si no se encuentra el contribuyente, devolver un ResponseEntity con HttpStatus.NOT_FOUND
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Contribuyente> update(@RequestBody Contribuyente c) {
		return new ResponseEntity<>(contService.update(c), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		contService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
