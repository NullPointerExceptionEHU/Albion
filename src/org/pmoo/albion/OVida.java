package org.pmoo.albion;

public class OVida extends Objeto {
	// atributos
	private int vida;

	// constructora
	public OVida(String pNombre, String pDescripcion, int pVida) {
		super(InventarioJuego.getInventarioJuego().getListaObjetos()
				.getTamano() + 1, pNombre, pDescripcion);
		this.vida = pVida;
	}

	// getters y setters
	public int getVida() {
		return this.vida;
	}

	public void imprimir() {
		super.imprimir();
		if (this.getVida() > 0){
			System.out.println("El usuario ha recuperado " + this.getVida()
					+ " de vida");
		}else {
			System.out.println("El usuario ha perdido " + Math.abs(this.getVida())
					+ " de vida");
		}
		
	}
}