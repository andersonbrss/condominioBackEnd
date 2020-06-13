package com.zends.condominio.ata.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zends.condominio.ata.domain.Ata;
import com.zends.condominio.ata.repository.AtaRepository;
import com.zends.condominio.comum.exception.ObjectNotFoundException;

@Service
public class AtaService implements AtaServiceImp<Ata> {

	@Autowired
	private AtaRepository dao;
	
	@Autowired
	MessageSource messageSource;
	
	@Override
	public ResponseEntity<Ata> getObj(Long idAta) {
		Optional<Ata> ata = dao.findById(idAta);
		if (!ata.isPresent()) {
			throw new ObjectNotFoundException(messageSource.getMessage("erro.consulta", null, LocaleContextHolder.getLocale()));
		}
		return new ResponseEntity<Ata>(ata.get(), HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<List<Ata>> getList() {
		List<Ata> listaAta = dao.findAllByOrderByIdDesc();
		if (listaAta.isEmpty()) {
			throw new ObjectNotFoundException(String
					.format(messageSource.getMessage("lista.vazia", null, LocaleContextHolder.getLocale()), "Ata"));
		}
		return new ResponseEntity<List<Ata>>(listaAta, HttpStatus.OK);
	}


	@Override
	@Transactional
	public ResponseEntity<Ata> save(Ata ata) {
		ata = dao.save(ata);
		if (ata.getId() == null) {
			throw new ObjectNotFoundException(String
					.format(messageSource.getMessage("erro.cadastro", null, LocaleContextHolder.getLocale()), "Ata"));
		}

		return new ResponseEntity<Ata>(ata, HttpStatus.OK);
	}

		

	@Override
	@Transactional
	public ResponseEntity<Ata> update(Ata ata) {
		if (ata.getId() == null) {
			throw new ObjectNotFoundException(String
					.format(messageSource.getMessage("erro.atualizacao", null, LocaleContextHolder.getLocale()), "Ata"));
		}
		getObj(ata.getId());
		ata = dao.save(ata);
		return new ResponseEntity<Ata>(ata, HttpStatus.OK);

	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long idObjeto) {
		getObj(idObjeto);
		dao.deleteById(idObjeto);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<List<Ata>> buscarAtaData(LocalDate dataInicio, LocalDate dataFim) {
		if (dataInicio.isAfter(dataFim)) {
			throw new ObjectNotFoundException(messageSource.getMessage("data.inicio", null, LocaleContextHolder.getLocale()));

		} else if (dataFim.isBefore(dataInicio)) {
			throw new ObjectNotFoundException(messageSource.getMessage("data.fim", null, LocaleContextHolder.getLocale()));
		}
		List<Ata> listaAta = dao.findByDataBetweenOrderByIdDesc(dataInicio, dataFim);
		if (listaAta.isEmpty()) {
			throw new ObjectNotFoundException(messageSource.getMessage("registro.data.nao.encontrado", null, LocaleContextHolder.getLocale()));
		}

		return new ResponseEntity<List<Ata>>(listaAta, HttpStatus.OK);
	}


}
