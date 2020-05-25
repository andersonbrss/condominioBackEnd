package com.zends.condominio.pauta.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zends.condominio.pauta.domains.Pauta;

@Repository
public interface PautaRepository extends JpaRepository< Pauta, Long > {

	public List<Pauta> findByDataBetweenOrderByIdDesc(LocalDate dataInicio, LocalDate dataFim);

	public List<Pauta> findAllByOrderByDataDesc();
	
	@Query(nativeQuery = true, 
		   value ="select pauta.* from comunicado right join pauta on pauta.pauta_id = comunicado.pauta_id where comunicado.pauta_id ISNULL and pauta.data between :dataInicio and :dataFim order by pauta.pauta_id desc")
	public List<Pauta> findListaPautaVinculoComunicado(@Param("dataInicio") LocalDate dataInicio,
							   @Param("dataFim")LocalDate dataFim);
	
	@Query(nativeQuery = true, 
			   value ="select comunicado.* from pauta right join comunicado on pauta.pauta_id = comunicado.pauta_id where pauta.pauta_id = :idPauta")	
	public Pauta findPautaVinculoComunicado(@Param("idPauta") Long idPauta);
}