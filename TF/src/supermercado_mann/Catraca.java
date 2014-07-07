package supermercado_mann;

/**
 * Catrara, classe que faz verificacoes sobre os socios.
 * 
 * @version 1.10 7 July 2014
 * @author Anderson_M_Mann
 * 
 */

public class Catraca<E> extends QueueLinkedEx<E> {
	private QueueLinkedEx<Socio> fila;
	protected QueueLinkedEx<Socio> filaGeral;
	protected QueueLinkedEx<Socio> filaSociosComuns;
	protected QueueLinkedEx<Socio> filaSociosEstudantes;
	protected QueueLinkedEx<Socio> filaSociosIdosos;
	protected QueueLinkedEx<Socio> filaSociosEspertos;
	protected QueueLinkedEx<Socio> publicoTotal;
	private long contador;
	Socio socio;
	private int numero;
	private Socio socioAtual;
	private int numeroAtendidos;

	public Catraca() {
		filaGeral = new QueueLinkedEx<>();
		filaSociosComuns = new QueueLinkedEx<>();
		filaSociosEstudantes = new QueueLinkedEx<>();
		filaSociosIdosos = new QueueLinkedEx<>();
		filaSociosEspertos = new QueueLinkedEx<>();
		publicoTotal = new QueueLinkedEx<>();
		contador = 0;		
	}
	
	public Catraca(int num) {
        numero = num;
        socioAtual = null;
        numeroAtendidos = 0;
        fila =  new QueueLinkedEx<Socio>();
    }    
    
    /**
	 * Method atenderNovoSocio.
	 * 
	 * @return -Remove um socio da fila
	 */		
    public void atenderNovoSocio() {
    	socioAtual = fila.remove();
    }
    
    /**
	 * Method dispensarSocioAtual.
	 * 
	 * @return Socio -
	 */
	public Socio dispensarSocioAtual() {
		Socio socio = socioAtual;
		socioAtual = null;
		numeroAtendidos++;
		return socio;
	}
	
	/**
	 * Method estaVazio.
	 * 
	 * @return Boolean
	 */
	public boolean estaVazio() {
		return (socioAtual == null);
	}
	
	/**
	 * Method getSocioAtual.
	 * 
	 * @return Socio - Retorna o socio que esta sendo atendido.
	 */
	public Socio getSocioAtual() {
		return socioAtual;
	}
	
	/**
	 * Method getNumeroAtendidos.
	 * 
	 * @return int- Quantidade de socios que foram atendidos.
	 */
	public int getNumeroAtendidos() {
		return numeroAtendidos;
	}
  
	/**
	 * Method getNumeroAtendidos.
	 * 
	 * @return QueueLinkedEx - Retorna os socios que ainda estao na fila.
	 */
	public int totalSociosFila() {
		if (socioAtual != null)
			return fila.size() + 1;
		return fila.size();
	}  
	
	public void adicionaSocioFila(Socio s) {
        fila.add(s);
    }	

	/**
	 * Method entrarNoEstadioSociosComuns
	 * 
	 * @return - Adiciona o socio na lista de socios que entraram no estadio.
	 */
	public void entrarNoEstadioSociosComuns(QueueLinkedEx<Socio> s) {
		for (Socio sociosComuns : filaSociosComuns) {
			publicoTotal.add(sociosComuns);
		}
	}

	/**
	 * Method entrarNoEstadioSociosEstudantes
	 * 
	 * @return - Adiciona o socio na lista de socios que entraram no estadio.
	 */
	public void entrarNoEstadioSociosEstudantes(QueueLinkedEx<E> s) {
		for (Socio sociosEstudantes : filaSociosEstudantes) {
			publicoTotal.add(sociosEstudantes);
		}
	}

