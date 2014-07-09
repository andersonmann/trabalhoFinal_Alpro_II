package supermercado_mann;

import java.util.NoSuchElementException;

public class QueueLinkedEx<E> extends QueueLinked<E> implements QueueTADEx<E> {

	@Override
	public E get(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Posição invalida" + index);
		}
		Node<E> target = head;
		for (int pos = 0; pos < index - 1; pos++) {
			target = target.next;
		}
		return target.element;
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Posição invalida" + index);
		}
		Node<E> target = head;
		for (int pos = 0; pos < index - 1; pos++) {
			target = target.next;
		}
		E aux = target.element; // salva referencia antiga
		target.element = element; // nova referencia
		return aux; // retorna referencia antiga
	}

	@Override
	public int indexOf(E e) {
		Node<E> aux = head;
		int pos = 0;
		while (aux != tail) {
			if (aux.element.equals(e))
				return pos;
			aux = aux.next;
		}
		return -1;
	}

	@Override
	public boolean contains(E e) {
		return indexOf(e) != -1;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Posição invalida" + index);
		}
		if (index == 0) {
			return removeFirst();
		}
		if (index == count - 1) {
			return removeLast();
		}
		Node<E> ant = head;
		for (int pos = 0; pos < index - 1; pos++) {
			ant = ant.next;
		}
		Node<E> aux = ant.next; // Pula o nodo que vai ser removido
		E temp = aux.element; // Referencia para o nodo que vai ser removido
		ant.next = aux.next; // faz a ligação do nodo anterior ao que vai ser
								// removido, ao nodo seguinte ao nodo removido
		count--; // Decrementar o contador
		return temp; // retorna o elemento que foi removido
	}

	@Override
	public boolean remove(E element) {
		int pos = indexOf(element);
		if (pos == -1) {
			return false;
		}
		remove(pos);
		return true;
	}

	@Override
	public E removeFirst() {
		if (head == null) { // Se a lista estiver vazia, gerar uma exceção
			throw new NoSuchElementException("A lista está vazia");
		}
		E aux = head.element; // Armazenar em um auxiliar o elemento apontado
								// por head
		head = head.next; // Novo head passa a ser o nodo seguinte
		count--; // Reduzir count em uma unidade
		if (head == null) { // Se o último elemento for removido, tail recebe
							// null
			tail = null;
		}
		return aux; // Retornar o auxiliar
	}

	@Override
	public E removeLast() {
		if (head == null) { // Se a lista estiver vazia, gerar uma exceção
			throw new NoSuchElementException("A lista está vazia");
		}
		if (count == 1) { // se houver apenas um elemento, chama o removeFirst
			return removeFirst();
		}
		Node<E> aux = head;
		for (int pos = 0; pos < count - 2; pos++) { // "Caminhar" até a posição
													// anterior à final (aux)
			aux = aux.next; // Armazenar em uma variável o objeto referenciado
							// por aux.next.element
		}
		aux.next = null; // Apontar de aux para null
		E temp = tail.element;
		tail = aux; // Fazer com que o final (tail) corresponda à aux
		count--; // Diminuir em um o total de elementos (count)
		return temp; // Retornar a referência armazenada anteriormente
	}

	@Override
	public int contaOcorrencias(E element) {
		Node<E> aux = head; // Nodo auxiliar que inicia no primeiro elemento da
							// lista
		int contador = 0; // contador de ocorrencias
		while (aux != null) { // percorre a lista até o final
			if (aux.element.equals(element)) { // compara os elementos
				contador++; // se o elemento for igual incrementa o contador
			}
			aux = aux.next; // avança para o proximo nodo
		}
		return contador; // retorna o valor de ocorrencias do elemento
	}

	@Override
	public void retiraRepetidos() {
		Node<E> aux = head; // Nodo auxiliar que inicia no primeiro elemento da
							// lista
		while (aux != null) { // percorre a lista até o final
			if (contaOcorrencias(aux.element) > 1) { // se for maior que 1
														// remove o elemento
				remove(aux.element);
			}
			aux = aux.next; // avança para o proximo nodo
		}
	}

	@Override
	public QueueTADEx<E> uniao(QueueTADEx<E> lista) {
		Node<E> aux = head; // Nodo auxiliar que inicia no primeiro elemento da
							// lista
		while (aux != null) { // percorre a lista até o final
			lista.add(aux.element);
			aux = aux.next; // avança para o proximo nodo
		}
		return lista; // retorna a lista contendo os elementos de ambas as
						// listas
	}

	// @Override
	/*public void addLista(QueueTADEx<E> lista) {
		Node<E> aux = head;
		while (aux != null) {
			lista.add(aux.element);
			aux = aux.next;
		}
	}	*/
	

}
