package br.com.bookstore.integracao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.bookstore.cliente.Usuario;
import br.com.bookstore.exceptions.ClienteException;

@Stateless
@Local(ClienteDao.class)
public class ClienteDAOImp implements ClienteDao {

	@PersistenceContext(name="BookStoreLivro")
	private EntityManager em;

	@Override
	public void deleteCliente(Usuario cliente) throws ClienteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCliente(Usuario cliente) throws ClienteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> searchCidades(String estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario searchCliente(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> searchClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> searchTodosOsEstados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCliente(Usuario cliente) throws ClienteException {
		// TODO Auto-generated method stub
		
	}	
	
}
