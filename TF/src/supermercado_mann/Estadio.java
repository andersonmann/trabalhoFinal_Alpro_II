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
	protected QueueLinkedEx<Socio> sociosInadimplentes;

	public Estadio() {
		socios = new QueueLinkedEx<Socio>();
		sociosAdimplentes = new QueueLinkedEx<Socio>();
		sociosInadimplentes = new QueueLinkedEx<Socio>();
	}

	/**
	 * Method pagarMensalidade.
	 * 
	 * @return - Adiciona o socio na lista de socios Adimplentes
	 */
	public void pagarMensalidade(int matricula) {
		for (Socio socio : socios) {
			if (socio.getMatricula() == matricula) {
				// sociosInadimplentes.remove(socio);
				sociosAdimplentes.add(socio);
			}
		}
	}

	/**
	 * Method mensalidadeAtrasada.
	 * 
	 * @return - Adiciona o socio na lista de socios Inadimplentes
	 */
	public void mensalidadeAtrasada(int matricula) {
		for (Socio socio : socios) {
			if (socio.getMatricula() == matricula) {
				sociosInadimplentes.add(socio);
			}
		}
	}

	public void mensalidadeAtrasada(Socio s) {
		for (Socio socio : socios) {
			sociosInadimplentes.add(socio);
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
	 * Method listaDeSociosAdimplentes.
	 * 
	 * @return QueueLinkedEx - Lista de socios com mensalidade em dia.
	 */
	public QueueLinkedEx<Socio> listaDeSociosAdimplentes() {
		return sociosAdimplentes;
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
	 * Method quantidadeSocios
	 * 
	 * @return int - Quantidade de socios cadastrados.
	 */
	public int quantidadeSocios() {
		return listaDeSocios().size();
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
