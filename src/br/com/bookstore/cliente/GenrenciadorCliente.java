package br.com.bookstore.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenrenciadorCliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, List<String>> cidadesPorEstado;
	private List<Usuario> clientes;
	
	public GenrenciadorCliente() {
		this.criarMapaComEstadosECidades();
		this.criarClientes();
	}
	
	public void persist( Usuario cliente ) {
	 
		this.clientes.add(cliente);
	 
	  
	}

	public void edit(Usuario cliente) {
		for ( int i = 0; i < clientes.size(); i++ ){
			Usuario clienteRecebido = clientes.get(i);
			if ( clienteRecebido.getCpf().equals(cliente.getCpf()) ){
				clientes.set(i, cliente);
			}
		}
	}
	
	public void remove(Usuario cliente) {
		for ( int i = 0; i < clientes.size(); i++ ){
			Usuario clienteRecebido = clientes.get(i);
			if ( clienteRecebido.getCpf().equals(cliente.getCpf()) ){
				clientes.remove(i);
			}
		}
	}
	
	public List<Usuario> getTodosOsClientes(){
		return this.clientes;
	}
	
	/**
	 * Retorna todos os estados presentes na aplicação
	 * @return todos os estados
	 */
	public List<String> getTodosOsEstados(){
		return new ArrayList<String>(this.cidadesPorEstado.keySet());
	}

	/**
	 * Retorna uma lista de cidades, dado um determinado estado.
	 * 
	 * @param estado o estado para o qual se quer a lista de cidades.
	 * @return A lista de cidades correspondente ao estado passado como parâmetro
	 * 			ou uma lista vazia, caso não exista nenhuma cidade associada ao estado.
	 */
	public List<String> getCidades( String estado ){
		List<String> cidades = this.cidadesPorEstado.get(estado);
		if ( cidades == null ){
			return new ArrayList<String>();
		}
		return cidades;
	}

	private void criarClientes() {
		this.clientes = new ArrayList<Usuario>();
		
		Usuario cliente1 = new Usuario();
		cliente1.setNomeCompleto("José da Silva");
		cliente1.setCpf( new CpfCliente( "123456789","21") );
		cliente1.setDataDeNascimento(new Date());
		cliente1.setEmail("josedasilva@gmail.com");
		cliente1.setPerfil(Perfil.Cliente);
		cliente1.setSenha("123456");
		cliente1.setSexo(Sexo.Masculino);
		cliente1.setTelefoneCelular("88888888");
		cliente1.setTelefoneResidencial("33333333");
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Av Epitácio Pessoa");
		endereco.setNumero(1234);
		endereco.setBairro("Expedicionários");
		endereco.setCidade("João Pessoa");
		endereco.setEstado("Paraíba");
		endereco.setComplemento("apto 102");
		endereco.setCep("58100-000");
		
		cliente1.setEndereco(endereco);
		
		Usuario cliente2 = new Usuario();
		cliente2.setNomeCompleto("Maria da Silva");
		cliente2.setCpf(new CpfCliente( "123456789","23"));
		cliente2.setDataDeNascimento(new Date());
		cliente2.setEmail("mariadasilva@gmail.com");
		cliente2.setPerfil(Perfil.Administrador);
		cliente2.setSenha("654321");
		cliente2.setSexo(Sexo.Feminino);
		cliente2.setTelefoneCelular("99999999");
		cliente2.setTelefoneResidencial("22222222");
		
		cliente2.setEndereco(endereco);
		
		this.clientes.add(cliente1);
		this.clientes.add(cliente2);
	}
	
	/**
	 * método que popula uma lista padronizada de cidades e estados, para fazer
	 * de conta que temos um banco de dados. Na próxima disciplina, isso será
	 * removido, para que possamos usar um banco de verdade.
	 */
	private void criarMapaComEstadosECidades() {
		this.cidadesPorEstado = new HashMap<String, List<String>>();
		
		/** preenchendo cidades da Paraíba */
		List<String> cidadesDaParaiba = new ArrayList<String>();
		cidadesDaParaiba.add("Campina Grande");
		cidadesDaParaiba.add("João Pessoa");
		cidadesDaParaiba.add("Patos");
		cidadesDaParaiba.add("Sousa");
		
		cidadesPorEstado.put("Paraíba", cidadesDaParaiba);
		
		/** preenchendo cidades de Pernambuco */
		List<String> cidadesDePernambuco = new ArrayList<String>();
		cidadesDePernambuco.add("Caruaru");
		cidadesDePernambuco.add("Recife");
		cidadesDePernambuco.add("Santa Cruz");
		
		cidadesPorEstado.put("Pernambuco", cidadesDePernambuco);
		
		/** preenchendo cidades do Rio Grande do Norte */
		List<String> cidadesDoRioGrandeDoNorte = new ArrayList<String>();
		cidadesDoRioGrandeDoNorte.add("Natal");
		cidadesDoRioGrandeDoNorte.add("Mossoró");
		
		cidadesPorEstado.put("Rio Grande do Norte", cidadesDoRioGrandeDoNorte);
	}

}
