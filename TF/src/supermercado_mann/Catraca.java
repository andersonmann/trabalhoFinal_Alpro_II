package supermercado_mann;

/**
 * Catrara, classe que faz verificacoes sobre os socios.
 * 
 * @version 1.10 7 July 2014
 * @author Anderson_M_Mann
 * 
 */

public class Catraca<E> extends QueueLinkedEx<E> {
	protected QueueLinkedEx<Socio> fila;
	protected QueueLinkedEx<Socio> filaGeral;
	protected QueueLinkedEx<SocioV2> filaGeralV2;
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
	Estadio<E> estadio;
	ReaderSocios<E> readerSocios;
	QueueLinkedEx<SocioV2> sociosViaArquivo = ReaderSocios.listaSocios;
	QueueLinkedEx<Socio> sociosCadastrados = Estadio.socios;
	QueueLinkedEx<Socio> sociosMensalidaEmDia = Estadio.sociosAdimplentes;
	QueueLinkedEx<Socio> sociosMensalidadeAtrasada = Estadio.sociosInadimplentes;

	/**
	 * Construtor
	 * 
	 * Metodo construtor que inicializa as filas
	 */
	public Catraca() {
		filaGeral = new QueueLinkedEx<>();
		filaSociosComuns = new QueueLinkedEx<>();
		filaSociosEstudantes = new QueueLinkedEx<>();
		filaSociosIdosos = new QueueLinkedEx<>();
		filaSociosEspertos = new QueueLinkedEx<>();
		publicoTotal = new QueueLinkedEx<>();
		contador = 0;
	}

