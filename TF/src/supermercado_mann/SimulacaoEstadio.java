/**
 * 
 */
package supermercado_mann;

/**
 * @author Anderson_M_Mann
 * 
 */
public class SimulacaoEstadio {
	private static final int duracao = 200;
	private static final double probabilidadeChegada = 0.1;
	private QueueTADEx<Socio> fila;
	private Catraca<Object> catraca;
	private GeradorSocios geradorSocios;
	private Acumulador statTemposEsperaFila;
	private Acumulador statComprimentosFila;
	private boolean trace; // valor indica se a simulacao ira imprimir
							// passo-a-passo os resultados

	public SimulacaoEstadio(boolean t) {
		fila = new QueueLinkedEx<Socio>();
		catraca = new Catraca<>();
		geradorSocios = new GeradorSocios(probabilidadeChegada);
		statTemposEsperaFila = new Acumulador();
		statComprimentosFila = new Acumulador();
		trace = t;
	}

	public void simular() throws EstadioException {
		// realizar a simulacao por um certo numero de passos de duracao
		for (int tempo = 0; tempo < duracao; tempo++) {
			// verificar se um cliente chegou
			if (geradorSocios.gerar()) {
				// se cliente chegou, criar um cliente e inserir na fila da catraca
				//Socio socio = new Socio(geradorSocios.getQuantidadeGerada(), tempo);
				Socio socio = new Socio("Anderson", 1010, Categoria.NADA_VAI_NOS_SEPARAR,Modalidade.ESTUDANTE,3);
				fila.add(socio);
				if (trace)
					System.out.println(tempo + ": socio " + socio.getMatricula() + " "
							+ "(" + socio.getTempoAtendimento()	+ " min) entra na fila - " + fila.size() + " pessoa(s)");
			}
			// verificar se o caixa esta vazio
			if (catraca.estaVazio()) {
				// se o caixa esta vazio, atender o primeiro cliente da fila se
				// ele existir
				if (!fila.isEmpty()) {
					// tirar o cliente do inicio da fila e atender no caixa
					catraca.atenderNovoSocio(fila.remove());
					statTemposEsperaFila.adicionar(tempo
							- catraca.getSocioAtual().getInstanteChegada());
					if (trace)
						System.out.println(tempo + ": socio "
								+ catraca.getSocioAtual().getMatricula()
								+ " chega a catraca.");
				}
			} else {
				// se o caixa ja esta ocupado, diminuir de um em um o tempo de
				// atendimento ate chegar a zero
				if (catraca.getSocioAtual().getTempoAtendimento() == 0) {
					if (trace)
						System.out.println(tempo + ": cliente "
								+ catraca.getSocioAtual().getMatricula()
								+ " deixa a catraca.");
					catraca.dispensarSocioAtual();
				} else {
					catraca.getSocioAtual().decrementarTempoAtendimento();
				}
			}
			statComprimentosFila.adicionar(fila.size());
		}
	}

	public void limpar() {
		fila = new QueueLinkedEx<Socio>();
		catraca = new Catraca<Object>();
		geradorSocios = new GeradorSocios(probabilidadeChegada);
		statTemposEsperaFila = new Acumulador();
		statComprimentosFila = new Acumulador();
	}

	public void imprimirResultados() {
		System.out.println();
		System.out.println("Resultados da Simulacao");
		System.out.println("Duracao:" + duracao);
		System.out.println("Probabilidade de chegada de socios:"+ probabilidadeChegada);
		System.out.println("Tempo de atendimento minimo:"+ Socio.tempoMinAtendimento);
		System.out.println("Tempo de atendimento maximo:"+ Socio.tempoMaxAtendimento);
		System.out.println("Socios atendidos:" + catraca.getNumeroAtendidos());
		System.out.println("Socios ainda na fila:" + fila.size());
		System.out.println("Socio ainda na catraca:" + (catraca.getSocioAtual() != null));
		System.out.println("Total de socios gerados:"+ geradorSocios.getQuantidadeGerada());
		System.out.println("Tempo medio de espera:" + statTemposEsperaFila.getMedia());
		System.out.println("Comprimento medio da fila:"	+ statComprimentosFila.getMedia());
	}

}
