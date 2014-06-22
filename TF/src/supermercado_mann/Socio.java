package supermercado_mann;

public class Socio {
	private String nome;
	private String matricula;
	private Categoria categoria;
	private Modalidade modalidade;
	private double valorMensalidade;

	public Socio(String nome, String matricula, Categoria categoria, Modalidade modalidade)
			throws EstadioException { 
		checkNome(nome);
		checkMatricula(matricula);
		// checkValor(valorMensalidade);
		if (categoria.equals(Categoria.CAMPEAO_DO_MUNDO)) {
			setCategoria(categoria);
			valorMensalidade = 40;
		}
		if (categoria.equals(Categoria.NADA_VAI_NOS_SEPARAR)) {
			setCategoria(categoria);
			valorMensalidade = 60;
		}
		/*
		 * if (categoria.equals(Categoria.CAMPEAO_DO_MUNDO)) { valorMensalidade
		 * = 40; } if (categoria.equals(Categoria.NADA_VAI_NOS_SEPARAR)) {
		 * valorMensalidade = 60; }
		 */
		this.nome = nome;
		this.matricula = matricula;
		this.modalidade = modalidade;
	}

	private void checkNome(String none) throws EstadioException {
		if (none == null || "".equalsIgnoreCase(none)) {
			throw new EstadioException("O nome não pode ser null.");
		}
	}

	private void checkMatricula(String matricula) throws EstadioException {
		if (matricula == null || "".equalsIgnoreCase(matricula)) {
			throw new EstadioException("A matricula não pode ser null.");
		}
	}

	/*
	 * private void checkValor(double valorMensalidade) throws EstadioException
	 * { if (valorMensalidade <= 0) { throw new
	 * EstadioException("O valor deve ser maior do que zero!"); } }
	 */

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula
	 *            the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 *            the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	/**
	 * @return the modalidade
	 */
	public Modalidade getModalidade() {
		return modalidade;
	}

	/**
	 * @param modalidade the modalidade to set
	 */
	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	/**
	 * @return the valorMensalidade
	 */
	public double getValorMensalidade() {
		return valorMensalidade;
	}

	/**
	 * @param valorMensalidade
	 *            the valorMensalidade to set
	 */
	public void setValorMensalidade(double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	@Override
	public String toString() {
		return String
				.format("Dados do socio [nome= %s, matricula= %s, categoria= %s, modaliade= %s, valorMensaliade= %s]",
						nome, matricula, categoria, modalidade, valorMensalidade);
	}
}
