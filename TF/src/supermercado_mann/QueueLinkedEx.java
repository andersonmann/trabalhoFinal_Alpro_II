package supermercado_mann;

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
		Node<E> aux = head.next;
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
}
