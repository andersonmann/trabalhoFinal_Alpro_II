/**
 * 
 */
package supermercado_mann;

/**
 * @author Anderson_M_Mann
 * 
 */
public class Estadio<E> extends QueueLinkedEx<E> {
	public QueueLinkedEx<Socio> socios;

	/*
	 * Construtor
	 */
	public Estadio() {
		socios = new QueueLinkedEx<Socio>();
	}

	/**
	 * Metodo getSocios.
	 * 
	 * @return QueueLinkedEx de socios cadastrados
	 */

	public  QueueLinkedEx<Socio> listaDeSocios() {
		return socios;
	}

	public Socio getSocio(Socio matricula) {
		for (Socio socio : socios) {
			if (socio == matricula) {
				return socio;
			}
		}
		return null;
	}

	public Socio getSocio(int matricula) {
		for (Socio socio : socios) {
			if (socio.getMatricula() == matricula) {
				return socio;
			}
		}
		return null;
	}

}
