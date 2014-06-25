package supermercado_mann;

public class Catraca<E> extends QueueLinkedEx<E> {

	// protected QueueLinkedEx<Integer> sociosEntraram;
	// protected QueueLinkedEx<Integer> sociosEspertos;
	protected QueueLinkedEx<Socio> filaSociosComuns;
	protected QueueLinkedEx<Socio> filaSociosEstudantes;
	protected QueueLinkedEx<Socio> filaSociosIdosos;
	protected QueueLinkedEx<Socio> filaSociosEspertos;
	Socio socio;
	private long contador;

	public Catraca() {
		// sociosEntraram = new QueueLinkedEx<Integer>();
		// sociosEspertos = new QueueLinkedEx<Integer>();
		filaSociosComuns = new QueueLinkedEx<Socio>();
		filaSociosEstudantes = new QueueLinkedEx<Socio>();
		filaSociosIdosos = new QueueLinkedEx<Socio>();
		filaSociosEspertos = new QueueLinkedEx<Socio>();
		contador = 0;
	}

	public void entrar(Socio matricula) {
		if (verificaModalidade(matricula) == Modalidade.COMUM) {
			if (verificaEntrada(matricula) == false) {
				filaSociosComuns.add(matricula);
			} else {
				filaSociosEspertos.add(matricula);
			}
		}
		if (verificaModalidade(matricula) == Modalidade.ESTUDANTE) {
			if (verificaEntrada(matricula) == false) {
				filaSociosEstudantes.add(matricula);
			} else {
				filaSociosEspertos.add(matricula);
			}
		}
		if (verificaModalidade(matricula) == Modalidade.IDOSO) {
			if (verificaEntrada(matricula) == false) {
				filaSociosIdosos.add(matricula);
			} else {
				filaSociosEspertos.add(matricula);
			}
		}
	}

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
		}
		for (Socio socio : filaSociosIdosos) {
			if (socio == socio1) {
				return true;
			}
		}
		return false;
	}

	public boolean verificaDuplaEntrada(Socio matricula) {
		for (Socio socio : filaSociosEspertos) {
			if (socio == matricula) {
				return true;
			}
		}
		return false;
	}

	public Modalidade verificaModalidade(Socio socio) {
		if (socio.getModalidade() == Modalidade.COMUM) {
			return Modalidade.COMUM;
		}
		if (socio.getModalidade() == Modalidade.ESTUDANTE) {
			return Modalidade.ESTUDANTE;
		}
		return Modalidade.IDOSO;
	}

	public long getContador() {
		return contador;
	}

	public QueueLinkedEx<Socio> listaSociosComuns() {
		return filaSociosComuns;
	}

	public QueueLinkedEx<Socio> listaSociosEstudantes() {
		return filaSociosEstudantes;
	}

	public QueueLinkedEx<Socio> listaSociosIdosos() {
		return filaSociosIdosos;
	}

	public QueueLinkedEx<Socio> listaEspertos() {
		return filaSociosEspertos;
	}

	/*
	 * Métodos que utilizam int como parametro
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