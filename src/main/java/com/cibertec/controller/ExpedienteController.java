package com.cibertec.controller;

import com.cibertec.models.Area;
import com.cibertec.models.Contribuyente;
import com.cibertec.models.Expediente;
import com.cibertec.service.AreaService;
import com.cibertec.service.ContribuyenteService;
import com.cibertec.service.ExpedienteService;
import com.cibertec.util.AppSettings;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expedientes")
@CrossOrigin(origins = AppSettings.CrossOriginUrl)
public class ExpedienteController {

	@Autowired
	private ExpedienteService expedienteService;

	@Autowired
	private ContribuyenteService contribuyenteService;

	@Autowired
	private AreaService areaService;

	@GetMapping
	public List<Expediente> getAllExpedientes() {
		return expedienteService.getAllExpedientes();
	}

	@GetMapping("/{id}")
	public Expediente getExpedienteById(@PathVariable int id) {
		return expedienteService.getExpedienteById(id);
	}

	@PostMapping
	public ResponseEntity<Expediente> createExpediente(@RequestBody Expediente expediente) {
		System.out.println("Recibido: " + expediente);
		// Obtener el Área existente basado en el ID proporcionado
		Optional<Area> areaOptional = Optional.ofNullable(areaService.getAreaById(expediente.getArea().getIdArea()));
		Area area = areaOptional.orElseThrow(() -> new ResourceNotFoundException("No se encontró el área"));

		// Obtener el Contribuyente existente basado en el ID proporcionado
		Optional<Contribuyente> contribuyenteOptional = Optional.ofNullable(contribuyenteService.getContribuyenteById(expediente.getContribuyente().getIdContribuyente()));
		Contribuyente contribuyente = contribuyenteOptional.orElseThrow(() -> new ResourceNotFoundException("No se encontró el contribuyente"));

		// Asignar el Área y Contribuyente obtenidos al Expediente
		expediente.setArea(area);
		expediente.setContribuyente(contribuyente);

		return new ResponseEntity<>(expedienteService.createExpediente(expediente), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Expediente> updateExpediente(@PathVariable int id, @RequestBody Expediente updatedExpediente) {
		Expediente existingExpediente = expedienteService.getExpedienteById(id);

		if (existingExpediente != null) {
			// Mantener los campos contribuyente y area intactos
			updatedExpediente.setContribuyente(existingExpediente.getContribuyente());
			updatedExpediente.setArea(existingExpediente.getArea());

			// Actualizar los campos asunto y costo
			existingExpediente.setAsunto(updatedExpediente.getAsunto());
			existingExpediente.setCosto(updatedExpediente.getCosto());

			// Guardar el expediente actualizado
			Expediente savedExpediente = expedienteService.updateExpediente(existingExpediente);

			return new ResponseEntity<>(savedExpediente, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Expediente no encontrado con ID: " + id);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteExpediente(@PathVariable int id) {
		expedienteService.deleteExpediente(id);
	}

}
