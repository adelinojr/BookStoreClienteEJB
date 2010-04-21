package br.com.bookstore.cliente;

import java.io.Serializable;


/**
 * Enumeration para determinar o perfil de um determinado usuário
 * no Sistema. Inicialmente, todo que qualquer usuário cadastrado
 * através da aplicação WEB assumirá o papel de Cliente. Usuários 
 * com o perfil Administrador já estarão cadastrados a priori, de 
 * forma externa à aplicação.
 * 
 * @author Adelino Ferreira - bugass@gmail.com
 *
 */
public enum Perfil  implements Serializable {

	/* usuário típico, que pode realizar compras */
	Cliente,
	
	/* usuário criado de forma externa, capaz de realizar tarefas administrativas */
	Administrador;
	
}
