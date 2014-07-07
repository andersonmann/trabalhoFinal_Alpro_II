package supermercado_mann;

/*
 * Programa principal da simulacao
 */
public class SimuladorSupermercado
{
    public static <E> void main(String[] args) throws EstadioException
    {
        Simulacao<E> sim = new Simulacao<E>(true);
        sim.simular();
        sim.imprimirResultados();
    }
}
