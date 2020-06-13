package com.zends.condominio.enquete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zends.condominio.enquete.domain.Enquete;

@Repository
public interface EnqueteRepository extends JpaRepository <Enquete, Long>{

}
