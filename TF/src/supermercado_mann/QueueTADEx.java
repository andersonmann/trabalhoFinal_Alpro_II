package supermercado_mann;

public interface QueueTADEx<E> extends QueueTAD<E> {

	public E get(int index); // obt�m elemento na posi��o index

	public E set(int index, E element); // altera o elemento na posi��o index

	int indexOf(E e);

	boolean contains(E e);

	int contaOcorrencias(E element);

	void retiraRepetidos();

	boolean remove(E element);

	E removeFirst();

	E removeLast();

	E remove(int index);

	QueueTADEx<E> uniao(QueueTADEx<E> lista);
}
