/**
 * 
 */
package supermercado_mann;

/**
 * Estadio, classe que mantem armazenada os socios cadastrados.
 * 
 * @version 1.10 7 July 2014
 * @author Anderson_M_Mann
 */
public class Estadio<E> extends QueueLinkedEx<E> {
	protected static QueueLinkedEx<Socio> socios;
	protected static QueueLinkedEx<Socio> sociosAdimplentes;
	protected static QueueLinkedEx<Socio> sociosInadimplentes;
	ReaderSocios<E> readerSocios;
	QueueLinkedEx<SocioV2> sociosViaArquivo = ReaderSocios.listaSocios;

	/**
	 * Construtor
	 * 
	 * Metodo construtor que inicializa as filas
	 */
	public Estadio() {
		socios = new QueueLinkedEx<Socio>();
		sociosAdimplentes = new QueueLinkedEx<Socio>();
		sociosInadimplentes = new QueueLinkedEx<Socio>();
	}

	/**
	 * Method pagarMensalidade.
	 * 
	 * @return - Adiciona o socio na lista de socios Adimplentes, e remove da
	 *         lista de Indadimplentes.
	 */
	public void pagarMensalidade(Socio socio1) {
		for (Socio socio : socios) {
			if (socio == socio1) {
				sociosAdimplentes.add(socio);
			}
			sociosInadimplentes.remove(socio);
		}
	}

	/**
	 * Method mensalidadeAtrasada.
	 * 
	 * @return - Adiciona o socio na lista de socios Inadimplentes
	 */
	public void mensalidadeAtrasada(Socio socio1) {
		for (Socio socio : socios) {
			if (socio == socio1) {
				sociosInadimplentes.add(socio);
			}
		}
	}

	/**
	 * Method listaDeSocios.
	 * 
	 * @return QueueLinkedEx - Lista de socios cadastrados
	 */
	public QueueLinkedEx<Socio> listaDeSocios() {
		return socios;
	}

	/**
	 * Method quantidadeSocios
	 * 
	 * @return int - Quantidade de socios cadastrados.
	 */
	public int quantidadeSocios() {
		return listaDeSocios().size();
	}

	/**
	 * Method listaDeSocios.
	 * 
	 * @return QueueLinkedEx - Lista de socios cadastrados via Arquivo.
	 */
	public QueueLinkedEx<SocioV2> listaDeSociosViaArquivo() {
		return sociosViaArquivo;
	}

	/**
	 * Method quantidadeSociosV2
	 * 
	 * @return int - Quantidade de socios cadastrados via Arquivo.
	 */
	public int quantidadeSociosViaArquivo() {
		return listaDeSociosViaArquivo().size();
	}

	/**
	 * Method listaDeSociosAdimplentes.
	 * 
	 * @return QueueLinkedEx - Lista de socios com mensalidade em dia.
	 */
	public QueueLinkedEx<Socio> listaDeSociosAdimplentes() {
		return sociosAdimplentes;
	}

	/**
	 * Method quantidadeSociosInadimplentes
	 * 
	 * @return int - Quantidade de socios que estão com a mensalidade atrasada.
	 */
	public int quantidadeSociosAdimplentes() {
		return listaDeSociosAdimplentes().size();
	}

	/**
	 * Method listaSociosInadimplentes.
	 * 
	 * @return QueueLinkedEx - Lista de socios que estão com a mensalidade
	 *         atrasada.
	 */
	public QueueLinkedEx<Socio> listaSociosInadimplentes() {
		return sociosInadimplentes;
	}

	/**
	 * Method quantidadeSociosInadimplentes
	 * 
	 * @return int - Quantidade de socios que estão com a mensalidade atrasada.
	 */
	public int quantidadeSociosInadimplentes() {
		return listaSociosInadimplentes().size();
	}

	/**
	 * Method getSocio.
	 * 
	 * @return Socio - Retorna o socio pesquisado.
	 */
	public Socio getSocio(Socio matricula) {
		for (Socio socio : socios) {
			if (socio == matricula) {
				return socio;
			}
		}
		return null;
	}

	/**
	 * Method getSocio.
	 * 
	 * @return Socio - Retorna o socio pesquisado.
	 */
	public Socio getSocio(int matricula) {
		for (Socio socio : socios) {
			if (socio.getMatricula() == matricula) {
				return socio;
			}
		}
		return null;
	}

}
