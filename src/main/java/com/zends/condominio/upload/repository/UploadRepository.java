package com.zends.condominio.upload.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zends.condominio.upload.domain.Upload;

@Repository
public interface UploadRepository extends JpaRepository<Upload, Long> {

	public List<Upload> findAllByOrderByIdDesc();
}