package br.com.bookstore.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.bookstore.cliente.Usuario;
import br.com.bookstore.exceptions.ClienteException;
import br.com.bookstore.integracao.ClienteDao;

@Stateless
@Local(ClienteBeanModel.class)
public class ClienteBeanGen implements ClienteBeanModel {

	@EJB(name="BookStoreLivroEJB/ClienteDAOImp",beanInterface=ClienteDao.class)
	private ClienteDao em;
 
 
	 public ClienteBeanGen(){
	 }
	 
	@Override
	public void cadastrarCliente(Usuario cliente) throws ClienteException {

		em.insertCliente(cliente);
		
	}

	@Override
	public void editarCliente(Usuario cliente) throws ClienteException {
		
		em.updateCliente(cliente);
		
	}

	@Override
	public List<Usuario> listarClientes() {
		// TODO Auto-generated method stub
		return em.searchClientes();
	}

	@Override
	public List<String> obterCidades(String estado) {
		// TODO Auto-generated method stub
		return em.searchCidades(estado);
	}

	@Override
	public Usuario obterCliente(String cpf) throws ClienteException {
		// TODO Auto-generated method stub
		return em.searchCliente(cpf);
	}

	@Override
	public List<String> obterTodosOsEstados() {
		// TODO Auto-generated method stub
		return em.searchTodosOsEstados();
	}

	@Override
	public void removerCliente(Usuario cliente) throws ClienteException {
		em.deleteCliente(cliente);
		
	}

}
