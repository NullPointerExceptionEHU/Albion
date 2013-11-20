package org.pmoo.albion;

import java.io.IOException;
import java.util.Scanner;

public class Heroe extends Personaje {
	// atributos
	private int posX;
	private int posY;
	private boolean llave;
	private boolean bossDead;

	// constructora
	public Heroe(String pNombre, int pVida, String pDescripcion,
			String pObjetivo) {
		super(pNombre, pVida, pDescripcion, pObjetivo);
		this.setLlave(false);
		// Lista de ataques
		this.getListaAtaques().anadirAtaque(new Ataque(1, "Estrangular",
				"Atrapa al objetivo con ambas manos causando daño", 75));
		this.getListaAtaques()
				.anadirAtaque(new Ataque(
						2,
						"Espadamerang",
						"Lanza la espada como si de un boomerang se tratara golpeando al enemigo duramente. Después de golpear, la espada vuelve a la mano del Héroe",
						140));
		this.getListaAtaques()
				.anadirAtaque(new Ataque(
						3,
						"Patada salto",
						"una vez haber cogido velocidad, salta hacia su objetivo golpeándolo con una patada feroz",
						100));
		this.getListaAtaques().anadirAtaque(new Ataque(4, "Espada X",
				"Con dos cortes hace daño al enemigo", 125));
		this.getListaAtaques()
				.anadirAtaque(new Ataque(
						5,
						"Espada desenvainada",
						"Desenvaina su espada para dar un corte rápido a sus enemigos y luego volver a envainar su espada",
						85));
	}

	// getters y setters
	public int getPosX() {
		return posX;
	}

	private void setPosX(int pPosX) {
		this.posX = pPosX;
	}

	public int getPosY() {
		return posY;
	}

	private void setPosY(int pPosY) {
		this.posY = pPosY;
	}

	public boolean getLlave() {
		return llave;
	}

	public void setLlave(boolean pLlave) {
		this.llave = pLlave;
	}

	public void setVida(int pVida) {
		// Contanste vida heroe total 1750
		int maxVida = 1750;
		if (pVida > maxVida) {
			this.setVida(maxVida);
		} else {
			super.setVida(pVida);
		}
	}
	
	public boolean getBossDead() {
		return bossDead;
	}

	public void setBossDead(boolean pBossDead) {
		this.bossDead = pBossDead;
	}

	//Otros metodos
	
	public void inicPos(int pPosX, int pPosy) {
		this.setPosX(pPosX);
		this.setPosY(pPosy);
	}

