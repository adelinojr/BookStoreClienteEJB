package br.com.bookstore.integracao;

import java.util.List;

import br.com.bookstore.cliente.Usuario;
import br.com.bookstore.exceptions.ClienteException;

public interface ClienteDao {

	/**
	 * Realiza o cadastro de um novo cliente. O cadastro não deve ser permitido
	 * caso o cliente esteja marcado com o perfil de administrador. Da mesma forma,
	 * o cadastro também não deve ser permitido caso já exista um cliente com o mesmo
	 * CPF cadastrado na base de dados da aplicação.
	 * 
	 * @param cliente o Cliente a ser cadastrado.
	 * @throws ClienteException Caso o cliente a ser cadastrado já exista na base de dados, possua alguma
	 * 							informação inválida, ou esteja com o perfil de administrador configurado.
	 */
	public void insertCliente( Usuario cliente );
	
	/**
	 * Exclui um cliente da base de dados da aplicação. Não deve ser possível, via aplicação,
	 * remover um usuário, cujo perfil seja administrador. 
	 * 
	 * @param cliente O cliente a ser removido
	 * @throws ClienteException Caso o cliente a ser removido não exista, ou possua o perfil de administrador.
	 * @throws Exception 
	 */
	public void deleteCliente( Usuario cliente ) throws Exception;
	
	/**
	 * Permite modificar as informações cadastrais de um cliente. Não deve ser possível alterar o CPF
	 * do cliente, nem mudar o seu perfil. As informações atuais do cliente serão subistituídas pelas 
	 * informações fornecidas através do objeto passado como parâmetro.
	 * 
	 * @param cliente O cliente cujas informações serão modificadas.
	 * @throws ClienteException Caso existam restrições nos dados fornecidos através do novo objeto passado
	 * 							como parâmetro ou o cliente a ser modificado não exista nas bases de dados.
	 */
	public void updateCliente( Usuario cliente );
	
	/**
	 * Obtém uma lista com todos os clientes cadastrados na aplicação. Esta lista não deve conter usuários
	 * marcados como administradores.
	 * 
	 * @return Uma lista com todos os clientes cadastrados, ou uma lista vazia, caso não exista nenhum
	 * 			cliente cadastrado.
	 */
	public List<Usuario> searchClientes();

	/**
	 * Obtém o cliente representado pelo CPF passado como parâmetro. Usuários que possuem o perfil
	 * de administrador não são visíveis a esta chamada.
	 * 
	 * @param cpf o CPF usado para recuperar o cliente específico.
	 * @return o cliente cujo CPF foi passado como parâmetro, ou null, caso não exista cliente cadastrado
	 * 			com o CPF em questão.
	 * @throws Exception 
	 */
	public Usuario searchCliente( String cpf ) throws Exception; 
	
	public Usuario serachClienteId(Integer id );

}
