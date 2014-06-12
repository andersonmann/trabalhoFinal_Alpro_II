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
//public class Reader<E> extends StackLinked<E> {
public class Reader<E> extends QueueLinkedEx<E> {
	
	public QueueLinkedEx<Jogo> lista;

	public Reader() {
		lista = new QueueLinkedEx<Jogo>();
	}

	public void loadGames() throws IOException {
		Path path = Paths.get("arquivo.txt");
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
				/*if (contemRepetidos(data) == true) {
					throw new EstadioException("IAN já adicionado");
				}*/
				//lista.push(new Jogo(capacidade, data, local, time1, time2, valor));
				lista.add(new Jogo(capacidade, data, local, time1, time2, valor));
				//lista.add(jogo);
			}
		} catch (EstadioException e) {
			System.err.println("Erro de E/S: " + e);
		}
	}

/*	public boolean contemRepetidos(String data) {
		for (int p = 0; p < lista.size(); p++) {
			if (lista.pop(p).getData().equals(data)) {
				return true;
			}
		}
		return false;
	}

	public Jogo exibeProduto(String ian) throws PdvException {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getIan().equals(ian)) {
				return lista.get(i);
			}
		}
		throw new PdvException("O codigo IAN fornecido não existe");
	}*/

/*	@Override
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
	}*/
	
    @Override
    public String toString() {
        String aux = "";
        Node<E> atual = head;
        while (atual != null) {
            aux = aux + atual.element + " ";
            atual = atual.next;
        }
        return aux;
    }
	
    
	
}
