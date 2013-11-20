package org.pmoo.albion;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaObjetos {
	// atributos
	private ArrayList<Objeto> lista;

	// constructora
	public ListaObjetos() {
		this.lista = new ArrayList<Objeto>();
	}

	// getters y setters
	private Iterator<Objeto> getIterador() {
		return this.lista.iterator();
	}

	public int getTamano() {
		return this.lista.size();
	}

	// otros metodos
	/**
	 * @param pObjeto
	 *            Se anade el objeto que se recibe como parametro a la lista de
	 *            objetos.
	 */

	public void anadirObjeto(Objeto pObjeto) {
		if (this.buscarObjetoPorId(pObjeto.getId()) == null) {
			this.lista.add(pObjeto);
		} else {
			System.out
					.println("Imposible anadir el objeto. El id ya esta en uso");
		}
	}

	public Objeto buscarObjetoPorId(int pId) {
		Iterator<Objeto> itr = this.getIterador();
		Objeto unObjeto = null;
		boolean encontrado = false;
		while (itr.hasNext() && !encontrado) {
			unObjeto = itr.next();
			if (unObjeto.getId() == pId) {
				encontrado = true;
			} else {
				unObjeto = null;
			}
		}
		return unObjeto;
	}

	/**
	 * @param pId
	 * @return Devuelve el objeto al que se le ha asignado el identificador como
	 *         parametro.
	 */
	public Objeto aleatorioObjetoPorPos() {
		 return this.lista.get((int) ((Math.random() * 1000) % (this.lista.size())));
	}

	/**
	 * @param pObjeto
	 *            Se elimina de la lista de objetos el objeto que se recibe como
	 *            parametro.
	 */
	public void eliminarObjeto(Objeto pObjeto) {
		this.lista.remove(pObjeto);
	}

	/**
	 * Se imprime la lista de objetos.
	 */
	public void imprimirListaObjetos() {
		System.out.println("La lista de objetos es:");
		Iterator<Objeto> itr = this.getIterador();
		Objeto unObjeto = null;
		while (itr.hasNext()) {
			unObjeto = itr.next();
			unObjeto.imprimir();
		}
	}
}