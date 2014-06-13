package supermercado_mann;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLinked<E> implements QueueTAD<E>, Iterable<E> {
	static final class Node<E> {
		public E element;
		public Node<E> next;

		public Node(E e) {
			element = e;
			next = null;
		}
	}

	protected Node<E> head;
	protected Node<E> tail;
	protected int count;

	public QueueLinked() {
		head = null;
		tail = null;
		count = 0;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public void clear() {
		head = null;
		tail = null;
		count = 0;
	}

	public E element() {
		if (isEmpty())
			throw new EmptyQueueException();
		return head.element;
	}

	@Override
	public void add(E element) {
		Node<E> n = new Node<E>(element);
		if (head == null)
			head = n;
		else
			tail.next = n;
		tail = n;
		count++;

	}

	public E remove() {
		if (isEmpty())
			throw new EmptyQueueException();
		Node<E> target = head;
		E item = target.element;
		head = target.next;
		target.element = null;
		target.next = null;
		if (head == null)
			tail = null;
		count--;
		return item;
	}

	/*@Override
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
	}*/

/*	@Override
	public String toString() {
		String aux = "";
		Node<E> atual = head;
		while (atual != null) {
			aux = aux + atual.element + " ";
			atual = atual.next;
		}
		return aux;
	}*/

	@Override
	public Iterator<E> iterator() {
		return (new Iterator<E>() {
            //protected Node<E> current = head.next;
            protected Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                E item = current.element;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        });
	}

}
