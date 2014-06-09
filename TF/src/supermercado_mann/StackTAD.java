/**
 * 
 */
package supermercado_mann;

/**
 * @author anderson
 * 
 */
public interface StackTAD<E> {

	int size();

	boolean isEmpty();

	void clear();

	E getTop();

	void push(E element);

	E pop();

	void push(Jogo jogo);

}
