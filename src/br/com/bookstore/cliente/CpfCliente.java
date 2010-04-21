package br.com.bookstore.cliente;

import java.io.Serializable;

/**
 * Informações sobre o CPF de um usuário.
 * 
 * @author Adelino Ferreira - bugass@gmail.com
 */

public class CpfCliente implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroCpf;
	private String divitoVerificador;
	
	public CpfCliente (){
		
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
}
