package org.pmoo.albion;

public class AtaqueNoEncontradoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AtaqueNoEncontradoException(){
		super("Ha introducido un numero fuera de los posibles en la lista de ataques");
	}
}
