package supermercado_mann;

import java.util.Random;

public class Socio {
	protected String nome;
	protected int matricula;
	protected Categoria categoria;
	protected Modalidade modalidade;
	protected double valorMensalidade;
	
	private int instanteChegada;
	private int tempoAtendimento; // quantidade de tempo que resta para o cliente no caixa
	private static final Random gerador = new Random();
	public static final int tempoMinAtendimento = 5; 
	public static final int tempoMaxAtendimento = 10;

	
	public Socio(String nome, int matricula, Categoria categoria,Modalidade modalidade, int chegada) throws EstadioException {
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
		
		instanteChegada = chegada;
		tempoAtendimento = gerador.nextInt(tempoMaxAtendimento - tempoMinAtendimento + 1) + tempoMinAtendimento; // gera valores entre 5 e 20
		this.nome = nome;
		this.matricula = matricula;
		this.modalidade = modalidade;
	}	

	public Socio(int quantidadeGerada, int tempo) {
		
	}

	private void checkNome(String none) throws EstadioException {
		if (none == null || "".equalsIgnoreCase(none)) {
			throw new EstadioException("O nome não pode ser null.");
		}
	}

	private void checkMatricula(int matricula) throws EstadioException {
		if (matricula < 0) {
			throw new EstadioException("A matricula não pode ser null.");
		}
	}
	
	public int getInstanteChegada()
	{
	    return instanteChegada;
	}
	
	public void decrementarTempoAtendimento()
	{
	    tempoAtendimento--;
	}
	
	public int getTempoAtendimento()
	{
	    return tempoAtendimento;
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

	@Override
	public String toString() {
		return String
				.format("Dados do socio [nome= %s, matricula= %s, categoria= %s, modaliade= %s, valorMensaliade= %s]",
						nome, matricula, categoria, modalidade,
						valorMensalidade);
	}
}
