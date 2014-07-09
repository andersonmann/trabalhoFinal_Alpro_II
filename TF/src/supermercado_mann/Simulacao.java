/**
 * 
 */
package supermercado_mann;

/**
 * @author Anderson_M_Mann
 * @param <E>
 * 
 */
public class Simulacao<E> {
	
	private static final int totalCaixas = 5;
	private static final int duracao = 3600;
	private static final double probabilidadeChegada = 0.5;	
	private QueueLinkedEx<Caixa<Cliente>> caixas;
	private GeradorClientes geradorClientes;
	private Acumulador statTemposEsperaFila;
	private Acumulador statComprimentosFila;
	private boolean trace;
	
	/**
	 * Method Simulacao.
	 * 
	 * @return - Realiza a simulação de clientes
	 */
	public Simulacao(boolean t) {
		caixas = new QueueLinkedEx<>();
		for (int i = 0; i < totalCaixas; i++) {			
			caixas.add(new Caixa<Cliente>(i+1));
        }
		geradorClientes = new GeradorClientes(probabilidadeChegada);
		statTemposEsperaFila = new Acumulador();
		statComprimentosFila = new Acumulador();
		trace = t;		
	}
	
	/**
	 * Method simular.
	 * 
	 * @return - Realiza a simulação de clientes
	 */
	public void simular() throws EstadioException {		
		for (int tempo = 0; tempo < duracao; tempo++) {
			// verificar se um cliente chegou
			if (geradorClientes.gerar()) {
				//se cliente chegou, criar um cliente e inserir na fila do caixa
				Cliente c = new Cliente(geradorClientes.getQuantidadeGerada(), tempo);
                Caixa<Cliente> caixaMenorFila = caixas.get(0);
                for (Caixa<Cliente> caixa : caixas) {
                    if (caixa.totalClientesFila() < caixaMenorFila.totalClientesFila()) {
                    	caixaMenorFila = caixa;
                    }
                }
                caixaMenorFila.adicionaClienteFila(c);
                if (trace) {
                    System.out.println(tempo + ": Cliente " + c.getNumero() + " (" + c.getTempoAtendimento()
                    		+ " min) entra na fila do caixa "+ caixaMenorFila.getNumero() + " ("
                    		+ caixaMenorFila.totalClientesFila()+" pessoas)");
                }
            }
            for (Caixa<Cliente> caixa : caixas) {
                //verificar se o caixa esta vazio
                if (caixa.estaVazio()) {
                    //se o caixa esta vazio, atender o primeiro cliente da fila se ele existir
                    if (caixa.totalClientesFila() != 0) {
                        //tirar o cliente do inicio da fila e atender no caixa
                    	caixa.atenderNovoCliente();
                        statTemposEsperaFila.adicionar(tempo - caixa.getClienteAtual().getInstanteChegada());
                        if (trace) {
                            System.out.println(tempo + ": Cliente " + caixa.getClienteAtual().getNumero() + " chega no caixa "
                                    + caixa.getNumero());
                        }
                    }
                } else {
                    //se o caixa ja esta ocupado, diminuir de um em um o tempo de atendimento ate chegar a zero
                    if (caixa.getClienteAtual().getTempoAtendimento() == 0) {
                        if (trace) {
                            System.out.println(tempo + ": Cliente " + caixa.getClienteAtual().getNumero() + " deixa o caixa "
                                    + caixa.getNumero());
                        }
                        caixa.dispensarClienteAtual();
                    } else {
                    	caixa.getClienteAtual().decrementarTempoAtendimento();
                    }
                }
                statComprimentosFila.adicionar(caixa.totalClientesFila());
            }
        }
    }	
	
	/**
	 * Method limpar.
	 * 
	 * @return - Reinicia os contadores
	 */
	public void limpar() {		
		//caixas = new Caixa<>();
		//catracas = new Catraca<>();
		geradorClientes = new GeradorClientes(probabilidadeChegada);
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
		System.out.println("Probabilidade de chegada de clientes:" + probabilidadeChegada);
		System.out.println("Tempo de atendimento minimo:" + Cliente.tempoMinAtendimento);
		System.out.println("Tempo de atendimento maximo:" + Cliente.tempoMaxAtendimento);		
		for(Caixa<Cliente> caixa: caixas)
        {
        	System.out.println("------------------------------------------");
        	System.out.println("Caixa "+ caixa.getNumero());
            System.out.println("Clientes atendidos no caixa :" + caixa.getNumeroAtendidos());
            System.out.println("Clientes ainda na fila:" + caixa.totalClientesFila());
            System.out.println("Cliente ainda no caixa:" + (caixa.getClienteAtual() != null));
        }		
		System.out.println("------------------------------------------");
        System.out.println("Total de clientes gerados:" + geradorClientes.getQuantidadeGerada());
        System.out.println("Tempo medio de espera:" + statTemposEsperaFila.getMedia());
        System.out.println("Comprimento medio da fila:" + statComprimentosFila.getMedia());
	}

}
