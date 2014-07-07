package supermercado_mann;

import java.io.IOException;

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
		System.out.println("Jogos que irão ocorrer no estadio:\n");	
		System.out.println(reader.toString());
		
		Socio s1 = new Socio("Anderson", 1010, Categoria.NADA_VAI_NOS_SEPARAR,Modalidade.ESTUDANTE);
		Socio s2 = new Socio("Eduardo", 2020, Categoria.CAMPEAO_DO_MUNDO,Modalidade.ESTUDANTE);
		Socio s3 = new Socio("Julio", 3030, Categoria.CAMPEAO_DO_MUNDO,Modalidade.IDOSO);
		Socio s4 = new Socio("Amauri", 4040, Categoria.NADA_VAI_NOS_SEPARAR,Modalidade.ESTUDANTE);
		Socio s5 = new Socio("Ricardo", 5050, Categoria.CAMPEAO_DO_MUNDO, Modalidade.COMUM);
		Socio s6 = new Socio("Beltrano", 6060, Categoria.NADA_VAI_NOS_SEPARAR, Modalidade.IDOSO);
		Socio s7 = new Socio("Fulano", 7070, Categoria.CAMPEAO_DO_MUNDO, Modalidade.COMUM);
		
		Estadio<Socio> estadio = new Estadio<>();
		Catraca<Socio> catraca = new Catraca<>();
		
		QueueLinkedEx<Socio> sociosCadastrados = estadio.listaDeSocios();
		QueueLinkedEx<Socio> filaGeral = catraca.filaGeral;		
		QueueLinkedEx<Socio> filaSociosComuns = catraca.listaSociosComuns();
		QueueLinkedEx<Socio> filaSociosEstudantes = catraca.listaSociosEstudantes();
		QueueLinkedEx<Socio> filaSociosIdosos = catraca.listaSociosIdosos();
		QueueLinkedEx<Socio> filaSociosEspertos = catraca.listaEspertos();
		QueueLinkedEx<Socio> sociosEntraram = catraca.publicoTotal(); 				
		
		sociosCadastrados.add(s1); sociosCadastrados.add(s2); sociosCadastrados.add(s3); sociosCadastrados.add(s4); sociosCadastrados.add(s5);sociosCadastrados.add(s6);sociosCadastrados.add(s7);
		
		catraca.entrarNaFilaGeral(s1);catraca.entrarNaFilaGeral(s1);catraca.entrarNaFilaGeral(s2);catraca.entrarNaFilaGeral(s3);catraca.entrarNaFilaGeral(s4);catraca.entrarNaFilaGeral(s5);
		
		catraca.entrarNaFilaCorreta(filaGeral);		
		
		catraca.entrarNoEstadioSociosComuns(filaSociosComuns);
		catraca.entrarNoEstadioSociosEstudantes(filaSociosEstudantes);
		catraca.entrarNoEstadioSociosIdosos(filaSociosIdosos);		
			
		 /*Random random = new Random();
		  for (int i = 0; i < 50000; i++) { 
			  int matricula = random.nextInt(100000) + 1; catraca.entra(matricula); }*/
		 
		for(Socio socios : sociosCadastrados){
			System.out.println("Socios cadastrados: "+ socios);	
		}
		System.out.println("");
		System.out.println("Quantidade de socios cadastrados: " + sociosCadastrados.size());		
		System.out.println("");		
		for(Socio socio: filaGeral){
			System.out.println("Socios na fila geral: " + socio);
		}
		System.out.println("");			
		System.out.println("Quantidade de socios na fila geral: " + filaGeral.size());	
		
		System.out.println("");
		
		for (Socio comum : filaSociosComuns) {
			System.out.println("Socios na fila da modalidade comum: " + comum);
		}
		System.out.println("");
		for (Socio estudante : filaSociosEstudantes) {
			System.out.println("Socios na fila da modalidade estudante: " + estudante);
		}
		System.out.println("");
		for (Socio idoso : filaSociosIdosos) {
			System.out.println("Socios na fila da modalidade idoso: " + idoso);
		}
		System.out.println("");
		for (Socio entratam : sociosEntraram) {
			System.out.println("Socios que entraram no estadio: " + entratam);
		}
		System.out.println("");
		System.out.println("Publico total dentro do estádio: " + catraca.quantidadeTotalDeSociosQueEntraram());
		System.out.println("");	
		System.out.println("Quantidade de socios que tentaram entrar mais de uma vez: " + catraca.filaSociosEspertos.size());
		System.out.println("");
		for (Socio espertos : filaSociosEspertos) {
			System.out.println("Socio que tentou entrar mais de uma vez: " + espertos);
		}
		System.out.println("");		
		/*
		 * Método que retorna o public total public int quantidadeTotalDeSociosQueEntraram() 
		 */

		System.out.println("Quantidade de socios que passaram pela conferencia de modalidade: " + catraca.quantidadeTotalDeSociosQueTentaramEntrar());
		System.out.println("");	
		System.out.println("Socio de matricula 2020 entrou: " + catraca.verificaEntrada(s2));	 		
		System.out.println("");	
		/*  
		 * Método public boolean verificaDuplaEntrada(Socio matricula) está funcionando
		 */
		System.out.println("Verifica dupla entrada do socio de matricula 1010 : "+ catraca.verificaDuplaEntrada(s1));
		System.out.println("");					
		System.out.println("União das filas \"Estudantes\" e \"Comuns\":\n" + filaSociosComuns.uniao(filaSociosEstudantes));
		System.out.println("");
		System.out.println("Media de socios que entraram da modalidade \"Comum\": " + catraca.mediaSociosQueEntraramModalidadeComuns());
		System.out.println("");
		System.out.println("Media de socios que entraram da modalidade \"estudante\": " + catraca.mediaSociosQueEntraramModalidadeEstudantes());
		System.out.println("");
		System.out.println("Media de socios que entraram da modalidade \"idoso\": " + catraca.mediaSociosQueEntraramModalidadeIdosos());
						
		/*
		 * Retorna o total de operações de acesso (contador)
		 * System.out.println("Total de operações de acesso: " +
		 * catraca.getContador());
		 */
		long depois = System.currentTimeMillis();
		double tempo = (depois - antes);

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
		//System.out.println("Get matricula: " + estadio.getSocio(s1));
		//System.out.println("Get matricula: " + estadio.getSocio(1010));

		/* Métodos que utilizam int como parametro
		 */		
		/* Exibe os socois que tentaram entrar mais de uma vez 
		 * for (Socio i : listaEspertos2) System.out.println("Espertos " + i);
		 */
		// QueueLinked<Integer> listaEspertos = catraca.listaEspertos();
		// System.out.println("Total de espertos: " + listaEspertos2.size());
	}
}
