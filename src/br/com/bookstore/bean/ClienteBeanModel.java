package br.com.bookstore.bean;

import java.util.List;

import br.com.bookstore.cliente.Usuario;
import br.com.bookstore.exceptions.ClienteException;

/**
 * Fachada que concentra o ponto de entrada para todas
 * as opera��es que envolvem o gerenciamento de clientes.
 * 
 * @author Adelino Ferreira - bugass@gmail.com
 */
public interface ClienteBeanModel {

	/**
	 * Realiza o cadastro de um novo cliente. O cadastro n�o deve ser permitido
	 * caso o cliente esteja marcado com o perfil de administrador. Da mesma forma,
	 * o cadastro tamb�m n�o deve ser permitido caso j� exista um cliente com o mesmo
	 * CPF cadastrado na base de dados da aplica��o.
	 * 
	 * @param cliente o Cliente a ser cadastrado.
	 * @throws ClienteException Caso o cliente a ser cadastrado j� exista na base de dados, possua alguma
	 * 							informa��o inv�lida, ou esteja com o perfil de administrador configurado.
	 */
	public void cadastrarCliente( Usuario cliente ) throws ClienteException;
	
	/**
	 * Exclui um cliente da base de dados da aplica��o. N�o deve ser poss�vel, via aplica��o,
	 * remover um usu�rio, cujo perfil seja administrador. 
	 * 
	 * @param cliente O cliente a ser removido
	 * @throws ClienteException Caso o cliente a ser removido n�o exista, ou possua o perfil de administrador.
	 */
	public void removerCliente( Usuario cliente ) throws ClienteException;
	
	/**
	 * Permite modificar as informa��es cadastrais de um cliente. N�o deve ser poss�vel alterar o CPF
	 * do cliente, nem mudar o seu perfil. As informa��es atuais do cliente ser�o subistitu�das pelas 
	 * informa��es fornecidas atrav�s do objeto passado como par�metro.
	 * 
	 * @param cliente O cliente cujas informa��es ser�o modificadas.
	 * @throws ClienteException Caso existam restri��es nos dados fornecidos atrav�s do novo objeto passado
	 * 							como par�metro ou o cliente a ser modificado n�o exista nas bases de dados.
	 */
	public void editarCliente( Usuario cliente ) throws ClienteException;
	
	/**
	 * Obt�m uma lista com todos os clientes cadastrados na aplica��o. Esta lista n�o deve conter usu�rios
	 * marcados como administradores.
	 * 
	 * @return Uma lista com todos os clientes cadastrados, ou uma lista vazia, caso n�o exista nenhum
	 * 			cliente cadastrado.
	 */
	public List<Usuario> listarClientes();

	/**
	 * Obt�m o cliente representado pelo CPF passado como par�metro. Usu�rios que possuem o perfil
	 * de administrador n�o s�o vis�veis a esta chamada.
	 * 
	 * @param cpf o CPF usado para recuperar o cliente espec�fico.
	 * @return o cliente cujo CPF foi passado como par�metro, ou null, caso n�o exista cliente cadastrado
	 * 			com o CPF em quest�o.
	 */
	public Usuario obterCliente( String cpf ); 
	
	/**
	 * Obt�m uma lista com todos os estados reconhecidos pela aplica��o.
	 * @return Uma lista com os estados em formato String.
	 */
	public List<String> obterTodosOsEstados();
	
	/**
	 * Obt�m todas as cidades referentes ao estado passado como par�metro.
	 * @param estado o estado para o qual estamos procurando a cidade.
	 * @return O conjunto de cidades referentes ao estado, ou uma lista vazia, 
	 * 			caso n�o haja cidades cadastradas.
	 */
	public List<String> obterCidades( String estado );
	
}
