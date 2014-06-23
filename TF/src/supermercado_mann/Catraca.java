package supermercado_mann;

public class Catraca<E> extends QueueLinkedEx<E> {

	protected QueueLinkedEx<Integer> sociosEntraram;
	protected QueueLinkedEx<Integer> sociosEspertos;
	private long contador;
	/*
	 * Adicionar um metodo que leia de um arquivo a quantidade de torcedores que
	 * irão entrar no estadio
	 */
	public Catraca() {
		sociosEntraram = new QueueLinkedEx<Integer>();
		sociosEspertos = new QueueLinkedEx<Integer>();
		contador = 0;
		/*
		 * Adicionados 100.000 posições com o valor false, indicando que nenhum
		 * socio entrou ainda
		 */
		//for (int pos = 0; pos < 100000; pos++) {
			//sociosEntraram.add(pos);
			// sociosEntraram.add(false);
		//}
	}
	
	public void entra(int matricula){
		if(verificaEntrada(matricula) == true){
			sociosEspertos.add(matricula);			
		}
		sociosEntraram.add(matricula);				
	}
		
	/*public boolean entra(int matricula) {
		contador++;
		if (verificaDuplaEntradaV2(matricula) == true) {
			sociosEspertos.add(matricula);
			return false;
		}
		sociosEntraram.add(matricula);
		return true;
	}*/
	
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

	public boolean verificaEntrada(int matricula) {
		for (Integer socio : sociosEntraram) {
			contador++;
			if (socio == matricula) {
				return true;
			}
		}
		return false;
	}

	public long getContador() {
		return contador;
	}

	public QueueLinked<Integer> listaEspertos() {
		return sociosEspertos;
	}

}