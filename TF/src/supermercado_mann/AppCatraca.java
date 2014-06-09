package supermercado_mann;

import java.io.IOException;
import java.util.Random;

/* Como melhorar o algoritmo?
 * 
 * - Dividir os socios em várias listas (ex: 1-1000, 2000-3000, ...)
 * - Manter a lista ordenada e buscar de forma inteligente
 * 
 */
public class AppCatraca {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Reader<Jogo> r =  new Reader<>();
		r.loadGames();
		System.out.println(r.toString());
		
		/*Catraca<Object> roleta1 = new Catraca<Object>();
		Random rnd = new Random();
		long antes = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			int socio = rnd.nextInt(100000) + 1;
			roleta1.entra(socio);
		}
		long depois = System.currentTimeMillis();
		double tempo = (depois - antes);
		QueueLinked<Integer> a = roleta1.listaEspertos();
		System.out.println("Total de espertos: " + a.size());		
		 * for (Integer i : a) System.out.println(i);		 
		System.out.println("Total de operações de acesso: "
				+ roleta1.getContador());
		System.out.println("Tempo de processamento: " + tempo + " ms");*/
	}

}
