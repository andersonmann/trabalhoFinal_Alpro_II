/**
 * 
 */
package supermercado_mann;

import java.util.Random;

/**
 * @author Anderson_M_Mann
 * 
 */
public class GeradorSocios {
	private double probabilidade;
	private int quantidadeGerada;
	private static final Random gerador = new Random(); // gerador de numeros aleatorios de Java

	public GeradorSocios(double p) {		
		probabilidade = p;
		quantidadeGerada = 0;
	}
	
    /**
	 * Method gerar.
	 * 
	 * @return Boolean - Gera socios
	 */
	public boolean gerar() {
		boolean gerado = false;
		if (gerador.nextDouble() < probabilidade) {
			quantidadeGerada++;
			gerado = true;
		}
		return gerado;
	}
	
    /**
	 * Method getCapacidade.
	 * 
	 * @return int - Retorna a capacidade do jogo
	 */
	public int getQuantidadeGerada() {
		return quantidadeGerada;
	}

}
