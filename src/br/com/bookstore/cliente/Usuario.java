package br.com.bookstore.cliente;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Informações sobre um usuário.
 * 
 * @author Adelino Ferreira - bugass@gmail.com
 */
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
	@Column(nullable=false)
	private String nomeCompleto;
	
	@Version
	private int versao;
	
	@Embedded
    @AttributeOverrides({
        @AttributeOverride(name="descCpf", column=@Column(name="CPF"))}
    )
	private CpfCliente cpf;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@Temporal(TemporalType.DATE)
	private Date dataDeNascimento;
	
	
	private String telefoneResidencial;
	private String telefoneCelular;
	
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String senha;
	
	private Endereco endereco;

	public Usuario(){
		
	}
	
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

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

	public int getVersao() {
		return versao;
	}
}
