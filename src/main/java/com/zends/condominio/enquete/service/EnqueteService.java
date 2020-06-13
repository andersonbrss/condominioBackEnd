package com.zends.condominio.enquete.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zends.condominio.comum.exception.DataException;
import com.zends.condominio.comum.exception.ObjectNotFoundException;
import com.zends.condominio.comum.service.AbstractService;
import com.zends.condominio.enquete.domain.Enquete;
import com.zends.condominio.enquete.repository.EnqueteRepository;





@Service
public class EnqueteService implements AbstractService<Enquete> {

	@Autowired
	private EnqueteRepository dao;

	@Override
	public ResponseEntity<Enquete> getObj(Long idEnquete) {
		Optional<Enquete> enquete = dao.findById(idEnquete);
		if (!enquete.isPresent()) {
			
			throw new ObjectNotFoundException("no busca enquete: " + idEnquete
					+ "" + Enquete.class.getName());
			
		}
		
		return new ResponseEntity<Enquete>(enquete.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Enquete>> getList() {
		// TODO Auto-generated method stub
		List<Enquete> listaEnquete = dao.findAll();
		if (listaEnquete.isEmpty() ) {
			throw new ObjectNotFoundException("lista enquete vazio");
		}
		
		return new ResponseEntity<List<Enquete>>(listaEnquete, HttpStatus.OK);
		
	}
	
	

	@Override
	@Transactional
	public ResponseEntity<Enquete> save(Enquete enquete) {
		// TODO Auto-generated method stub
		enquete = dao.save(enquete);
		if (enquete.getId() == null) {
			throw new DataException("no enquete cadastro" + Enquete.class.getName());
		}
		return new ResponseEntity<Enquete>(enquete, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<Enquete> update(Enquete enquete) {
		// TODO Auto-generated method stub
		if (enquete.getId() == null) {
			throw new ObjectNotFoundException("no enquete atualiza" + enquete.getId()
			+ "" + Enquete.class.getName());
		}
		getObj(enquete.getId());
		enquete = dao.save(enquete);
		return new ResponseEntity<Enquete>(enquete, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long idDominio) {
		// TODO Auto-generated method stub
		
		getObj(idDominio);
		dao.deleteById(idDominio);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	

}
