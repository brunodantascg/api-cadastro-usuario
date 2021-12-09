package com.projeto.zup.gerenciador.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

	@GeneratedValue
	@Id
	private int id;
	
	@Column(name = "primeiroNome", nullable=false)
	private String primeiroNome;
	
	@Column(name = "sobreNome", nullable=false)
	private String sobreNome;
	
	@Column(name = "email", unique=true, nullable=false)
	private String email;
	
	@Column(name = "cpf", unique=true, nullable=false, length=11)
	private String cpf;
	
	@Column(name = "dataNascimento", nullable=false)
	private String dataNascimento;

	public Usuario() {
		
	}
	
	public Usuario(int id, String primeiroNome, String sobreNome, String email, String cpf, String dataNascimento) {
		super();
		this.primeiroNome = primeiroNome;
		this.sobreNome = sobreNome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
