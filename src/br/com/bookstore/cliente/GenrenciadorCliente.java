package br.com.bookstore.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenrenciadorCliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, List<String>> cidadesPorEstado;
	
	public GenrenciadorCliente() {
		this.criarMapaComEstadosECidades();
	}
	
	/**
	 * Retorna todos os estados presentes na aplica��o
	 * @return todos os estados
	 */
	public List<String> getTodosOsEstados(){
		return new ArrayList<String>(this.cidadesPorEstado.keySet());
	}

	/**
	 * Retorna uma lista de cidades, dado um determinado estado.
	 * 
	 * @param estado o estado para o qual se quer a lista de cidades.
	 * @return A lista de cidades correspondente ao estado passado como par�metro
	 * 			ou uma lista vazia, caso n�o exista nenhuma cidade associada ao estado.
	 */
	public List<String> getCidades( String estado ){
		List<String> cidades = this.cidadesPorEstado.get(estado);
		if ( cidades == null ){
			return new ArrayList<String>();
		}
		return cidades;
	}

	
	/**
	 * m�todo que popula uma lista padronizada de cidades e estados, para fazer
	 * de conta que temos um banco de dados. Na pr�xima disciplina, isso ser�
	 * removido, para que possamos usar um banco de verdade.
	 */
	private void criarMapaComEstadosECidades() {
		this.cidadesPorEstado = new HashMap<String, List<String>>();
		
		/** preenchendo cidades da Para�ba */
		List<String> cidadesDaParaiba = new ArrayList<String>();
		cidadesDaParaiba.add("Campina Grande");
		cidadesDaParaiba.add("Jo�o Pessoa");
		cidadesDaParaiba.add("Patos");
		cidadesDaParaiba.add("Sousa");
		
		cidadesPorEstado.put("Para�ba", cidadesDaParaiba);
		
		/** preenchendo cidades de Pernambuco */
		List<String> cidadesDePernambuco = new ArrayList<String>();
		cidadesDePernambuco.add("Caruaru");
		cidadesDePernambuco.add("Recife");
		cidadesDePernambuco.add("Santa Cruz");
		
		cidadesPorEstado.put("Pernambuco", cidadesDePernambuco);
		
		/** preenchendo cidades do Rio Grande do Norte */
		List<String> cidadesDoRioGrandeDoNorte = new ArrayList<String>();
		cidadesDoRioGrandeDoNorte.add("Natal");
		cidadesDoRioGrandeDoNorte.add("Mossor�");
		
		cidadesPorEstado.put("Rio Grande do Norte", cidadesDoRioGrandeDoNorte);
	}

}
