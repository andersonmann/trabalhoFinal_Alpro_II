package supermercado_mann;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLinked<E> implements StackTAD<E> {

	protected static final class Node<E> {
		public E element;
		public Node<E> next;

		public Node(E e) {
			element = e;
			next = null;
		}
	}

	protected Node<E> header; // nodo sentinela
	protected int count;

	public StackLinked() {
		clear();
	}

	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private Node<E> current = header;

			public boolean hasNext() {
				// if(current == null
				// return false;
				// else
				// return true;
				return current != null;
			}

			public E next() {
				if (current == null)
					throw new NoSuchElementException();
				E item = current.element;
				current = current.next;
				return item;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Not supported yet.");
			}
		};
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public void clear() {
		header = new Node<>(null);
		count = 0;
	}

	@Override
	public E getTop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return header.next.element;
	}

	@Override
	public void push(Jogo jogo) {
		@SuppressWarnings("unchecked")
		Node<E> n = (Node<E>) new Node<>(jogo);
		n.next = header.next;
		header.next = n;
		count++;
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		Node<E> target = header.next;
		E item = target.element;
		header.next = target.next;
		target.element = null;
		target.next = null;
		count--;
		return item;
	}

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub

	}
	
    @Override
    public String toString() {
        String aux = "";
        Node<E> atual = header;
        while (atual != null) {
            aux = aux + atual.element + " ";
            atual = atual.next;
        }
        return aux;
    }

}
