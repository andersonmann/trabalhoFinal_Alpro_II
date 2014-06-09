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

	/*public void add(Jogo jogo) {
		// TODO Auto-generated method stub
		
	}*/

}
