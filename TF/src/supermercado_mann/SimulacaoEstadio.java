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

	Estadio<Socio> estadio = new Estadio<>();
	Catraca<E> catraca = new Catraca<>(1);

	QueueLinkedEx<Socio> listaSociosComuns = catraca.listaSociosComuns();

	private static final int totalCatracas = 10;
	private static final int duracao = 2000;
	private static final double probabilidadeChegada = 0.5;
	private QueueLinkedEx<Catraca<E>> catracas;
	private QueueTADEx<Socio> filas;
	private Catraca<Object> catraca1;
	private GeradorSocios geradorSocios;
	private Acumulador statTemposEsperaFila;
	private Acumulador statComprimentosFila;
	private boolean trace; // valor indica se a simulacao ira imprimir
							// passo-a-passo os resultados

	public SimulacaoEstadio(boolean t) {
		filas = new QueueLinkedEx<Socio>();
		catracas = new Catraca<>(1);
		for (int i = 0; i < totalCatracas; i++) {
			catracas.add((Catraca<E>) new Catraca<Object>(i + 1));
		}
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
				// se cliente chegou, criar um cliente e inserir na fila da
				// catraca
				// Socio socio = new Socio(geradorSocios.getQuantidadeGerada(),
				// tempo);
				Socio socio = new Socio("Anderson", 1010,
						Categoria.NADA_VAI_NOS_SEPARAR, Modalidade.ESTUDANTE, 3);
				Catraca<E> catracaMenorFila = (Catraca<E>) catraca1.get(1);
				for (Catraca<E> catraca : catracas) {
					if (catraca.totalSociosFila() < catracaMenorFila
							.totalSociosFila()) {
						catracaMenorFila = catraca;
					}
				}
				catracaMenorFila.entrarNoEstadioSociosComuns(listaSociosComuns);
				// filas.add(socio);
				if (trace)
					System.out
							.println(tempo + ": socio " + socio.getMatricula()
									+ " " + "(" + socio.getTempoAtendimento()
									+ " min) entra na catraca - "
									+ catracaMenorFila.getNumero() + " ("
									+ catracaMenorFila.totalSociosFila()
									+ " pessoa(s)");
				// filas.size() + " pessoa(s)");
			}
			for (Catraca<E> catraca : catracas) {

				// verificar se o caixa esta vazio
				if (catraca.estaVazio()) {
					// se o caixa esta vazio, atender o primeiro cliente da fila
					// se ele existir
					if (!filas.isEmpty()) {
						if (catraca.totalSociosFila() != 0)
							// tirar o cliente do inicio da fila e atender no
							// caixa
							catraca.atenderNovoSocio(filas.remove());
						statTemposEsperaFila.adicionar(tempo
								- catraca.getSocioAtual().getInstanteChegada());
						if (trace)
							System.out.println(tempo + ": socio "
									+ catraca.getSocioAtual().getMatricula()
									+ " chega a catraca.");
					}
				} else {
					// se o caixa ja esta ocupado, diminuir de um em um o tempo
					// de atendimento ate chegar a zero
					if (catraca.getSocioAtual().getTempoAtendimento() == 0) {
						if (trace)
							System.out.println(tempo + ": Socio "
									+ catraca.getSocioAtual().getMatricula()
									+ " deixa a catraca.");
						catraca.dispensarSocioAtual();
					} else {
						catraca.getSocioAtual().decrementarTempoAtendimento();
					}
				}
				statComprimentosFila.adicionar(filas.size());
			}
		}
	}

	public void limpar() {
		filas = new QueueLinkedEx<Socio>();
		catraca = new Catraca<E>(1);
		geradorSocios = new GeradorSocios(probabilidadeChegada);
		statTemposEsperaFila = new Acumulador();
		statComprimentosFila = new Acumulador();
	}

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
		System.out.println("Socios atendidos:" + catraca.getNumeroAtendidos());
		System.out.println("Socios ainda na fila:" + filas.size());
		System.out.println("Socio ainda na catraca:"
				+ (catraca.getSocioAtual() != null));
		System.out.println("Total de socios gerados:"
				+ geradorSocios.getQuantidadeGerada());
		System.out.println("Tempo medio de espera:"
				+ statTemposEsperaFila.getMedia());
		System.out.println("Comprimento medio da fila:"
				+ statComprimentosFila.getMedia());
	}

}
