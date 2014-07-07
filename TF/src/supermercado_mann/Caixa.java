package supermercado_mann;

public class Caixa<E> extends QueueLinkedEx<E>{	
	private QueueLinkedEx<Cliente> fila;
	private Cliente clienteAtual; 
	private int numeroAtendidos;
	private int numero;
		
	public Caixa(int num) {
        numero = num;
        clienteAtual = null;
        numeroAtendidos = 0;
        fila =  new QueueLinkedEx<Cliente>();
    } 
	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}


	public void atenderNovoCliente() {
		clienteAtual = fila.remove();
	}

	public void atenderNovoCliente(Cliente c) {
		clienteAtual = c;
	}

	public Cliente dispensarClienteAtual() {
		Cliente c = clienteAtual;
		clienteAtual = null;
		numeroAtendidos++;
		return c;
	}

	public boolean estaVazio() {
		return (clienteAtual == null);
	}

	public Cliente getClienteAtual() {
		return clienteAtual;
	}

	public int getNumeroAtendidos() {
		return numeroAtendidos;
	}

	public int totalClientesFila() {
		if (clienteAtual != null)
			return fila.size() + 1;
		return fila.size();
	}

	public void adicionaClienteFila(Cliente s) {
		fila.add(s);
	}
}
