package com.zends.condominio.funcionario.domains;


import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2581736598371625253L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	@NotNull(message = "O campo local deve ser informado")
	@Size(min = 5, max = 100, message = "O campo deve ter no minimo 5 caracteres e no maximo 100 caracteres")
	private String nome;
	
	@Column
	@NotNull
	private Number telefone;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private Number cpf;
	
	@Column
	@NotNull
	private Number rg;
	
	
	
	@Column
	@NotNull
	private String rgEmissor;
	
	@Column
	@NotNull
	private Date rgEmissorData;
	
	@Column
	@NotNull
	private Number tituloEleitor;
	
	@Column
	@NotNull
	private Number carteiraTrabalhoNo;
	
	@Column
	@NotNull
	private Number carteiraTrabalhoSerie;
	
	@Column
	@NotNull
	private String carteiraTrabalhoUf;
	
	@Column
	@NotNull
	private Date carteiraTrabalhoEmissorData;
	
	@Column
	@NotNull
	private Number pisPasep;
	
	@Column
	@NotNull
	private String escolaridade;
	
	@Column
	@NotNull
	private String sexo;
	
	@Column
	@NotNull
	private String estadoCivil;
	


	@NotNull(message = "O campo data deve ser informado")
	@Column
	private Date data;

	@Column
	@NotNull
	private String endereco;
	
	@Column
	@NotNull
	private Number enderecoNo;
	
	@Column
	@NotNull
	private String enderecoCep;
	
	@Column
	@NotNull
	private String enderecoBairro;
	
	@Column
	@NotNull
	private String enderecoCidade;
	
	@Column
	@NotNull
	private String enderecoEstado;

	@Column
	@NotNull
	private String dependente;
	
	@Column
	@NotNull
	private String parentesco;
	
	@Column
	@NotNull
	private Date dependenteDataNascimento;
	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	public Number getTelefone() {
		return telefone;
	}



	public void setTelefone(Number telefone) {
		this.telefone = telefone;
	}


	

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Number getCpf() {
		return cpf;
	}



	public void setCpf(Number cpf) {
		this.cpf = cpf;
	}

	
	public Number getRg() {
		return rg;
	}



	public void setRg(Number rg) {
		this.rg = rg;
	}	
	
	
	public String getRgEmissor() {
		return rgEmissor;
	}



	public void setRgEmissor(String rgEmissor) {
		this.rgEmissor = rgEmissor;
	}

	
	

	public Number getTituloEleitor() {
		return tituloEleitor;
	}



	public void setTituloEleitor(Number tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}



	public Number getCarteiraTrabalhoNo() {
		return carteiraTrabalhoNo;
	}



	public void setCarteiraTrabalhoNo(Number carteiraTrabalhoNo) {
		this.carteiraTrabalhoNo = carteiraTrabalhoNo;
	}



	public Number getCarteiraTrabalhoSerie() {
		return carteiraTrabalhoSerie;
	}



	public void setCarteiraTrabalhoSerie(Number carteiraTrabalhoSerie) {
		this.carteiraTrabalhoSerie = carteiraTrabalhoSerie;
	}



	public String getCarteiraTrabalhoUf() {
		return carteiraTrabalhoUf;
	}



	public void setCarteiraTrabalhoUf(String carteiraTrabalhoUf) {
		this.carteiraTrabalhoUf = carteiraTrabalhoUf;
	}



	public Date getCarteiraTrabalhoEmissorData() {
		return carteiraTrabalhoEmissorData;
	}



	public void setCarteiraTrabalhoEmissorData(Date carteiraTrabalhoEmissorData) {
		this.carteiraTrabalhoEmissorData = carteiraTrabalhoEmissorData;
	}


	
	
	
	
	public Number getPisPasep() {
		return pisPasep;
	}



	public void setPisPasep(Number pisPasep) {
		this.pisPasep = pisPasep;
	}



	public String getEscolaridade() {
		return escolaridade;
	}



	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public String getEstadoCivil() {
		return estadoCivil;
	}



	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}



	public Date getRgEmissorData() {
		return rgEmissorData;
	}



	public void setRgEmissorData(Date rgEmissorData) {
		this.rgEmissorData = rgEmissorData;
	}


	
	
	
	

	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public Number getEnderecoNo() {
		return enderecoNo;
	}



	public void setEnderecoNo(Number enderecoNo) {
		this.enderecoNo = enderecoNo;
	}



	public String getEnderecoCep() {
		return enderecoCep;
	}



	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}



	public String getEnderecoBairro() {
		return enderecoBairro;
	}



	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}



	public String getEnderecoCidade() {
		return enderecoCidade;
	}



	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}



	public String getEnderecoEstado() {
		return enderecoEstado;
	}



	public void setEnderecoEstado(String enderecoEstado) {
		this.enderecoEstado = enderecoEstado;
	}



	public String getDependente() {
		return dependente;
	}



	public void setDependente(String dependente) {
		this.dependente = dependente;
	}



	public String getParentesco() {
		return parentesco;
	}



	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}



	public Date getDependenteDataNascimento() {
		return dependenteDataNascimento;
	}



	public void setDependenteDataNascimento(Date dependenteDataNascimento) {
		this.dependenteDataNascimento = dependenteDataNascimento;
	}





	
	
	
	
}

