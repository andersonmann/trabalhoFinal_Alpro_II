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
	 * @param args
	 * @throws EstadioException 
	 */
	public static void main(String[] args) throws EstadioException {
		SimulacaoEstadio sim = new SimulacaoEstadio(true);
        sim.simular();
        sim.imprimirResultados();

	}

}
