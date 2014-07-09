/**
 * 
 */
package supermercado_mann;

/**
 * @author Anderson_M_Mann
 *
 */
public class SocioV2 {

	private String nome;
	private int matricula;	
	private String categoria;	
	private String modalidade;
	private double valorMensalidade;	
	
	public SocioV2(String nome, int matricula, String categoria,String modalidade) throws EstadioException {
		checkNome(nome);
		checkMatricula(matricula);
		if (categoria.equals("CAMPEAO DO MUNDO")) {
			setCategoria(categoria);
			valorMensalidade = 40;
		}
		if (categoria.equals("NADA VAI NOS SEPARAR")) {
			setCategoria(categoria);
			valorMensalidade = 60;
		}
		this.nome = nome;
		this.matricula = matricula;
		this.categoria = categoria;
		this.modalidade = modalidade;		
	}
	
	private void setCategoria(String categoria) {
		this.categoria = categoria;
		
	}

	/**
	 * Method checkNome.
	 * 
	 * @return - Verifica se o nome foi preenchido.
	 */
	private void checkNome(String none) throws EstadioException {
		if (none == null || "".equalsIgnoreCase(none)) {
			throw new EstadioException("O nome não pode ser null.");
		}
	}

	/**
	 * Method checkMatricula.
	 * 
	 * @return - Verifica se a matricula foi preenchida.
	 */
	private void checkMatricula(int matricula) throws EstadioException {
		if (matricula < 0) {
			throw new EstadioException("A matricula não pode ser null.");
		}
	}

	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @return the matricula
	 */
	public int getMatricula() {
		return matricula;
	}


	/**
	 * @return the categoria2
	 */
	public String getCategoria() {
		return categoria;
	}


	/**
	 * @return the modalidade2
	 */
	public String getModalidade() {
		return modalidade;
	}


	/**
	 * @return the valorMensalidade
	 */
	public double getValorMensalidade() {
		return valorMensalidade;
	}
	
	@Override
	public String toString() {
		return String
				.format("Dados do socio [nome= %s, matricula= %s, categoria= %s, modaliade= %s, valorMensaliade= %s]",
						nome, matricula, categoria, modalidade,
						valorMensalidade);
	}
	
}
