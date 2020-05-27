package com.zends.condominio.ata.resource;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zends.condominio.ata.domain.Ata;
import com.zends.condominio.ata.service.AtaServiceImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/ata")
public class AtaResource {

	@Autowired
	private AtaServiceImp<Ata> service;
	
	@GetMapping
	private ResponseEntity<List<Ata>> buscaListaAta(){
		return service.getList();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<?> buscaAta(@PathVariable("id") Long id){
		return service.getObj(id);
	}
	
	@GetMapping("/{dataInicio}/{dataFim}")
	private ResponseEntity<?> buscaAtaData(
			@PathVariable(value = "dataInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio,
			@PathVariable(value = "dataFim") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFim) {
		return service.buscarAtaData(dataInicio, dataFim);
	}
	
	@PostMapping
	private ResponseEntity<?> save(@RequestBody Ata ata) {
		return service.save(ata);
	}

	@PutMapping
	private ResponseEntity<?> update(@RequestBody Ata ata) {
		return service.update(ata);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}
}
