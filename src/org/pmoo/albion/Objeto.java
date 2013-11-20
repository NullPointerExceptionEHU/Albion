package org.pmoo.albion;

public abstract class Objeto {
	// atributos
	private int id;
	private String descripcion;
	private String nombre;

	// constructora
	public Objeto(int pId, String pNombre, String pDescripcion) {
		this.nombre = pNombre;
		this.descripcion = pDescripcion;
		this.id = pId;
	}

	// getters y setters
	public int getId() {
		return this.id;
	}

	private String getDescripcion() {
		return descripcion;
	}

	private String getNombre() {
		return nombre;
	}

	/**
	 * Imprime el objeto con su descripcion, nombre e id.
	 */

	// otros metodos
	public void imprimir() {
		System.out.println(this.getNombre());
		System.out.println(this.getDescripcion());
	}
}