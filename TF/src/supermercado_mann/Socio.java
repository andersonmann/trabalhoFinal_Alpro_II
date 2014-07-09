package supermercado_mann;

import java.util.Random;

/**
 * Socio, classe que modela um socio.
 * 
 * @version 1.10 7 July 2014
 * @author Anderson_M_Mann
 * 
 */

public class Socio {
	private String nome;
	private int matricula;
	private Categoria categoria;	
	private Modalidade modalidade;	
	private double valorMensalidade;

	private int numero;
	private int instanteChegada;
	private int tempoAtendimento; // quantidade de tempo que resta para o
									// cliente no caixa
	private static final Random gerador = new Random();
	public static final int tempoMinAtendimento = 5;
	public static final int tempoMaxAtendimento = 10;

	public Socio(String nome, int matricula, Categoria categoria,
			Modalidade modalidade) throws EstadioException {
		checkNome(nome);
		checkMatricula(matricula);
		if (categoria.equals(Categoria.CAMPEAO_DO_MUNDO)) {
			setCategoria(categoria);
			valorMensalidade = 40;
		}
		if (categoria.equals(Categoria.NADA_VAI_NOS_SEPARAR)) {
			setCategoria(categoria);
			valorMensalidade = 60;
		}
		this.nome = nome;
		this.matricula = matricula;
		this.modalidade = modalidade;
	}

	public Socio(int n, int c) {
		setNumero(n);
		instanteChegada = c;
		tempoAtendimento = gerador.nextInt(tempoMaxAtendimento
				- tempoMinAtendimento + 1)
				+ tempoMinAtendimento; // gera valores entre 5 e 20
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

	/*
	 * private void checkValor(double valorMensalidade) throws EstadioException
	 * { if (valorMensalidade <= 0) { throw new
	 * EstadioException("O valor deve ser maior do que zero!"); } }
	 */

	/**
	 * Method getInstanteChegada.
	 * 
	 * @return int - Retorna o momento que o socio chegou na fila.
	 */
	public int getInstanteChegada() {
		return instanteChegada;
	}

	/**
	 * Method decrementarTempoAtendimento.
	 * 
	 * @return - Diminui o tempo de atendimento.
	 */
	public void decrementarTempoAtendimento() {
		tempoAtendimento--;
	}

	/**
	 * Method getTempoAtendimento.
	 * 
	 * @return int - Retorna o tempo de atendimento.
	 */
	public int getTempoAtendimento() {
		return tempoAtendimento;
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
	 * @param matricula
	 *            the matricula to set
	 */
	public void setMatricula(int matricula) {
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
	 * @param modalidade
	 *            the modalidade to set
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

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return String
				.format("Dados do socio [nome= %s, matricula= %s, categoria= %s, modaliade= %s, valorMensaliade= %s]",
						nome, matricula, categoria, modalidade,
						valorMensalidade);
	}
}
