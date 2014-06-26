package supermercado_mann;

import java.io.IOException;
//import java.util.Random;

/*//Como melhorar o algoritmo?
 * 
 * - Dividir os socios em várias listas (ex: 1-1000, 2000-3000, ...)
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
		// Exibe os dados dos jogos
		 System.out.println(reader.toString());
		Socio s1 = new Socio("Anderson", 1010, Categoria.NADA_VAI_NOS_SEPARAR,Modalidade.ESTUDANTE);
		Socio s2 = new Socio("Eduardo", 2020, Categoria.CAMPEAO_DO_MUNDO,Modalidade.ESTUDANTE);
		Socio s3 = new Socio("Julio", 3030, Categoria.CAMPEAO_DO_MUNDO,Modalidade.IDOSO);
		Socio s4 = new Socio("Amauri", 4040, Categoria.NADA_VAI_NOS_SEPARAR,Modalidade.ESTUDANTE);
		Socio s5 = new Socio("Ricardo", 5050, Categoria.CAMPEAO_DO_MUNDO, Modalidade.COMUM);
		
		Catraca<Object> catraca = new Catraca<Object>();
		long antes = System.currentTimeMillis();
		 
		/* Random random = new Random();
		 * for (int i = 0; i < 100000; i++) { int matricula =
		 * random.nextInt(100000) + 1; catraca.entra(matricula); }
		 */
		catraca.entrarNaFilaCorreta(s1); catraca.entrarNaFilaCorreta(s1); catraca.entrarNaFilaCorreta(s2);
		catraca.entrarNaFilaCorreta(s3); catraca.entrarNaFilaCorreta(s4); catraca.entrarNaFilaCorreta(s5);
		QueueLinkedEx<Socio> listaSociosComuns = catraca.listaSociosComuns();
		QueueLinkedEx<Socio> listaSociosEstudantes = catraca.listaSociosEstudantes();
		QueueLinkedEx<Socio> listaSociosIdosos = catraca.listaSociosIdosos();
		QueueLinkedEx<Socio> listaSociosEspertos = catraca.listaEspertos();
		for (Socio comum : listaSociosComuns) {
			System.out.println("Socios modalidade comum: " + comum);
		}
		for (Socio estudante : listaSociosEstudantes) {
			System.out.println("Socios modalidade estudante: " + estudante);
		}
		for (Socio idoso : listaSociosIdosos) {
			System.out.println("Socios modalidade idoso: " + idoso);
		}
		for (Socio espertos : listaSociosEspertos) {
			System.out.println("Socios com dupla entrada: " + espertos);
		}
		System.out.println("Quantidade de socios espertos: " + catraca.filaSociosEspertos.size());
		long depois = System.currentTimeMillis();
		double tempo = (depois - antes);
		/*
		 * Método que retorna o public total public int publicTotal() 
		 */
		System.out.println("Publico total dentro do estádio: " + catraca.publicTotal());	
		
		/*
		 * Retorna o total de operações de acesso (contador)
		 * System.out.println("Total de operações de acesso: " +
		 * catraca.getContador());
		 */

		/*
		 * Retorna o tempo de execução em milisegundos
		 */
		System.out.println("Tempo de processamento: " + tempo + " ms");
		
		/* Método indexOf não está funcionando corretamente
		 * System.out.println("Teste indexOf: " + catraca.sociosComuns.indexOf(s1));
		 */
		
		/*
		 * Método public E get(int index) está funcionando
		 * System.out.println("Teste get: "+ catraca.listaSociosEstudantes().get(0));
		 */
		
		/*
		 * Método public boolean verificaEntradaV2(Socio socio1) está funcionando 
		 */
		System.out.println("Socio de matricula 3030 entrou: "+ catraca.verificaEntrada(s1));

		/*  
		 * Método public boolean verificaDuplaEntrada(Socio matricula) está funcionando
		 */
		System.out.println("Verifica dupla entrada do socio de matricula 1010 : "+ catraca.verificaDuplaEntrada(s1));
				
		System.out.println("União das filas \"Estudantes\" e \"Comuns\":\n" + listaSociosComuns.uniao(listaSociosEstudantes));

		/* Métodos que utilizam int como parametro
		 */		
		/* Exibe os socois que tentaram entrar mais de uma vez 
		 * for (Socio i : listaEspertos2) System.out.println("Espertos " + i);
		 */
		// QueueLinked<Integer> listaEspertos = catraca.listaEspertos();
		// System.out.println("Total de espertos: " + listaEspertos2.size());
	}
}
