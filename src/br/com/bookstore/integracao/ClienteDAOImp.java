package br.com.bookstore.integracao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.bookstore.cliente.GenrenciadorCliente;
import br.com.bookstore.cliente.Perfil;
import br.com.bookstore.cliente.Usuario;
import br.com.bookstore.exceptions.ClienteException;

@Stateless
@Local(ClienteDao.class)
public class ClienteDAOImp implements ClienteDao {

	@PersistenceContext(name="ClienteDAOImp")
	private EntityManager em;
	
	private GenrenciadorCliente gem;

	public ClienteDAOImp(){
		gem = new GenrenciadorCliente();
	}
	
	@Override
	public void deleteCliente(Usuario cliente) throws ClienteException {
		try {
			if(VerificaPerfil(cliente)){
				em.remove(em.find(Usuario.class, cliente.getId()));
			}else{
				throw new ClienteException("Usuario não é valido ( Perfil Administrador )");
			}
		} catch (Exception e) {
			throw new ClienteException("Entre em contato com Administrador- ERRO 0035");
		}
		
	}

	@Override
	public void insertCliente(Usuario cliente) throws ClienteException {
		if ( searchCliente(cliente.getCpf().getDescCpf()) == null){
			em.persist(cliente);	
		}else{
			throw new ClienteException("Usuaria já existe");
		}
		
	}

	@Override
	public List<String> searchCidades(String estado) {
		// TODO Auto-generated method stub
		return gem.getCidades(estado);
	}

	@Override
	public Usuario searchCliente(String cpf) throws ClienteException {
		 Usuario c = null;
			Query query = em.createQuery("select c from Usuario c where c.cpf.descCpf =?1");
			query.setParameter(1, cpf);
			try {
			  c = (Usuario) query.getSingleResult();
			} catch (NoResultException e) {
				c = null;
			} catch ( Exception e){
				throw new ClienteException("Entre em contato com Administrador- ERRO 0036");
			}
			return c;	
	}

	@Override
	public List<Usuario> searchClientes() {
		Query query = em.createQuery("select c from Usuario c");
		return query.getResultList();	
	}

	@Override
	public List<String> searchTodosOsEstados() {
		// TODO Auto-generated method stub
		return gem.getTodosOsEstados();
	}

	@Override
	public void updateCliente(Usuario cliente) throws ClienteException {
		Usuario cliOrigem  = em.find(Usuario.class, cliente.getId());
		if( cliOrigem.getCpf().getDescCpf().equals(cliente.getCpf().getDescCpf())&& VerificaPerfil(cliente)){
			em.merge(cliente);
		}else{
			throw new ClienteException("alteração não permitida");
		}	
	}	
	
	private Boolean VerificaPerfil(Usuario cli){
		if ( cli.getPerfil() == Perfil.Cliente){
			return true;
		}
		return false;
	}
	
}
