package supermercado_mann;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Anderson_M_Mann
 * 
 */

public class Reader<E>  {	
	public QueueLinked<Jogo> lista;
	public Reader() {
		lista = new QueueLinked<Jogo>();
	}	
	public void carregaJogos() throws IOException {
		Path path = Paths.get("DadosJogos.txt");
		try (BufferedReader br = Files.newBufferedReader(path,
				Charset.defaultCharset())) {
			String linha = null;
			while ((linha = br.readLine()) != null) {
				String dados[] = linha.split(",");				
				int capacidade = Integer.parseInt(dados[0]);
				String data = dados[1];
				String local = dados[2];
				String time1 = dados[3];
				String time2 = dados[4];
				double valor = Integer.parseInt(dados[5]);								
				lista.add(new Jogo(capacidade, data, local, time1, time2, valor));				
			}
			
		} catch (EstadioException e) {
			System.err.println("Erro de E/S: " + e);
		}
		System.out.println("Tamanho "+ lista.count);
		//System.out.println(lista.toString());		
	}	

/*	public boolean contemRepetidos(String data) {
		for (int p = 0; p < lista.size(); p++) {
			if (lista.pop(p).getData().equals(data)) {
				return true;
			}
		}
		return false;
	}*/

	/*public Jogo exibeJogo(String ian) throws EstadioException {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).get().equals(ian)) {
				return lista.get(i);
			}
		}
		throw new EstadioException("O codigo IAN fornecido não existe");
	}*/
	
	@Override
	public String toString() {
		if (lista.isEmpty()) {
			return ("Lista vazia !!");
		} else {
			StringBuilder sb = new StringBuilder();
			for (Jogo p : lista) {
				sb.append(p.toString());
				sb.append("\n");
			}
			return (sb.toString());
		}
	}   
	
}
