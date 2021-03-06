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
		ReaderSocios<Socio> readerSocios = new ReaderSocios<>();
		Estadio<Socio> estadio = new Estadio<>();
		Catraca<Socio> catraca = new Catraca<>();
		reader.carregaJogos();
		QueueLinkedEx<Socio> sociosCadastrados = estadio.listaDeSocios();
		QueueLinkedEx<SocioV2> sociosCadastradosViaArquivo = estadio
				.listaDeSociosViaArquivo();
		QueueLinkedEx<SocioV2> listaSociosViaArquivo = ReaderSocios.listaSocios;

		readerSocios.carregaSocios();
		// Exibe os dados dos jogos
		System.out.println("Jogos que ir�o ocorrer no estadio:\n");
		System.out.println(reader.toString());
		// Exibe os socios que est�o no arquivo
		System.out.println("Socios cadastrados \"Via Arquivo\":\n");
		System.out.println(readerSocios.toString());
		System.out.println("Quantidade de socios  cadastrados \"Via Arquivo\": "+ catraca.quantidadeSociosViaArquivo());
		System.out.println("");
		
		Socio s1 = new Socio("Anderson", 1010, Categoria.NADA_VAI_NOS_SEPARAR,Modalidade.ESTUDANTE);
		Socio s2 = new Socio("Eduardo", 2020, Categoria.CAMPEAO_DO_MUNDO,Modalidade.ESTUDANTE);
		Socio s3 = new Socio("Julio", 3030, Categoria.CAMPEAO_DO_MUNDO,Modalidade.IDOSO);
		Socio s4 = new Socio("Amauri", 4040, Categoria.NADA_VAI_NOS_SEPARAR,Modalidade.ESTUDANTE);
		Socio s5 = new Socio("Ricardo", 5050, Categoria.CAMPEAO_DO_MUNDO,Modalidade.COMUM);
		Socio s6 = new Socio("Beltrano", 6060, Categoria.NADA_VAI_NOS_SEPARAR,Modalidade.IDOSO);
		Socio s7 = new Socio("Fulano", 7070, Categoria.CAMPEAO_DO_MUNDO,Modalidade.COMUM);
		
		sociosCadastrados.add(s1);
		sociosCadastrados.add(s2);
		sociosCadastrados.add(s3);
		sociosCadastrados.add(s4);
		sociosCadastrados.add(s5);
		sociosCadastrados.add(s6);
		sociosCadastrados.add(s7);
		estadio.pagarMensalidade(s1);
		estadio.pagarMensalidade(s2);
		estadio.pagarMensalidade(s3);
		estadio.pagarMensalidade(s4);
		estadio.pagarMensalidade(s5);
		estadio.pagarMensalidade(s6);// estadio.pagarMensalidade(s7);
		// estadio.mensalidadeAtrasada(s5);
		estadio.mensalidadeAtrasada(s7);
		catraca.entrarNaFilaGeral(s1);
		catraca.entrarNaFilaGeral(s1);
		catraca.entrarNaFilaGeral(s2);
		catraca.entrarNaFilaGeral(s3);
		catraca.entrarNaFilaGeral(s4);
		catraca.entrarNaFilaGeral(s5);

		QueueLinkedEx<Socio> sociosMensalidadeEmDia = estadio.sociosAdimplentes;
		QueueLinkedEx<Socio> sociosMensalidadeAtrasada = estadio.sociosInadimplentes;

		// sociosMensalidadeEmDia.clear();
		// sociosMensalidadeAtrasada.clear();

		QueueLinkedEx<Socio> filaGeral = catraca.filaGeral;
		QueueLinkedEx<Socio> filaSociosComuns = catraca.listaSociosComuns();
		QueueLinkedEx<Socio> filaSociosEstudantes = catraca.listaSociosEstudantes();
		QueueLinkedEx<Socio> filaSociosIdosos = catraca.listaSociosIdosos();
		QueueLinkedEx<Socio> filaSociosEspertos = catraca.listaEspertos();
		QueueLinkedEx<Socio> sociosDentroDoEstadio = catraca.publicoTotal();

		catraca.entrarNaFilaCorreta(filaGeral);
		catraca.entrarNoEstadioSociosComuns(filaSociosComuns);
		catraca.entrarNoEstadioSociosEstudantes(filaSociosEstudantes);
		catraca.entrarNoEstadioSociosIdosos(filaSociosIdosos);

		// sociosCadastrados.uniao(lista);
		// catraca.entrarNaFilaGeral(s1);catraca.entrarNaFilaGeral(s1);catraca.entrarNaFilaGeral(s2);catraca.entrarNaFilaGeral(s3);catraca.entrarNaFilaGeral(s4);catraca.entrarNaFilaGeral(s5);
		/*
		 * ESTA DANDO ERRO QueueLinkedEx<SocioV2> uniao = sociosCadastrados.uniao(listaSociosViaArquivo);
		 * System.out.println("Uni�o das listas:\n" + uniao);
		 */
		// catraca.entrarNaFilaGeralV2(1);
		/*
		 * Random random = new Random(); for (int i = 0; i < 50000; i++) { int
		 * matricula = random.nextInt(100000) + 1; catraca.entra(matricula); }
		 */

		for (Socio socios : sociosCadastrados) {
			System.out.println("Socios cadastrados \"Via App\": " + socios);
		}
		System.out.println("");
		System.out.println("Quantidade de socios cadastrados \"Via App\": "
				+ sociosCadastrados.size());
		System.out.println("");		

		for (Socio socio : filaGeral) {
			System.out.println("Socios que passaram pela fila geral: " + socio);
		}
		System.out.println("");
		System.out.println("Quantidade de socios que passaram na fila geral: " + filaGeral.size());
		System.out.println("");
		for (Socio comum : filaSociosComuns) {
			System.out.println("Socios que passaram pela fila da modalidade comum: " + comum);
		}
		System.out.println("");
		for (Socio estudante : filaSociosEstudantes) {
			System.out.println("Socios que passaram pela fila da modalidade estudante: " + estudante);
		}
		System.out.println("");
		for (Socio idoso : filaSociosIdosos) {
			System.out.println("Socios que passaram pela fila da modalidade idoso: " + idoso);
		}
		System.out.println("");
		for (Socio entratam : sociosDentroDoEstadio) {
			System.out.println("Socios que entraram no estadio: " + entratam);
		}
		System.out.println("");
		System.out.println("Publico total dentro do est�dio: "  + catraca.quantidadeTotalDeSociosQueEntraram());
		System.out.println("");
		for (Socio sociosAtrasados : sociosMensalidadeAtrasada) {
			System.out.println("Socios que estao com a mensalidade atrasada: " + sociosAtrasados);
		}
		System.out.println("");
		for (Socio sociosEmDia : sociosMensalidadeEmDia) {
			System.out.println("Socios que estao com a mensalidade em dia: " + sociosEmDia);
		}
		System.out.println("");
		System.out.println("Quantidade de socios com a mensalidade em dia: " + estadio.quantidadeSociosAdimplentes());
		System.out.println("");
		System.out.println("Quantidade de socios com a mensalidade atrasada: " + estadio.quantidadeSociosInadimplentes());
		System.out.println("");
		System.out.println("Quantidade de socios que tentaram entrar mais de uma vez: " + catraca.filaSociosEspertos.size());
		System.out.println("");
		for (Socio espertos : filaSociosEspertos) {
			System.out.println("Socio que tentou entrar mais de uma vez: " 	+ espertos);
		}
		System.out.println("");
		System.out.println("Quantidade de socios que passaram pela conferencia de modalidade: " + catraca.qtdTotalSociosVerificadaModalidade());
		System.out.println("");
		System.out.println("Socio de matricula 2020 entrou: " + catraca.verificaEntrada(s2));
		System.out.println("");
		System.out.println("Verifica dupla entrada do socio de matricula 1010 : " + catraca.verificaDuplaEntrada(s1));
		System.out.println("");
		System.out.println("Uni�o das filas \"Estudantes\" e \"Comuns\":\n" + filaSociosComuns.uniao(filaSociosEstudantes));
		System.out.println("M�dia das modalidades de socios: " + catraca.mediaSocios());
		System.out.println("");
		System.out.println("M�dia de socios que entraram da modalidade \"Comum\": " + catraca.mediaSociosQueEntraramModalidadeComuns());
		System.out.println("");
		System.out.println("M�dia de socios que entraram da modalidade \"estudante\": "	+ catraca.mediaSociosQueEntraramModalidadeEstudantes());
		System.out.println("");
		System.out.println("M�dia de socios que entraram da modalidade \"idoso\": " + catraca.mediaSociosQueEntraramModalidadeIdosos());
		System.out.println("");
		// Retorna o total de opera��es de acesso (contador)
		System.out.println("Total de opera��es de acesso: " + catraca.getContador());
		long depois = System.currentTimeMillis();
		double tempo = (depois - antes);
		/*
		 * Retorna o tempo de execu��o em milisegundos
		 */
		System.out.println("Tempo de processamento: " + tempo + " ms");
		// M�todo public E get(int index) est� funcionando
		// System.out.println("Teste get: "+
		// catraca.listaSociosEstudantes().get(0));
		// System.out.println("Get matricula: " + estadio.getSocio(s1));
		// System.out.println("Get matricula: " + estadio.getSocio(1010));
	}
}
