package com.zends.condominio.pauta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zends.condominio.comum.exception.DataException;
import com.zends.condominio.comum.exception.ObjectNotFoundException;
import com.zends.condominio.comum.service.AbstractService;
import com.zends.condominio.pauta.domains.Pauta;
import com.zends.condominio.pauta.repository.PautaRepository;

@Service
public class PautaService implements AbstractService<Pauta> {

	@Autowired
	private PautaRepository dao;

	@Override
	public ResponseEntity<Pauta> getObj(Long idPauta) {
		Optional<Pauta> pauta = dao.findById(idPauta);
		if (!pauta.isPresent()) {
			throw new ObjectNotFoundException("Nao foi possivel realizar a busca da pauta com id informado: " + idPauta
					+ " " + Pauta.class.getName());
		}
		return new ResponseEntity<Pauta>(pauta.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Pauta>> getList() {
		List<Pauta> listaPauta = dao.findAll();
		if (listaPauta.isEmpty()) {
			throw new ObjectNotFoundException("A lista de Pauta esta vazia ");
		}

		return new ResponseEntity<List<Pauta>>(listaPauta, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<Pauta> save(Pauta pauta) {
		pauta = dao.save(pauta);
		if (pauta.getId() == null) {
			throw new DataException("Nao foi possivel realizar o cadastro de uma pauta" + Pauta.class.getName());
		}
		
		return new ResponseEntity<Pauta>(pauta, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<Pauta> update(Pauta pauta) {
		if (pauta.getId() == null) {
			throw new ObjectNotFoundException("Nao foi possivel atualizar a pauta com ID informado" + pauta.getId()
					+ " " + Pauta.class.getName());
		}
		getObj(pauta.getId());
		pauta = dao.save(pauta);
		return new ResponseEntity<Pauta>(pauta, HttpStatus.OK);

	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long idDominio) {
		getObj(idDominio);
		dao.deleteById(idDominio);
		return ResponseEntity.noContent().build();

	}

}
