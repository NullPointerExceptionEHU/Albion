package org.pmoo.albion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Juego {
	// atributos
	private Heroe miHeroe;

	private static Juego albion = new Juego();

	// constructora
	private Juego() {
		this.tituloJuego();
		System.out.print("Que nombre quieres darle al personaje que vas a controlar? ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String resp = sc.next();
		this.miHeroe = new Heroe(resp, 1750,
				"Fue caballero de la corte real durante muchos años, conoció a mucha gente importante y escuchó hablar sobre el tirano que atemorizaba a todo Albion, aunque no es muy fuerte, tiene una mentalidad y una estrategia comparable con la de los mejores luchadores de la historia.",
				"Harto de la tiranía de Dimitry Presnyakov, ha decidido armarse de valor y cruzar todo Albion en su busca.");
		this.imprimirHistoria();
	}

	// getters y setters
	/**
	 * Aqui se haran las llamadas a los metodos que sean necesarios para jugar
	 * una partida.
	 */
	public static Juego getJuego() {
		return albion;
	}

	public Heroe getHeroe() {
		return this.miHeroe;
	}

	//Otros metodos
	public void JugarPartida() {
		this.inicializarPartida();
		this.getHeroe().mover();
		if (this.getHeroe().estaVivo()) {
			System.out
					.println("¡Has ganado!, has demostrado ser lo suficientemente fuerte como para seguir adelante");
			System.exit(0);
		} else {
			System.out.println("Game Over");
		}
	}

	/**
	 * Se haran las llamadas a los metodos necesarios para que se inicialice la
	 * partida.
	 */
	private void inicializarPartida() {
		InventarioJuego.getInventarioJuego().iniInvent();
		Mapa.getMapa().imprimirMapa();
	}
	
	private void imprimirHistoria() {
		System.out.println("En la pequeña comarca de Zetuja, vive un caballero leal a la corte,\nbuen luchador y de gran corazón. Empezó a trabajar con su abuelo\nen la herrería y desde entonces está muy ligado a las armas.");
		this.pausar();
		System.out.println("Su padre, caballero también, le enseñó las artes de la lucha pero por desgracia,\nmurió a manos de Dimitry Presnyakov tras una gran batalla\nen la cual Dimitry consiguió salir con vida, tras muchos años, se le ha ocultado esta información a su hijo.");
		this.pausar();
		System.out.println("Recientemente, esta horrible noticia ha llegado al hijo engañado durante 27 años y,\nharto de las continuas demandas de Dimitry, lo deja todo\npara vengarse de su padre y poner fin a esta prolongada tiranía.");
		this.pausar();
	}

	private void pausar() {
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void tituloJuego() {
		File archivo = new File("Albion_Ascii.txt");
		try {
			Scanner lectura = new Scanner(archivo);
			while (lectura.hasNextLine()) {
				System.out.println(lectura.nextLine());
			}

			lectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo."
					+ archivo.getAbsolutePath());
		} catch (Exception e) {
			System.out
					.println("Ha ocurrido algún error al mostrar el archivo.");
		}
	}

}