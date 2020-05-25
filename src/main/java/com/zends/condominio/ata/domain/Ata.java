package com.zends.condominio.ata.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ata implements Serializable{
	private static final long serialVersionUID = -6660916862753191168L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ata_id")
	private Long id;
	
	@Column(length = 500)	
	@Size(max = 500, message = "O campo deve ter no maximo 100 caracteres")
	private String consideracoesFinais;
	
	@NotNull(message = "O campo data deve ser informado")
	@Column
	private LocalDate data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConsideracoesFinais() {
		return consideracoesFinais;
	}

	public void setConsideracoesFinais(String consideracoesFinais) {
		this.consideracoesFinais = consideracoesFinais;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	

}
