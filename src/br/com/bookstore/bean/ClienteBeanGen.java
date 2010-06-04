package br.com.bookstore.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.bookstore.cliente.GenrenciadorCliente;
import br.com.bookstore.cliente.Usuario;
import br.com.bookstore.exceptions.ClienteException;
import br.com.bookstore.integracao.ClienteDao;

@Stateless
@Local(ClienteBeanModel.class)
public class ClienteBeanGen implements ClienteBeanModel {

	@EJB(name="BookStoreLivroEJB/ClienteDAOImp",beanInterface=ClienteDao.class)
	private ClienteDao em;
 
	private GenrenciadorCliente gem;
 
	 public ClienteBeanGen(){
		 gem = new GenrenciadorCliente();
	 }
	 
	@Override
	public void cadastrarCliente(Usuario cliente) throws ClienteException {
		
	   if( gem.VerificaPerfil(cliente) && obterCliente(cliente.getCpf().getDescCpf()) == null){	
		   em.insertCliente(cliente);
	   }else{
			throw new ClienteException("Usuario não é valido OU Usuaria já existe )");
		}
	}

	@Override
	public void editarCliente(Usuario cliente) throws ClienteException {
		Usuario cliOrigem  = em.serachClienteId(cliente.getId());
		if( cliOrigem.getCpf().getDescCpf().equals(cliente.getCpf().getDescCpf())&& gem.VerificaPerfil(cliente)){
			em.updateCliente(cliente);
		}else{
			throw new ClienteException("alteração não permitida");
		}
	}

	@Override
	public List<Usuario> listarClientes() {
		// TODO Auto-generated method stub
		return em.searchClientes();
	}

	@Override
	public List<String> obterCidades(String estado) {
		// TODO Auto-generated method stub
		return gem.getCidades(estado);
	}

	@Override
	public Usuario obterCliente(String cpf) throws ClienteException {	
		try {
			return em.searchCliente(cpf);
		} catch (Exception e) {
			throw new ClienteException("Entre em contato com Administrador- ERRO 0036");		}
	}

	@Override
	public List<String> obterTodosOsEstados() {
		// TODO Auto-generated method stub
		return gem.getTodosOsEstados();
	}

	@Override
	public void removerCliente(Usuario cliente) throws ClienteException {
		try {
			if(gem.VerificaPerfil(cliente)){
				em.deleteCliente(cliente);
			}else{
				throw new ClienteException("Usuario não é valido ( Perfil Administrador )");
			}
		} catch (Exception e) {
			throw new ClienteException("Entre em contato com Administrador- ERRO 0035");
		}
		
		
	}

}
