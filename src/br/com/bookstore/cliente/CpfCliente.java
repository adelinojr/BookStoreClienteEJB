package br.com.bookstore.cliente;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Informações sobre o CPF de um usuário.
 * 
 * @author Adelino Ferreira - bugass@gmail.com
 */

@Embeddable
public class CpfCliente implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroCpf;
	private String divitoVerificador;
	private String descCpf;
	
	public CpfCliente (){
		
	}

	public CpfCliente (String descCpf){
		this.descCpf = descCpf;
	}	
	
	public CpfCliente(String i, String divitoVerificador) {
		super();
		this.numeroCpf = i;
		this.divitoVerificador = divitoVerificador;
	}


	public String getNumeroCpf() {
		return numeroCpf;
	}

	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}

	public String getDivitoVerificador() {
		return divitoVerificador;
	}

	public void setDivitoVerificador(String divitoVerificador) {
		this.divitoVerificador = divitoVerificador;
	}

	@Override
	public String toString() {
		return numeroCpf.toString() + divitoVerificador.toString();
	}



	public void setDescCpf(String descCpf) {
		
		
		this.setNumeroCpf(descCpf.substring(0, 10));
		
		this.setDivitoVerificador(descCpf.substring(10));		
		
		this.descCpf = descCpf;
	}



	public String getDescCpf() {
		return toString();
	}
}
