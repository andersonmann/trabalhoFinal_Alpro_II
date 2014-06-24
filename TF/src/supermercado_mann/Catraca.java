package supermercado_mann;

public class Catraca<E> extends QueueLinkedEx<E> {

	// protected QueueLinkedEx<Integer> sociosEntraram;
	// protected QueueLinkedEx<Integer> sociosEspertos;
	protected QueueLinkedEx<Socio> sociosComuns;
	protected QueueLinkedEx<Socio> SocioEstudante;
	protected QueueLinkedEx<Socio> socioIdoso;
	protected QueueLinkedEx<Socio> sociosEspertos2;
	public Socio socio;
	private long contador;

	public Catraca() {
		// sociosEntraram = new QueueLinkedEx<Integer>();
		// sociosEspertos = new QueueLinkedEx<Integer>();
		sociosComuns = new QueueLinkedEx<Socio>();
		SocioEstudante = new QueueLinkedEx<Socio>();
		socioIdoso = new QueueLinkedEx<Socio>();
		sociosEspertos2 = new QueueLinkedEx<Socio>();
		contador = 0;
	}

	public void entrar(Socio matricula) {
		if (verificaModalidade(matricula) == Modalidade.COMUM) {
			if (verificaEntradaV2(matricula) == true) {
				sociosEspertos2.add(matricula);
			}
			sociosComuns.add(matricula);
		}
		if (verificaModalidade(matricula) == Modalidade.ESTUDANTE) {
			if (verificaEntradaV2(matricula) == true) {
				sociosEspertos2.add(matricula);
			}
			SocioEstudante.add(matricula);
		}
		if (verificaEntradaV2(matricula) == true) {
			sociosEspertos2.add(matricula);
		}
		socioIdoso.add(matricula);
	}

	public boolean verificaEntradaV2(Socio socio1) {
		if (verificaModalidade(socio1) == Modalidade.COMUM) {
			if(sociosComuns.contains(socio1)){			
					return true;
				}
			}
		return false;
		}
		/*if (verificaModalidade(matricula) == Modalidade.ESTUDANTE) {
			for (Socio socioEstudante : SocioEstudante) {
				if (socioEstudante == matricula) {
					return true;
				}
			}
		}
		for (Socio socio : socioIdoso) {
			if (socio == matricula) {
				return true;
			}
		}
		return false;
	}*/

	public Modalidade verificaModalidade(Socio socio) {
		if (socio.getModalidade() == Modalidade.COMUM) {
			return Modalidade.COMUM;
		}
		if (socio.getModalidade() == Modalidade.ESTUDANTE) {
			return Modalidade.ESTUDANTE;
		}
		return Modalidade.IDOSO;
	}

	/*
	 * Métodos que utilizam parametro int
	 */

	/*
	 * public void entra(int matricula) { if (verificaEntrada(matricula) ==
	 * true) { contador++; sociosEspertos.add(matricula); }
	 * sociosEntraram.add(matricula); }
	 * 
	 * public boolean verificaEntrada(int matricula) { for (Integer socio :
	 * sociosEntraram) { contador++; if (socio == matricula) { return true; } }
	 * return false; }
	 * 
	 * public boolean verificaDuplaEntrada(int matricula) { for (Integer socio :
	 * sociosEspertos) { contador++; if (socio == matricula) { return true; } }
	 * return false; }
	 */
	public long getContador() {
		return contador;
	}

	public QueueLinked<Socio> listaEspertos2() {
		return sociosEspertos2;
	}

	public QueueLinkedEx<Socio> listaSociosComuns() {
		return sociosComuns;
	}

	/*
	 * public QueueLinked<Integer> listaEspertos() { return sociosEspertos; }
	 */

	/*
	 * public boolean entra(int matricula) { contador++; if
	 * (verificaDuplaEntradaV2(matricula) == true) {
	 * sociosEspertos.add(matricula); return false; }
	 * sociosEntraram.add(matricula); return true; }
	 */

	/*
	 * public boolean entra(int matricula) { contador++; if
	 * (sociosEntraram.get(matricula - 1) == true) {
	 * sociosEspertos.add(matricula); return false; }
	 * sociosEntraram.set(matricula - 1, true); return true; }
	 */

	/*
	 * public boolean verificaDuplaEntrada(int numeroSocio) { contador++; if
	 * (sociosEntraram.get(numeroSocio - 1) == true) { return true; } return
	 * false; }
	 */

}