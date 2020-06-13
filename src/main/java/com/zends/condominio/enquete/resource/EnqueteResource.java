package com.zends.condominio.enquete.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

import com.zends.condominio.comum.service.AbstractService;
import com.zends.condominio.comum.uteis.Log;
import com.zends.condominio.enquete.domain.Enquete;



@CrossOrigin("*")
@RestController
@RequestMapping("/enquete")
public class EnqueteResource {
	
	
	@Autowired
	private AbstractService<Enquete> service;
	
	@GetMapping
	private HttpEntity<List<Enquete>> getList(){
		Log.info("LIste get");
		return service.getList();
		
	}
	
	
	
	@GetMapping("/{id}")
	private ResponseEntity<?> getEnquete(@PathVariable("id") Long IdDominio){
		Log.info("buca Enquete ID");
		return service.getObj(IdDominio);
	}
	
	
	@PostMapping
	private ResponseEntity<?> save(@RequestBody Enquete enquete){
		Log.info("cadastro enquete");
		return service.save(enquete);
		
	}
	
	@PutMapping 
	private ResponseEntity<?> update (@RequestBody Enquete enquete) {
		Log.info("atualiza enquete");
		return service.update(enquete);
	}
	
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable("id") Long idEnquete){
		Log.info("exclui Enquete");
		return service.delete(idEnquete);
	}
	

}