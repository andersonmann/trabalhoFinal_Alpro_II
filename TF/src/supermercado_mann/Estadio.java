/**
 * 
 */
package supermercado_mann;

/**
 * @author Anderson_M_Mann
 * 
 */
public class Estadio<E> extends QueueLinkedEx<E>{
	public QueueLinkedEx<Socio> socios;
	
	/*
	 * Construtor 
	 */
	public Estadio(){
		socios = new QueueLinkedEx<Socio>();
	}
	
    /**
     * Metodo getSocios.
     * @return QueueLinkedEx de socios cadastrados 
     */
	
	public QueueLinkedEx<Socio> listaDeSocios(){
		return socios;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
