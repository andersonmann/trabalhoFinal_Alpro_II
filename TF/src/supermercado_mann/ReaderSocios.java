/**
 * 
 */
package supermercado_mann;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Anderson_M_Mann
 * @param <E>
 * 
 */
public class ReaderSocios<E> extends Reader<E> {
	public static QueueLinkedEx<SocioV2> listaSocios;

	public ReaderSocios() {
		listaSocios = new QueueLinkedEx<>();
	}

	/**
	 * Method carregaSocios.
	 * 
	 * @return - Metodo que faz a leitura do arquivo que contem os socios e
	 *         salva em uma lista.
	 */
	public void carregaSocios() throws IOException {
		Path path = Paths.get("Socios.txt");
		try (BufferedReader br = Files.newBufferedReader(path,
				Charset.defaultCharset())) {
			String linha = null;
			while ((linha = br.readLine()) != null) {
				String dados[] = linha.split(",");
				String nome = dados[0];
				int matricula = Integer.parseInt(dados[1]);
				String categoria = dados[2];
				String modalidade = dados[3];
				listaSocios.add(new SocioV2(nome, matricula, categoria,
						modalidade));
			}
		} catch (EstadioException e) {
			System.err.println("Erro de E/S: " + e);
		}
		// Exibe o tamanho da lista
		// System.out.println("Tamanho " + listaSocios.count);
	}

	@Override
	public String toString() {
		if (listaSocios.isEmpty()) {
			return ("Lista vazia !!");
		} else {
			StringBuilder sb = new StringBuilder();
			for (SocioV2 p : listaSocios) {
				sb.append(p.toString());
				sb.append("\n");
			}
			return (sb.toString());
		}
	}

}
