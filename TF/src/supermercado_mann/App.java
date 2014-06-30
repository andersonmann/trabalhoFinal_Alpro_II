package supermercado_mann;

import java.io.IOException;
//import java.util.Random;

/*//Como melhorar o algoritmo?
 * 
 * - Dividir os socios em v�rias listas (ex: 1-1000, 2000-3000, ...)
 * - Manter a lista ordenada e buscar de forma inteligente
 * 
 */
public class App {
	/**
	 * @param args
	 * @throws IOException
	 * @throws EstadioException
	 */
	public static void main(String[] args) throws IOException, EstadioException {
		long antes = System.currentTimeMillis();		
		Reader<Jogo> reader = new Reader<>();
		reader.carregaJogos();
		// Exibe os dados dos jogos
		System.out.println(reader.toString());
		Socio s1 = new Socio("Anderson", 1010, Categoria.NADA_VAI_NOS_SEPARAR,Modalidade.ESTUDANTE);
		Socio s2 = new Socio("Eduardo", 2020, Categoria.CAMPEAO_DO_MUNDO,Modalidade.ESTUDANTE);
		Socio s3 = new Socio("Julio", 3030, Categoria.CAMPEAO_DO_MUNDO,Modalidade.IDOSO);
		Socio s4 = new Socio("Amauri", 4040, Categoria.NADA_VAI_NOS_SEPARAR,Modalidade.ESTUDANTE);
		Socio s5 = new Socio("Ricardo", 5050, Categoria.CAMPEAO_DO_MUNDO, Modalidade.COMUM);
		
		Estadio<Socio> estadio = new Estadio<>();
		Catraca<Socio> catraca = new Catraca<>();		
		QueueLinkedEx<Socio> lista = estadio.listaDeSocios();
		QueueLinkedEx<Socio> listaSociosComuns = catraca.listaSociosComuns();
		QueueLinkedEx<Socio> listaSociosEstudantes = catraca.listaSociosEstudantes();
		QueueLinkedEx<Socio> listaSociosIdosos = catraca.listaSociosIdosos();
		QueueLinkedEx<Socio> listaSociosEspertos = catraca.listaEspertos();
		
		lista.add(s1); lista.add(s2); lista.add(s3); lista.add(s4); lista.add(s5); 		
		catraca.entrarNaFilaCorreta(s1); catraca.entrarNaFilaCorreta(s1); catraca.entrarNaFilaCorreta(s2);
		catraca.entrarNaFilaCorreta(s3); catraca.entrarNaFilaCorreta(s4); catraca.entrarNaFilaCorreta(s5);						 
		/* Random random = new Random();
		 * for (int i = 0; i < 100000; i++) { int matricula =
		 * random.nextInt(100000) + 1; catraca.entra(matricula); }
		 */
		for(Socio sociosCadastrados : lista){
			System.out.println("Socios cadastrados: "+ sociosCadastrados);	
		}
		System.out.println("");
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
		 * M�todo que retorna o public total public int publicTotal() 
		 */
		System.out.println("Publico total dentro do est�dio: " + catraca.publicTotal());	
		
		/*
		 * Retorna o total de opera��es de acesso (contador)
		 * System.out.println("Total de opera��es de acesso: " +
		 * catraca.getContador());
		 */

		/*
		 * Retorna o tempo de execu��o em milisegundos
		 */
		System.out.println("Tempo de processamento: " + tempo + " ms");
		
		/* M�todo indexOf n�o est� funcionando corretamente
		 * System.out.println("Teste indexOf: " + catraca.sociosComuns.indexOf(s1));
		 */
		
		/*
		 * M�todo public E get(int index) est� funcionando
		 * System.out.println("Teste get: "+ catraca.listaSociosEstudantes().get(0));
		 */
		
		/*
		 * M�todo public boolean verificaEntradaV2(Socio socio1) est� funcionando 
		 */
		System.out.println("Socio de matricula 3030 entrou: "+ catraca.verificaEntrada(s1));

		/*  
		 * M�todo public boolean verificaDuplaEntrada(Socio matricula) est� funcionando
		 */
		System.out.println("Verifica dupla entrada do socio de matricula 1010 : "+ catraca.verificaDuplaEntrada(s1));
				
		System.out.println("Uni�o das filas \"Estudantes\" e \"Comuns\":\n" + listaSociosComuns.uniao(listaSociosEstudantes));
		
		//System.out.println("Get matricula: " + estadio.getSocio(s1));
		System.out.println("Get matricula: " + estadio.getSocio(1010));

		/* M�todos que utilizam int como parametro
		 */		
		/* Exibe os socois que tentaram entrar mais de uma vez 
		 * for (Socio i : listaEspertos2) System.out.println("Espertos " + i);
		 */
		// QueueLinked<Integer> listaEspertos = catraca.listaEspertos();
		// System.out.println("Total de espertos: " + listaEspertos2.size());
	}
}
