/**
 * 
 */
package supermercado_mann;

/**
 * @author Anderson_M_Mann
 *
 */
public class AppSimulacaoEstadio {

	/**
	 * @param <E>
	 * @param args
	 * @throws EstadioException 
	 */
	public static <E> void main(String[] args) throws EstadioException {
		SimulacaoEstadio<E> sim = new SimulacaoEstadio<>(true);
        sim.simular();
        sim.imprimirResultados();
	}

}
