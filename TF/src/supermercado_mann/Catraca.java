package supermercado_mann;

public class Catraca<E> extends QueueLinkedEx<E> {

	protected QueueLinkedEx<Boolean> sociosEntraram;
	protected QueueLinkedEx<Integer> sociosEspertos;
	private int contador;

	public Catraca() {
		sociosEntraram = new QueueLinkedEx<Boolean>();
		sociosEspertos = new QueueLinkedEx<Integer>();
		contador = 0;
		/*
		 * Adicionados 100.000 posições com o valor false, indicando que nenhum
		 * socio entrou ainda
		 */
		for (int pos = 0; pos < 100000; pos++) {
			sociosEntraram.add(false);
		}
	}

	public boolean entra(int numeroSocio) {
		contador++;
		if (sociosEntraram.get(numeroSocio - 1) == true) {
			sociosEspertos.add(numeroSocio);
			return false;
		}
		sociosEntraram.set(numeroSocio - 1, true);
		return true;
	}

	public boolean verificaDuplaEntrada(int numeroSocio) {
		//contador++;
		if (sociosEntraram.get(numeroSocio - 1) == true) {
			return true;
		}
		return false;
	}

	public boolean verificaDuplaEntradaV2(int numeroSocio) {
		for (Integer socio : sociosEspertos) {
			//contador++;
			if (socio == numeroSocio) {
				return true;
			}
		}
		return false;
	}

	public int getContador() {
		return contador;
	}

	public QueueLinked<Integer> listaEspertos() {
		return sociosEspertos;
	}

}