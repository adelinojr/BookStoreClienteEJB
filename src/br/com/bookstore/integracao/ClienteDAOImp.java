package br.com.bookstore.integracao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import br.com.bookstore.cliente.Usuario;

@Stateless
@Local(ClienteDao.class)
public class ClienteDAOImp implements ClienteDao {

	@PersistenceContext(name="ClienteDAOImp")
	private EntityManager em;

	public ClienteDAOImp(){
	}
	
	@Override
	public void deleteCliente(Usuario cliente) throws Exception {
			em.remove(em.find(Usuario.class, cliente.getId()));
	}

	@Override
	public void insertCliente(Usuario cliente) {
			em.persist(cliente);			
	}

	@Override
	public Usuario searchCliente(String cpf) throws Exception {
		 Usuario c = null;
			Query query = em.createQuery("select c from Usuario c where c.cpf.descCpf =?1");
			query.setParameter(1, cpf);
			try {
			  c = (Usuario) query.getSingleResult();
			} catch (NoResultException e) {
				c = null;
			} 
			return c;	
	}

	@Override
	public List<Usuario> searchClientes() {
		Query query = em.createQuery("select c from Usuario c");
		return query.getResultList();	
	}

	@Override
	public void updateCliente(Usuario cliente) {
			em.merge(cliente);
	}

	@Override
	public Usuario serachClienteId( Integer id) {
		// TODO Auto-generated method stub
		return em.find(Usuario.class, id);
	}	
	
}
