package br.com.bookstore.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.bookstore.cliente.GenrenciadorCliente;
import br.com.bookstore.cliente.Usuario;
import br.com.bookstore.exceptions.ClienteException;

@Stateless
@Remote(ClienteBeanModel.class)
public class ClienteBeanGen implements ClienteBeanModel {

 private GenrenciadorCliente gem;
	 
	 public ClienteBeanGen(){
		 gem = new GenrenciadorCliente();
	 }
	 
	@Override
	public void cadastrarCliente(Usuario cliente) throws ClienteException {

		gem.persist(cliente);
		
	}

	@Override
	public void editarCliente(Usuario cliente) throws ClienteException {
		
		gem.edit(cliente);
		
	}

	@Override
	public List<Usuario> listarClientes() {
		// TODO Auto-generated method stub
		return gem.getTodosOsClientes();
	}

	@Override
	public List<String> obterCidades(String estado) {
		// TODO Auto-generated method stub
		return gem.getCidades(estado);
	}

	@Override
	public Usuario obterCliente(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> obterTodosOsEstados() {
		// TODO Auto-generated method stub
		return gem.getTodosOsEstados();
	}

	@Override
	public void removerCliente(Usuario cliente) throws ClienteException {
		// TODO Auto-generated method stub
		
	}

}
