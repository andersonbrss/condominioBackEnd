package com.zends.condominio.ata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zends.condominio.ata.domain.Ata;

@Repository
public interface AtaRepository extends JpaRepository< Ata, Long >{
	
	public List<Ata> findAllByOrderByIdDesc();

}
