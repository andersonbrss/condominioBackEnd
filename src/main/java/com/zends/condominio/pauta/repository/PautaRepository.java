package com.zends.condominio.pauta.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zends.condominio.pauta.domains.Pauta;

@Repository
public interface PautaRepository extends JpaRepository< Pauta, Long > {

	@Transactional(readOnly=true)
	@Query(nativeQuery = true,value="SELECT * FROM pauta WHERE data BETWEEN :dataInicio AND :dataFim")
	public List<Pauta> buscaPorData(
			@Param("dataInicio") LocalDate dataInicio,
			@Param("dataFim") LocalDate dataFim);		
}
