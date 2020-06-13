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
	private Long telefone;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private Long cpf;
	


	@Column
	@NotNull
	private Long rg;
	
	
	
	@Column
	@NotNull
	private String rgEmissor;
	
	@Column
	@NotNull
	private String rgEmissorEstado;
	
	@Column
	@NotNull
	private Date rgEmissorData;
	
	@Column
	@NotNull
	private Long tituloEleitor;
	
	@Column
	@NotNull
	private Long tituloEleitorZona;
	
	@Column
	@NotNull
	private Long tituloEleitorSecao;
	
	
	
	@Column
	@NotNull
	private Long carteiraTrabalhoNo;
	
	@Column
	@NotNull
	private Long carteiraTrabalhoSerie;
	
	@Column
	@NotNull
	private String carteiraTrabalhoUf;
	
	@Column
	@NotNull
	private Date carteiraTrabalhoEmissorData;
	
	@Column
	@NotNull
	private Long pisPasep;
	
	
	@Column
	@NotNull
	private Long reservista;
	
	
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
	private Long enderecoNo;
	
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

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public String getRgEmissor() {
		return rgEmissor;
	}

	public void setRgEmissor(String rgEmissor) {
		this.rgEmissor = rgEmissor;
	}
	
	

	public String getRgEmissorEstado() {
		return rgEmissorEstado;
	}

	public void setRgEmissorEstado(String rgEmissorEstado) {
		this.rgEmissorEstado = rgEmissorEstado;
	}

	public Date getRgEmissorData() {
		return rgEmissorData;
	}

	public void setRgEmissorData(Date rgEmissorData) {
		this.rgEmissorData = rgEmissorData;
	}

	public Long getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(Long tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
	
	

	public Long getTituloEleitorZona() {
		return tituloEleitorZona;
	}

	public void setTituloEleitorZona(Long tituloEleitorZona) {
		this.tituloEleitorZona = tituloEleitorZona;
	}

	public Long getTituloEleitorSecao() {
		return tituloEleitorSecao;
	}

	public void setTituloEleitorSecao(Long tituloEleitorSecao) {
		this.tituloEleitorSecao = tituloEleitorSecao;
	}

	public Long getCarteiraTrabalhoNo() {
		return carteiraTrabalhoNo;
	}

	public void setCarteiraTrabalhoNo(Long carteiraTrabalhoNo) {
		this.carteiraTrabalhoNo = carteiraTrabalhoNo;
	}

	public Long getCarteiraTrabalhoSerie() {
		return carteiraTrabalhoSerie;
	}

	public void setCarteiraTrabalhoSerie(Long carteiraTrabalhoSerie) {
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

	public Long getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(Long pisPasep) {
		this.pisPasep = pisPasep;
	}
	

	public Long getReservista() {
		return reservista;
	}

	public void setReservista(Long reservista) {
		this.reservista = reservista;
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

	public Long getEnderecoNo() {
		return enderecoNo;
	}

	public void setEnderecoNo(Long enderecoNo) {
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

