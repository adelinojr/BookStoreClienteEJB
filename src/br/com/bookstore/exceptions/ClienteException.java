package br.com.bookstore.exceptions;

import java.io.Serializable;


/**
 * Exception que representa o topo da Hierarquia das possíveis
 * exceções que podem acontecer nos casos de uso que envolvem
 * a manipulação de clientes.
 * 
 * @author Adelino Ferreira - bugass@gmail.com
 */
public class ClienteException extends Exception  implements Serializable  {

	private static final long serialVersionUID = 1L;

	public ClienteException() {
		super();
	}

	public ClienteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteException(String message) {
		super(message);
	}

	
	public ClienteException(Throwable cause) {
		super(cause);
	}
}
