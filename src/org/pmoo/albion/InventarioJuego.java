package org.pmoo.albion;

public class InventarioJuego {
	// atributos
	private ListaObjetos lista;

	private static InventarioJuego inventario = new InventarioJuego();

	// constructora
	private InventarioJuego() {
		// Inicializamos la lista de objetos
		this.lista = new ListaObjetos();
	}

	// getters y setters
	public static InventarioJuego getInventarioJuego() {
		return inventario;
	}

	public ListaObjetos getListaObjetos() {
		return this.lista;
	}

	public void iniInvent() {
		// Vida máxima del heroe
		int maxVida = Juego.getJuego().getHeroe().getVida();
		// Objetos +vida
		this.lista.anadirObjeto(new OVida("Donettes",
				"Recupera 1/20 de la vida total", maxVida / 20));
		this.lista.anadirObjeto(new OVida("Coca cola",
				"Recupera 1/5 de la vida total", maxVida / 5));
		this.lista.anadirObjeto(new OVida("Pipas",
				"Recupera 2/5 de la vida total", maxVida * 2 / 5));
		this.lista.anadirObjeto(new OVida("Agua fresca",
				"Recupera la mitad de la vida total", maxVida / 2));
		this.lista.anadirObjeto(new OVida("Cafe",
				"Recupera 3/4 de la vida total", maxVida * 3 / 4));
		this.lista.anadirObjeto(new OVida("Pizza", "Recupera toda la vida",
				maxVida));
		// Objetos -vida
		this.lista.anadirObjeto(new OVida("Bomba",
				"Quita 1/5 de la vida total", -maxVida / 5));
		this.lista.anadirObjeto(new OVida("Sandwiches",
				"Quitan 1/10 de la vida total", -maxVida / 10));
		this.lista.anadirObjeto(new OVida("Máquina expendedora tragamonedas",
				"Quita 1/3 de la vida total (daño moral)", (int) Math
						.round(-maxVida / 3)));
		// Objetos ataque
				this.lista
						.anadirObjeto(new OAtaque(new Ataque(1,
						"Espada sagrada",
						"Esta espada es capaz de cortar a través de todo", 250),
						"Fortificador de espada",
						"Cuando encuentres este item tu espada recibirá una mejora."));
				this.lista
						.anadirObjeto(new OAtaque(
								new Ataque(1,
										"Patada voladora",
										"Después de haber cogido velocidad, salta para dar una patada con todo su poder",
										230), "Cinturón negro",
								"Enseña el ataque Patada Voladora."));
				this.lista
						.anadirObjeto(new OAtaque(
								new Ataque(1,
										"Concentración psíquica",
										"Se concentra para controlar al enemigo y hacer que se golpee con cualquier cosa",
										230), "Libro de conjuros",
								"Enseña el ataque Concentración psíquica."));
				this.lista
						.anadirObjeto(new OAtaque(
								new Ataque(1,
										"Escupefuego",
										"Después de haber bebido algo de alcohol escupe fuego a través de una antorcha para abrasar a sus oponentes",
										233), "Alcohol y antorcha",
								"Enseña el ataque Escupefuego."));
	}
}
