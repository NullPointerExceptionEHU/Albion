package org.pmoo.albion;

public class Ataque {
	// Atributos
	private int id;
	private String nombre;
	private String descripcion;
	private int dano;

	// constructora
	public Ataque(int pId, String pNombre, String pDescripcion, int pDano) {
		this.id = pId;
		this.nombre = pNombre;
		this.descripcion = pDescripcion;
		this.dano = pDano;
	}

	// getters y setters
	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public int getDano() {
		return this.dano;
	}

	// otros metodos

	/**
	 * Imprime por pantalla un ataque.
	 */
	public void imprimirAtaque() {
		System.out.println("\t" + this.getId() + ". " + this.getNombre());
		System.out.println("\t" + this.getDescripcion());
	}
}
