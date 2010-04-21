package br.com.bookstore.cliente;

import java.io.Serializable;


/**
 * Enumeration para determinar o perfil de um determinado usu�rio
 * no Sistema. Inicialmente, todo que qualquer usu�rio cadastrado
 * atrav�s da aplica��o WEB assumir� o papel de Cliente. Usu�rios 
 * com o perfil Administrador j� estar�o cadastrados a priori, de 
 * forma externa � aplica��o.
 * 
 * @author Adelino Ferreira - bugass@gmail.com
 *
 */
public enum Perfil  implements Serializable {

	/* usu�rio t�pico, que pode realizar compras */
	Cliente,
	
	/* usu�rio criado de forma externa, capaz de realizar tarefas administrativas */
	Administrador;
	
}
