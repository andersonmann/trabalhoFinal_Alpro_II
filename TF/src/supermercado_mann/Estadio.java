/**
 * 
 */
package supermercado_mann;

/**
 * @author Anderson_M_Mann
 * 
 */
public class Estadio {
	protected QueueLinkedEx<Socio> socios;
	
	/*
	 * Construtor 
	 */
	public Estadio(){
		socios = new QueueLinkedEx<>();
	}
	
    /**
     * Metodo getSocios.
     * @return QueueLinkedEx de socios cadastrados 
     */
	
	public QueueLinkedEx<Socio> getSocios(){
		return socios;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
