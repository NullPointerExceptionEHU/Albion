package org.pmoo.albion;

public abstract class Personaje {
	// atributos
	private String nombre;
	private int vida;
	private String descripcion;
	private String objetivo;
	private ListaAtaques miListaAtaques;

	// constructora
	public Personaje(String pNombre, int pVida, String pDescripcion,
			String pObjetivo) {
		this.nombre = pNombre;
		this.vida = pVida;
		this.descripcion = pDescripcion;
		this.objetivo = pObjetivo;
		this.miListaAtaques = new ListaAtaques();
	}

	// getters y setters
	protected String getNombre() {
		return this.nombre;
	}

	protected int getVida() {
		return this.vida;
	}

	protected void setVida(int pVida) {
		if (pVida < 0) {
			this.vida = 0;
		} else {
			this.vida = pVida;
		}
	}

	protected String getDescripcion() {
		return this.descripcion;
	}

	protected String getObjetivo() {
		return this.objetivo;
	}

	protected ListaAtaques getListaAtaques() {
		return this.miListaAtaques;
	}
	
	protected void setListaAtaques(ListaAtaques pListaAtaques) {
		this.miListaAtaques = pListaAtaques;
	}

	// otros metodos
	/**
	 * @param pAtaque
	 *            El personaje recibe un Ataque como parametro y dependiendo del
	 *            Ataque que haya recibido calcula el daNo que este hace.
	 */
	// Calcula el dano que este hace? No seria calcula la vida que le queda al
	// que recibe el ataque??
	public void recibirDano(Ataque pAtaque) {
		int probCritico = 15; //Entre 0 y 100
		double porcenAt = 1.55;
		int danoTotalCrit = pAtaque.getDano() + (int) (pAtaque.getDano()*porcenAt);
		if((int)(Math.random()*100) <= probCritico){
			this.setVida(this.getVida() - danoTotalCrit);
			System.out.println("Fue un ataque crítico! " + this.getNombre() + " ha sufrido " + danoTotalCrit + " de daño");
		} else{
			this.setVida(this.getVida() - pAtaque.getDano());
			System.out.println(this.getNombre() + " ha sufrido " + pAtaque.getDano() + " de daño");
		}
	}

	/**
	 * @return Devuelve un entero que sera el identificador del Ataque escogido.
	 */
	protected int elegirAtaque() {
		return (((int) (Math.random() * 1000)) % this.miListaAtaques
				.getTamano()) + 1;
	}

	/**
	 * @return Este metodo devolvera True o False dependiendo de si el personaje
	 *         esta vivo o no.
	 */
	public boolean estaVivo() {
		return this.getVida() > 0;
	}

	public abstract void imprimirInfo();

	public abstract void imprimirVida();
}
