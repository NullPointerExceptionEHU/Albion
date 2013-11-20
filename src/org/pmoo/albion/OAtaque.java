package org.pmoo.albion;

public class OAtaque extends Objeto {
	// atributos
	private Ataque ataque;

	// constructora
	public OAtaque(Ataque pAtaque, String pNombre, String pDescripcion) {
		super(InventarioJuego.getInventarioJuego().getListaObjetos()
				.getTamano() + 1, pNombre, pDescripcion);

		this.ataque = pAtaque;
	}

	// getters y setters
	public Ataque getAtaque() {
		return this.ataque;
	}

}
