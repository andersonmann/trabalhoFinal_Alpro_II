package supermercado_mann;

public class Catraca<E> extends QueueLinkedEx<E> {

	protected QueueLinkedEx<Boolean> sociosEntraram;
	// protected QueueLinked<Boolean> socios;
	protected QueueLinkedEx<Integer> sociosEspertos;
	private int contador;

	public Catraca() {
		sociosEntraram = new QueueLinkedEx<Boolean>();
		// socios = new QueueLinked<Boolean>();
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

	/*
	 * public boolean entra(int nroSocio) { for (Integer socio : socios) {
	 * contador++; if (socio == nroSocio) { sociosEspertos.add(nroSocio); return
	 * false; } } socios.add(nroSocio); return true; }
	 */

	public int getContador() {
		return contador;
	}

	public QueueLinked<Integer> listaEspertos() {
		return sociosEspertos;
	}

}