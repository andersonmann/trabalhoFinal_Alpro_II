package supermercado_mann;

/**
 * A classe <code>Jogo</code> representa os dados de um jogo.
 * 
 * @version 1.10 7 July 2014 
 * @author anderson.mann@acad.pucrs.br
 * 
 */

public class Jogo {
	private int capacidade;
	private String data;
	private String local;
	private String time1;
	private String time2;
	private double valorIngresso;

	public Jogo(int capacidade, String data, String local, String time1,
			String time2, double valorIngresso) throws EstadioException {
		checkCapacidade(capacidade);
		checkData(data);
		checkLocal(local);
		checkTime1(time1);
		checkTime2(time2);
		checkValor(valorIngresso);
		this.capacidade = capacidade;
		this.data = data;
		this.local = local;
		this.time1 = time1;
		this.time2 = time2;
		this.valorIngresso = valorIngresso;
	}

	private void checkCapacidade(int capacidade) throws EstadioException {
		if (capacidade <= 0) {
			throw new EstadioException("A capacidade deve ser maior que Zero");
		}
	}

	private void checkData(String data) throws EstadioException {
		if (data == null || "".equalsIgnoreCase(data)) {
			throw new EstadioException("A data não pode ser null");
		}
	}

	private void checkLocal(String local) throws EstadioException {
		if (local == null || "".equalsIgnoreCase(local)) {
			throw new EstadioException("O local não pode ser null.");
		}
	}

	private void checkTime1(String time1) throws EstadioException {
		if (time1 == null || "".equalsIgnoreCase(time1)) {
			throw new EstadioException("O time 1 não pode ser null.");
		}
	}

	private void checkTime2(String time2) throws EstadioException {
		if (time2 == null || "".equalsIgnoreCase(time2)) {
			throw new EstadioException("O time 2 não pode ser null.");
		}
	}

	private void checkValor(double valorIngresso) throws EstadioException {
		if (valorIngresso <= 0) {
			throw new EstadioException("O valor deve ser maior do que zero!");
		}
	}
	
    /**
	 * Method getCapacidade.
	 * 
	 * @return int - Retorna a capacidade do jogo
	 */
	public int getCapacidade() {
		return capacidade;
	}
	
	/**
	 * Method getData.
	 * 
	 * @return String - Retorna a data do jogo
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * Method getLocal.
	 * 
	 * @return String - Retorna o loca do jogo
	 */
	public String getLocal() {
		return local;
	}
	
	/**
	 * Method getTime1.
	 * 
	 * @return String - Retorna o time1 do jogo
	 */
	public String getTime1() {
		return time1;
	}
	
	/**
	 * Method getTime2.
	 * 
	 * @return String - Retorna o time2 do jogo
	 */
	public String getTime2() {
		return time2;
	}
	
	/**
	 * Method getValorIngresso.
	 * 
	 * @return double - Retorna o valor do ingresso do jogo
	 */
	public double getValorIngresso() {
		return valorIngresso;
	}

	@Override
	public String toString() {
		return String
				.format("Detalhes do jogo [capacidade= %s, data= %s, local= %s, time 1= %s, time 2= %s, valorIngresso= %s]",
						capacidade, data, local, time1, time2, valorIngresso);
	}

}
