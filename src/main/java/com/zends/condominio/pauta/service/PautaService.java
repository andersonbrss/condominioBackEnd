package com.zends.condominio.pauta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zends.condominio.comum.service.AbstractService;
import com.zends.condominio.pauta.domains.Pauta;
import com.zends.condominio.pauta.repository.IPautaRepository;

@Service
public class PautaService implements AbstractService< Pauta > {

	@Autowired
	private IPautaRepository dao;
	
	@Override
	public ResponseEntity<Pauta> getObj(Long idPauta) {
		Optional< Pauta > pauta = dao.findById( idPauta );
		if( !pauta.isPresent() ) {
			return new ResponseEntity< Pauta >( HttpStatus.NOT_FOUND );
		}
		
		return new ResponseEntity< Pauta >( pauta.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Pauta>> getList() {
		List< Pauta > listaPauta = dao.findAll();
		if( listaPauta.isEmpty() ) {
			return new ResponseEntity< List< Pauta >> ( HttpStatus.NOT_FOUND );			
		}
		
		return new ResponseEntity< List< Pauta >> ( listaPauta, HttpStatus.OK );
	}

	@Override
	@Transactional
	public ResponseEntity<Pauta> save(Pauta pauta) {
		pauta = dao.save( pauta );
		if( pauta.getId() == null ) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND );			
		}
		
		return new ResponseEntity< Pauta > ( pauta, HttpStatus.OK ) ;
	}

	@Override
	@Transactional
	public ResponseEntity<Pauta> update(Pauta pauta) {
		pauta = dao.save( pauta );
		
		return new ResponseEntity< Pauta > ( pauta, HttpStatus.OK );
	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long idDominio) {
		dao.deleteById( idDominio );
		
		return ResponseEntity.ok().body( "Registro excluido com sucesso." );
	}

}
