package org.pmoo.albion;

import java.util.ArrayList;

import java.util.Iterator;

public class ListaAtaques {
	// atributos
	private ArrayList<Ataque> lista;

	// constructora
	public ListaAtaques() {
		this.lista = new ArrayList<Ataque>();
	}

	// getters y setters
	private Iterator<Ataque> getIterador() {
		return this.lista.iterator();
	}

	// otros metodos
	/**
	 * @param pAtaque
	 *            Anade el ataque que recibimos como parametro a la lista de
	 *            ataques.
	 */
	public void anadirAtaque(Ataque pAtaque) {
		if (this.buscarAtaquePorId(pAtaque.getId()) == null) {
			this.lista.add(pAtaque);
		} else {
			System.out.println("Imposible añadir el ataque. El id ya esta en uso");
		}
	}

	public boolean esta(Ataque pAtaque){
		return this.lista.contains(pAtaque);
	}
	
	/**
	 * @param pIdAtaque
	 * @return devuelve el ataque al que se le ha asignado un identificador.
	 */
	public Ataque buscarAtaquePorId(int pIdAtaque) {
		Iterator<Ataque> itr = this.getIterador();
		Ataque unAtaque = null;
		boolean encontrado = false;
		while (itr.hasNext() && !encontrado) {
			unAtaque = itr.next();
			if (unAtaque.getId() == pIdAtaque) {
				encontrado = true;
			} else {
				unAtaque = null;
			}
		}
		return unAtaque;
	}
	
	/**
	 * Imprime la lista que contiene los ataques.
	 */
	public void imprimirListaAtaques() {
		Iterator<Ataque> itr = this.getIterador();
		Ataque unAtaque = null;
		while (itr.hasNext()) {
			unAtaque = itr.next();
			unAtaque.imprimirAtaque();
		}
	}

	public int getTamano() {

		return this.lista.size();
	}

	/**
	 * @param pNombreA
	 * @return devuelve el ataque al que se le ha asignado un nombre.
	 */
	public boolean estaNombre(String pNombreA) {
		Iterator<Ataque> itr = this.getIterador();
		Ataque unAtaque = null;
		boolean encontrado = false;
		while (itr.hasNext() && !encontrado) {
			unAtaque = itr.next();
			if (unAtaque.getNombre() == pNombreA) {
				return true;
			}
		}
		return false;
	}
}
