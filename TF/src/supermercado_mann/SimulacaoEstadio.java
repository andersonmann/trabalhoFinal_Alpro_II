/**
 * 
 */
package supermercado_mann;

/**
 * @author Anderson_M_Mann
 * @param <E>
 * 
 */
public class SimulacaoEstadio<E> {
	private static final int totalCatracas = 5;
	private static final int duracao = 3600;
	private static final double probabilidadeChegada = 0.5;
	private QueueLinkedEx<Catraca<Socio>> catracas;
	private GeradorSocios geradorSocios;
	private Acumulador statTemposEsperaFila;
	private Acumulador statComprimentosFila;
	private boolean trace;

	/**
	 * Method SimulacaoEstadio.
	 * 
	 * @return - Realiza a simulação de socios
	 */
	public SimulacaoEstadio(boolean t) {
		catracas = new QueueLinkedEx<>();
		for (int i = 0; i < totalCatracas; i++) {
			catracas.add(new Catraca<Socio>(i + 1));
		}
		geradorSocios = new GeradorSocios(probabilidadeChegada);
		statTemposEsperaFila = new Acumulador();
		statComprimentosFila = new Acumulador();
		trace = t;
	}

	/**
	 * Method simular.
	 * 
	 * @return - Realiza a simulação de socios
	 */
	public void simular() throws EstadioException {		
		for (int tempo = 0; tempo < duracao; tempo++) {
			// verificar se um socio chegou
			if (geradorSocios.gerar()) {
				// se socio chegou, criar um socio e inserir na fila
				Socio socio = new Socio(geradorSocios.getQuantidadeGerada(),
						tempo);
				Catraca<Socio> catracaMenorFila = catracas.get(0);
				for (Catraca<Socio> catraca : catracas) {
					if (catraca.totalSociosFila() < catracaMenorFila
							.totalSociosFila()) {
						catracaMenorFila = catraca;
					}
				}
				catracaMenorFila.adicionaSocioFila(socio);
				if (trace) {
					System.out.println(tempo + ": Socio " + socio.getNumero()
							+ " (" + socio.getTempoAtendimento()
							+ " min) entra na fila da catraca "
							+ catracaMenorFila.getNumero() + " ("
							+ catracaMenorFila.totalSociosFila() + " pessoas)");
				}
			}
			for (Catraca<Socio> catraca : catracas) {
				// verificar se a catraca esta vazia
				if (catraca.estaVazio()) {
					// se a catraca esta vazia, atender o primeiro socio da fila
					// se ele existir
					if (catraca.totalSociosFila() != 0) {
						// tirar o socio do inicio da fila e atender na catraca
						catraca.atenderNovoSocio();
						statTemposEsperaFila.adicionar(tempo
								- catraca.getSocioAtual().getInstanteChegada());
						if (trace) {
							System.out.println(tempo + ": Socio "
									+ catraca.getSocioAtual().getNumero()
									+ " chega na catraca "
									+ catraca.getNumero());
						}
					}
				} else {
					// se a catraca ja esta ocupada, diminuir de um em um o
					// tempo de atendimento ate chegar a zero
					if (catraca.getSocioAtual().getTempoAtendimento() == 0) {
						if (trace) {
							System.out.println(tempo + ": Socio "
									+ catraca.getSocioAtual().getNumero()
									+ " passa na catraca "
									+ catraca.getNumero());
						}
						catraca.dispensarSocioAtual();
					} else {
						catraca.getSocioAtual().decrementarTempoAtendimento();
					}
				}
				statComprimentosFila.adicionar(catraca.totalSociosFila());
			}
		}
	}

	/**
	 * Method limpar.
	 * 
	 * @return - Reinicia os contadores
	 */
	public void limpar() {		
		catracas = new Catraca<>();
		geradorSocios = new GeradorSocios(probabilidadeChegada);
		statTemposEsperaFila = new Acumulador();
		statComprimentosFila = new Acumulador();
	}

	/**
	 * Method imprimirResultados.
	 * 
	 * @return - Imprime os resultados
	 */
	public void imprimirResultados() {
		System.out.println();
		System.out.println("Resultados da Simulacao");
		System.out.println("Duracao:" + duracao);
		System.out.println("Probabilidade de chegada de socios:"
				+ probabilidadeChegada);
		System.out.println("Tempo de atendimento minimo:"
				+ Socio.tempoMinAtendimento);
		System.out.println("Tempo de atendimento maximo:"
				+ Socio.tempoMaxAtendimento);
		for (Catraca<Socio> catraca : catracas) {
			System.out.println("------------------------------------------");
			System.out.println("Catraca " + catraca.getNumero());
			System.out.println("Socios atendidos na catraca :"
					+ catraca.getNumeroAtendidos());
			System.out.println("Socios ainda na fila:"
					+ catraca.totalSociosFila());
			System.out.println("Socio ainda na catraca:"
					+ (catraca.getSocioAtual() != null));
		}
		System.out.println("------------------------------------------");
		System.out.println("Total de socios gerados:"
				+ geradorSocios.getQuantidadeGerada());
		System.out.println("Tempo medio de espera:"
				+ statTemposEsperaFila.getMedia());
		System.out.println("Comprimento medio da fila:"
				+ statComprimentosFila.getMedia());
	}

}
