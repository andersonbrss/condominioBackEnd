package com.zends.condominio.ata.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zends.condominio.pauta.domains.Pauta;
import com.zends.condominio.upload.domain.Upload;

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
	
	@OneToOne
	@JoinColumn(name = "pauta_id", unique = true)
	private Pauta pauta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "upload_id", unique = true)	
	private Upload upload;
	
	public Pauta getPauta() {	
		return  pauta;		
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}
		
	public Upload getUpload() {
		return upload;
	}

	public void setUpload(Upload upload) {
		this.upload = upload;
	}

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
