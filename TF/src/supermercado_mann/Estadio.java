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
	protected QueueLinkedEx<Socio> socios;
	protected QueueLinkedEx<Socio> sociosadimplentes;
	protected QueueLinkedEx<Socio> sociosInadimplentes;
	

	public Estadio() {
		socios = new QueueLinkedEx<Socio>();
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
	
	/*public void pagarMensalidade(Socio socio1){
		for
	}*/


}