	/**
	 * Construtor
	 * 
	 * Metodo construtor usado na simulacao
	 */
	public Catraca(int num) {
		numero = num;
		socioAtual = null;
		numeroAtendidos = 0;
		fila = new QueueLinkedEx<Socio>();
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
	 * Method totalSociosFila.
	 * 
	 * @return int - Retorna a quantida socios que ainda estao na fila.
	 */
	public int totalSociosFila() {
		if (socioAtual != null)
			return fila.size() + 1;
		return fila.size();
	}

	/**
	 * Method adicionaSocioFila.
	 * 
	 * @return - Adiciona o socio na fila.
	 */
	public void adicionaSocioFila(Socio s) {
		fila.add(s);
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
	 * Method entrarNaFilaGeral
	 * 
	 * @return - Adiciona o socio na fila geral.
	 */
	public void entrarNaFilaGeral(Socio socio) {
		filaGeral.add(socio);
	}

	/**
	 * Method entrarNaFilaGeralV2
	 * 
	 * @return - Adiciona o socio na fila geral.
	 */
	public void entrarNaFilaGeralV2(int matricula) {
		for (SocioV2 socio : sociosViaArquivo) {
			if (socio.getMatricula() == matricula) {
				filaGeralV2.add(socio);
			}
		}
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
	 * Method entrarNaFilaCorretaV2
	 * 
	 * @return - Verifica a modalidade do socio e manda para a fila correta,
	 *         tambem verifica se o socio esta tentando entrar mais de uma vez.
	 */
	public void entrarNaFilaCorretaV2(QueueLinkedEx<Socio> s) {
		for (Socio socio : filaGeral) {
			if (verificaModalidadeV2(socio).equals("COMUM")) {
				if (verificaEntradaV2(socio) == false) {
					filaSociosComuns.add(socio);
				} else {
					filaSociosEspertos.add(socio);
				}
			}
			if (verificaModalidade(socio).equals("ESTUDANTE")) {
				if (verificaEntrada(socio) == false) {
					filaSociosEstudantes.add(socio);
				} else {
					filaSociosEspertos.add(socio);
				}
			}
			if (verificaModalidade(socio).equals("IDOSO")) {
				if (verificaEntrada(socio) == false) {
					filaSociosIdosos.add(socio);
				} else {
					filaSociosEspertos.add(socio);
				}
			}

		}
	}

	public boolean verificaMensalidade(Socio socio1) {
		for (Socio socio : sociosMensalidadeAtrasada) {
			if (socio == socio1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method entrarNoEstadioSociosComuns
	 * 
	 * @return - Adiciona o socio na lista de socios que entraram no estadio,
	 *         caso ele n�o esteja com a mensalidade atrasada.
	 * @throws EstadioException
	 */
	public void entrarNoEstadioSociosComuns(QueueLinkedEx<Socio> s)
			throws EstadioException {
		for (Socio sociosComuns : filaSociosComuns) {
			if (verificaMensalidade(sociosComuns) == false) {
				publicoTotal.add(sociosComuns);
			} else {
				throw new EstadioException("Socio com mensalidade atrasada");
			}
		}
	}

	/**
	 * Method entrarNoEstadioSociosEstudantes
	 * 
	 * @return - Adiciona o socio na lista de socios que entraram no estadio,
	 *         caso ele n�o esteja com a mensalidade atrasada.
	 */
	public void entrarNoEstadioSociosEstudantes(QueueLinkedEx<E> s)
			throws EstadioException {
		for (Socio sociosEstudantes : filaSociosEstudantes) {
			if (verificaMensalidade(sociosEstudantes) == false) {
				publicoTotal.add(sociosEstudantes);
			} else {
				throw new EstadioException("Socio com mensalidade atrasada");
			}
		}
	}

	/**
	 * Method entrarNoEstadioSociosIdosos
	 * 
	 * @return - Adiciona o socio na lista de socios que entraram no estadio,
	 *         caso ele n�o esteja com a mensalidade atrasada.
	 */
	public void entrarNoEstadioSociosIdosos(QueueLinkedEx<Socio> s)
			throws EstadioException {
		for (Socio sociosIdosos : filaSociosIdosos) {
			if (verificaMensalidade(sociosIdosos) == false) {
				publicoTotal.add(sociosIdosos);
			} else {
				throw new EstadioException("Socio com mensalidade atrasada");
			}
		}
	}

	/**
	 * Method verificaEntrada
	 * 
	 * @return Boolean - Verifica se um socio j� passou pela 1� catraca.
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
	 * Method verificaEntradaV2
	 * 
	 * @return Boolean - Verifica se um socio j� passou pela 1� catraca.
	 */
	public boolean verificaEntradaV2(Socio socio1) {
		if (verificaModalidade(socio1).equals("COMUM")) {
			for (Socio socioComum : filaSociosComuns) {
				if (socioComum == socio1)
					return true;
			}
			return false;
		}
		if (verificaModalidade(socio1).equals("ESTUDANTE")) {
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
	 * Method verificaModalidadev2
	 * 
	 * @return String - Verifica e retorna a modalidade de um socio.
	 */
	public String verificaModalidadeV2(Socio socio) {
		if (socio.getModalidade().equals("COMUM")) {
			return "COMUM";
		}
		if (socio.getModalidade().equals("ESTUDANTE")) {
			return "ESTUDANTE";
		}
		return "IDOSO";
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
	 * Method sociosViaArquivo.
	 * 
	 * @return QueueLinkedEx - Lista de socios que foram cadastrados via
	 *         arquivo.
	 */
	public QueueLinkedEx<SocioV2> sociosViaArquivo() {
		return sociosViaArquivo;
	}

	/**
	 * Method quantidadeSociosViaArquivo.
	 * 
	 * @return int - Quantidade de socios que foram cadastrados via arquivo.
	 */

	public int quantidadeSociosViaArquivo() {
		return sociosViaArquivo().size();
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
	public int qtdTotalSociosVerificadaModalidade() {
		return listaSociosComuns().size() + listaSociosEstudantes().size()
				+ listaSociosIdosos().size();
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

	/**
	 * Method getContador
	 * 
	 * @return int - Quantidade de opera��es realizadas
	 */
	public long getContador() {
		return contador;
	}

}