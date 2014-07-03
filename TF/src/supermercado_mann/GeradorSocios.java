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

	public boolean gerar() {
		boolean gerado = false;
		if (gerador.nextDouble() < probabilidade) {
			quantidadeGerada++;
			gerado = true;
		}
		return gerado;
	}

	public int getQuantidadeGerada() {
		return quantidadeGerada;
	}

}
