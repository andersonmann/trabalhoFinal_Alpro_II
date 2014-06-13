package supermercado_mann;

public interface QueueTAD<E>
{
    void add(E element);
    E remove();
    int size();
    boolean isEmpty();
    void clear();
    E element();
	//E get(int index);
	//E set(int index, E element);
}