	/**
	 * Method entrarNoEstadioSociosIdosos
	 * 
	 * @return - Adiciona o socio na lista de socios que entraram no estadio.
	 */
	public void entrarNoEstadioSociosIdosos(QueueLinkedEx<Socio> s) {
		for (Socio sociosIdosos : filaSociosIdosos) {
			publicoTotal.add(sociosIdosos);
		}
	}

	/**
	 * Method entrarNaFilaGeral
	 * 
	 * @return - Adiciona o socio na fila geral.
	 */
	public void entrarNaFilaGeral(Socio socio) {
		filaGeral.add(socio);
	}

	/**
	 * Method entrarNaFilaCorreta
	 * 
	 * @return - Verifica a modalidade do socio e manda para a fila correta,
	 *         tambem verifica se o socio esta tentando entrar mais de uma vez.
	 */
	public void entrarNaFilaCorreta(QueueLinkedEx<Socio> s) {
		for (Socio socio : filaGeral) {
			if (verificaModalidade(socio) == Modalidade.COMUM) {
				if (verificaEntrada(socio) == false) {
					filaSociosComuns.add(socio);
				} else {
					filaSociosEspertos.add(socio);
				}
			}
			if (verificaModalidade(socio) == Modalidade.ESTUDANTE) {
				if (verificaEntrada(socio) == false) {
					filaSociosEstudantes.add(socio);
				} else {
					filaSociosEspertos.add(socio);
				}
			}
			if (verificaModalidade(socio) == Modalidade.IDOSO) {
				if (verificaEntrada(socio) == false) {
					filaSociosIdosos.add(socio);
				} else {
					filaSociosEspertos.add(socio);
				}
			}

		}
	}

