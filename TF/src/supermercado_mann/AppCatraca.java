package supermercado_mann;

import java.io.IOException;
import java.util.Random;

/*//Como melhorar o algoritmo?
 * 
 * - Dividir os socios em v�rias listas (ex: 1-1000, 2000-3000, ...)
 * - Manter a lista ordenada e buscar de forma inteligente
 * 
 */
public class AppCatraca {
	/**
	 * @param args
	 * @throws IOException
	 * @throws EstadioException
	 */
	public static void main(String[] args) throws IOException, EstadioException {
		Reader<Jogo> reader = new Reader<>();
		reader.carregaJogos();
		System.out.println(reader.toString());
		
		Socio s1 = new Socio("Anderson", "1010", Categoria.NADA_VAI_NOS_SEPARAR, Modalidade.COMUM);
		Socio s2 = new Socio("Eduardo", "2020", Categoria.CAMPEAO_DO_MUNDO, Modalidade.ESTUDANTE);
		System.out.println("Socio 1 " + s1.toString());
		System.out.println("Socio 2 " + s2.toString());		

		Catraca<Object> catraca = new Catraca<Object>();
		Random rnd = new Random();
		long antes = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			int numeroSocio = rnd.nextInt(100000) + 1;
			catraca.entra(numeroSocio);
		}
		long depois = System.currentTimeMillis();
		double tempo = (depois - antes);
		QueueLinked<Integer> listaEspertos = catraca.listaEspertos();
		System.out.println("Total de espertos: " + listaEspertos.size());
		/*
		 * Exibe os socois que tentaram entrar mais de uma vez for (Integer i :
		 * listaEspertos) System.out.println("Espertos " + i);
		 */
		System.out.println("Total de opera��es de acesso: "
				+ catraca.getContador());
		System.out.println("Tempo de processamento: " + tempo + " ms");
		catraca.add(51127);
		System.out.println(catraca.verificaDuplaEntrada(51127));
	}
}
