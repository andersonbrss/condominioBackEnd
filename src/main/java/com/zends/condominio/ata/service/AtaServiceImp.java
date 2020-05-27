package com.zends.condominio.ata.service;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

import com.zends.condominio.comum.service.AbstractService;

public interface AtaServiceImp<T> extends AbstractService<T>{
	
	ResponseEntity<?> buscarAtaData(LocalDate dataInicio, LocalDate dataFim);

}