	/**
	 * Method verificaEntrada
	 * 
	 * @return Boolean - Verifica se um socio já passou pela 1ª catraca.
	 */
	public boolean verificaEntrada(Socio socio1) {
		if (verificaModalidade(socio1) == Modalidade.COMUM) {
			for (Socio socioComum : filaSociosComuns) {
				if (socioComum == socio1)
					return true;
			}
			return false;
		}
		if (verificaModalidade(socio1) == Modalidade.ESTUDANTE) {
			for (Socio socioEstudante : filaSociosEstudantes) {
				if (socioEstudante == socio1) {
					return true;
				}
			}
			return false;
		}
		for (Socio socioIdoso : filaSociosIdosos) {
			if (socioIdoso == socio1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method verificaDuplaEntrada
	 * 
	 * @return Boolean - Verifica se um socio tentou entrar mais de uma vez.
	 */
	public boolean verificaDuplaEntrada(Socio matricula) {
		for (Socio socio : filaSociosEspertos) {
			if (socio == matricula) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method verificaModalidade
	 * 
	 * @return Modalidade - Verifica e retorna a modalidade de um socio.
	 */
	public Modalidade verificaModalidade(Socio socio) {
		if (socio.getModalidade() == Modalidade.COMUM) {
			return Modalidade.COMUM;
		}
		if (socio.getModalidade() == Modalidade.ESTUDANTE) {
			return Modalidade.ESTUDANTE;
		}
		return Modalidade.IDOSO;
	}

	/**
	 * Method getContador
	 * 
	 * @return int - Quantidade de operações realizadas
	 */
	public long getContador() {
		return contador;
	}

	/**
	 * Method listaSociosComuns.
	 * 
	 * @return QueueLinkedEx - Lista de socios da modalidade Comum.
	 */
	public QueueLinkedEx<Socio> listaSociosComuns() {
		return filaSociosComuns;
	}

	/**
	 * Method quantidadeSociosComuns.
	 * 
	 * @return int - Quantidade de socios da modalidade Comum.
	 */
	public int quantidadeSociosComuns() {
		return listaSociosComuns().size();
	}

	/**
	 * Method listaSociosEstudantes.
	 * 
	 * @return QueueLinkedEx - Lista de socios da modalidade Estudante.
	 */
	public QueueLinkedEx<Socio> listaSociosEstudantes() {
		return filaSociosEstudantes;
	}

	/**
	 * Method quantidadeSociosEstudantes.
	 * 
	 * @return int - Quantidade de socios da modalidade Estudante.
	 */
	public int quantidadeSociosEstudantes() {
		return listaSociosEstudantes().size();
	}

	/**
	 * Method listaSociosIdosos.
	 * 
	 * @return QueueLinkedEx - Lista de socios da modalidade Idoso.
	 */
	public QueueLinkedEx<Socio> listaSociosIdosos() {
		return filaSociosIdosos;
	}

	/**
	 * Method quantidadeSociosIdosos.
	 * 
	 * @return int - Quantidade de socios da modalidade Idoso.
	 */
	public int quantidadeSociosIdosos() {
		return listaSociosIdosos().size();
	}

	/**
	 * Method publicoTotal.
	 * 
	 * @return QueueLinkedEx - Lista de socios que tentaram entrar mais de uma
	 *         vez no estadio.
	 */
	public QueueLinkedEx<Socio> listaEspertos() {
		return filaSociosEspertos;
	}

	/**
	 * Method quantidadeSociosEspertos.
	 * 
	 * @return int - Quantidade de socios que tentaram entrar mais de uma vez no
	 *         estadio.
	 */
	public int quantidadeSociosEspertos() {
		return listaEspertos().size();
	}

	/**
	 * Method publicoTotal.
	 * 
	 * @return QueueLinkedEx - Lista de socios que entraram no estadio.
	 */
	public QueueLinkedEx<Socio> publicoTotal() {
		return publicoTotal;
	}

	/**
	 * Method quantidadeTotalDeSociosQueEntraram.
	 * 
	 * @return int - Quantidade de socios que entraram no estadio.
	 */
	public int quantidadeTotalDeSociosQueEntraram() {
		return publicoTotal().size();
	}

	/**
	 * Method quantidadeTotalDeSociosQueTentaramEntrar.
	 * 
	 * @return int Quantidade de socios que passaram pela checagem da modalidade
	 */
	public int quantidadeTotalDeSociosQueTentaramEntrar() {
		return listaSociosComuns().size() + listaSociosEstudantes().size()
				+ listaSociosIdosos().size();
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

	/**
	 * Method mediaSocios.
	 * 
	 * @return double - Media de socios das modalidades
	 */
	public double mediaSocios() {
		double comuns = quantidadeSociosComuns();
		double estudantes = quantidadeSociosEstudantes();
		double idosos = quantidadeSociosIdosos();
		double total = comuns + estudantes + idosos;
		double media = total / 3;
		return media;
	}

	/**
	 * Method mediaSociosQueEntraramModalidadeComuns.
	 * 
	 * @return double - Media de socios que entraram da modalidade Comum
	 */
	public double mediaSociosQueEntraramModalidadeComuns() {
		double comuns = quantidadeSociosComuns();
		double total = quantidadeTotalDeSociosQueEntraram();
		double mediaComuns = comuns / total;
		return mediaComuns;
	}

	/**
	 * Method mediaSociosQueEntraramModalidadeEstudantes.
	 * 
	 * @return double - Media de socios que entraram da modalidade Estudante
	 */
	public double mediaSociosQueEntraramModalidadeEstudantes() {
		double estudantes = quantidadeSociosEstudantes();
		double total = quantidadeTotalDeSociosQueEntraram();
		double mediaEstudantes = estudantes / total;
		return mediaEstudantes;
	}

	/**
	 * Method mediaSociosQueEntraramModalidadeIdosos.
	 * 
	 * @return double - Media de socios que entraram da modalidade Idoso
	 */
	public double mediaSociosQueEntraramModalidadeIdosos() {
		double idosos = quantidadeSociosIdosos();
		double total = quantidadeTotalDeSociosQueEntraram();
		double mediaIdosos = idosos / total;
		return mediaIdosos;
	}

}