	/**
	 * Dependiendo de la direcci�n en la que nos movamos sera necesario ver si
	 * en la siguiente casilla vamos a chocar contra un obstaculo. De chocar
	 * contra un obstaculo, se vuelve a preguntar que nos volvamos a mover. Si
	 * no chocamos contra un obstaculo, habra que ver si en al casilla en la que
	 * vamos a caer va a haber un bicho contra el cual tengamos que combatir o
	 * habra que ver si habra un objeto el cual cojamos.
	 */
	public void mover() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (this.estaVivo() && !this.getBossDead()) {
			Mapa.getMapa().imprimirMapa();
			System.out.print("Movimiento [w/s/a/d]: ");
			char mov = sc.next().toLowerCase().charAt(0);

			switch (mov) {
			case 'd': // Derecha
				if (!Mapa.getMapa().buscarCasilla(this.getPosX(), this.getPosY() + 1).comprobarObstaculo()) {
					this.setPosY(this.getPosY() + 1);
					//Mapa.getMapa().imprimirMapa();
					this.descubrirCasilla();

				}
				break;
			case 'w': // Arriba
				if (!Mapa.getMapa()
						.buscarCasilla(this.getPosX() - 1, this.getPosY())
						.comprobarObstaculo()) {
					this.setPosX(this.getPosX() - 1);
					//Mapa.getMapa().imprimirMapa();
					this.descubrirCasilla();

				}
				break;
			case 's': // Abajo
				if (!Mapa.getMapa()
						.buscarCasilla(this.getPosX() + 1, this.getPosY())
						.comprobarObstaculo()) {
					this.setPosX(this.getPosX() + 1);
					//Mapa.getMapa().imprimirMapa();
					this.descubrirCasilla();
				}
				break;
			case 'a': // Izquierda
				if (!Mapa.getMapa()
						.buscarCasilla(this.getPosX(), this.getPosY() - 1)
						.comprobarObstaculo()) {
					this.setPosY(this.getPosY() - 1);
					//Mapa.getMapa().imprimirMapa();
					this.descubrirCasilla();
				}
				break;
			default:
				System.out.println("Movimiento invalido");
			}
		}
	}

	/**
	 * @param pObjeto
	 *            Depende del objeto que cojamos, este tendra un efecto u otro
	 *            (OVida, OLlave, OAtaque).
	 */
	private void usarObjeto(Objeto pObjeto) {
		if (pObjeto != null) {
			if (pObjeto instanceof OLlave) {
				this.setLlave(true);
			} else if (pObjeto instanceof OVida) {
				// no estoy seguro si se accede asi a la vida del objeto OVida
				this.setVida(this.getVida() + ((OVida) pObjeto).getVida());
				System.out.print("Has conseguido un objeto: ");
			} else if (pObjeto instanceof OAtaque) {
//				this.getListaAtaques().anadirAtaque(
//						((OAtaque) pObjeto).getAtaque());
				Ataque unAtaque = ((OAtaque) pObjeto).getAtaque();
				// Hacer excepcion
				if (!this.getListaAtaques().estaNombre(unAtaque.getNombre())) {
					unAtaque = new Ataque(
							this.getListaAtaques().getTamano() + 1,
							unAtaque.getNombre(), unAtaque.getDescripcion(),
							unAtaque.getDano());
					this.getListaAtaques().anadirAtaque(unAtaque);
					System.out.print("Has conseguido un objeto: ");
				} else {
					System.out.print("Ya has obtenido: ");
				}
			}
			pObjeto.imprimir();
			this.pausar();
		}
	}

	/**
	 * @param pId
	 *            Se elegira aquel Ataque que tenga como parametro su id.
	 */
	@Override
	protected int elegirAtaque() {
		int num = 0;
		boolean todoOk = false;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("----------------------------------");
			System.out.println("Elige un ataque de la lista [1-"
					+ this.getListaAtaques().getTamano() + "]:");
			this.getListaAtaques().imprimirListaAtaques();
			System.out.print("Opcion: ");
			// leemos num de teclado (scanner)
			try {
				num = Integer.parseInt(sc.next());
				// System.out.println("\n");
				if (num >= 1 && num <= this.getListaAtaques().getTamano()) {
					todoOk = true;
				} else {
					throw new AtaqueNoEncontradoException();
				}
			} catch (NumberFormatException e) {
				System.out.println("Introduzca un numero");
			} catch (AtaqueNoEncontradoException e) {
				System.out.println(e.getMessage());
			}
		} while (!todoOk);
		// miramos si el numero leido por teclado se encuentra dentro del rango
		// posible. Sino volvemos a leer

		// System.out.println("Has elegido el ataque: ");
		// this.miListaAtaques.buscarAtaquePorId(num).imprimirAtaque();
		return num;
	}

	/**
	 * Una vez saber si en la casilla en la que estamos hay un bicho, se
	 * iniciara un combate entre el Heroe y el Bicho. El Heroe tendra siempre el
	 * primer turno y tirara del metodo elegirAtaque() para escoger su ataque,
	 * mientras que el bicho tendra un random para escoger su Ataque.
	 */
	private void combate(Personaje pPersonaje) {
		Mapa.getMapa().limpiar(40);
		System.out.println("*************************************************");
		System.out.println("************  PREPARATE PARA LUCHAR  ************");
		System.out.println("*************************************************");
		this.imprimirInfo();
		pPersonaje.imprimirInfo();
		System.out.println("\n************ Registro de combate ************");
		do {
			Ataque unAtaque = null;
			unAtaque = this.getListaAtaques().buscarAtaquePorId(this
					.elegirAtaque());
			System.out.println(this.getNombre() + " ha utilizado "
					+ unAtaque.getNombre());
			pPersonaje.recibirDano(unAtaque);

			if (pPersonaje.estaVivo()) {
				unAtaque = pPersonaje.getListaAtaques()
						.buscarAtaquePorId(pPersonaje.elegirAtaque());
				System.out.println(pPersonaje.getNombre() + " ha utilizado "
						+ unAtaque.getNombre());
				this.recibirDano(unAtaque);
			}
			System.out.println("----------------------------------");
			this.imprimirVida();
			pPersonaje.imprimirVida();
		} while (this.estaVivo() && pPersonaje.estaVivo());
		System.out
				.println("**************************************************");
		System.out
				.println("*************   COMBATE FINALIZADO   *************");
		System.out
				.println("**************************************************");
		if (pPersonaje instanceof Boss && !pPersonaje.estaVivo()) {
			this.setBossDead(true);
		}
		this.pausar();
	}

	private void pausar() {
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * En este metodo se vera que es lo que hay en la casilla (Llave, piedra,
	 * boss y objeto)
	 */
	private void descubrirCasilla() {
		Casilla c = Mapa.getMapa()
				.buscarCasilla(this.getPosX(), this.getPosY());
		Personaje unPersonaje = c.descubrirPersonaje();
		if (unPersonaje != null) {
			this.combate(unPersonaje);
		}
		if (this.estaVivo()) { // Si no esta vivo no podra coger objeto
			Objeto unObjeto = c.descubrirObjeto();
			if (unObjeto != null) {
				this.usarObjeto(unObjeto);
			}
		}
	}

	public void imprimirInfo() {
		System.out.println("----------------------------------");
		System.out.println(this.getNombre() + ": " + this.getVida());
		System.out.println("Listo para atacar!");
	}

	@Override
	public void imprimirVida() {
		System.out.println(this.getNombre() + ": " + this.getVida());
	}
}
