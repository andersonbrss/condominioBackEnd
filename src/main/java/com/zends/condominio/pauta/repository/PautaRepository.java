package com.zends.condominio.pauta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zends.condominio.pauta.domains.Pauta;

@Repository
public interface PautaRepository extends JpaRepository< Pauta, Long > {

}
