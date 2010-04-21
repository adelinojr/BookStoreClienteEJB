package br.com.bookstore.cliente;

import java.io.Serializable;
import java.util.Date;

/**
 * Informações sobre um usuário.
 * 
 * @author Adelino Ferreira - bugass@gmail.com
 */
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Perfil perfil;
	
	private String nomeCompleto;
	
	private CpfCliente cpf;
	private Sexo sexo;
	private Date dataDeNascimento;
	
	private String telefoneResidencial;
	private String telefoneCelular;
	
	private String email;
	private String senha;
	
	private Endereco endereco;

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public CpfCliente getCpf() {
		return cpf;
	}

	public void setCpf(CpfCliente cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
