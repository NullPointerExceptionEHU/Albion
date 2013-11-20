package org.pmoo.albion;

public class Bicho extends Personaje {
	private static String[] vNombres = { "Tux", "Salamandra", "Xperia",
			"Sazandora", "Erundur" };
	private static String[] vDescripcion = {
			"A este humilde pingüino no le gusta que se le moleste, suele andar todo el día por el Dock de Unity.",
			"Esta criatura suele arrastrarse por las rocas, tiene unas mandíbulas gigantes y ataca a todo ser que se aproxima.",
			"Me creó la compañía Sony para hacer teléfonos móviles, hubo un fallo en el sistema y creamos una serie de robots,\n que por un Multiplexor mal hecho, atacan a todo ser humano que se mueva.",
			"Gobierna los aires de Albion. Este dragón tiene a todos los seres humanos aterrorizados y no deja que ningún ser asome la cabeza.",
			"Es un enano muy pícaro que no duda en morderte y pisarte, se asemeja a un niño pequeño.\nSe caracterizan por no tener mucha inteligencia; aun así, pueden hacerte pasar un mal rato." };
	private static String[] vObjetivo = {
			"Gobernar todos los PCs del mundo.",
			"Gobernar las cuevas.",
			"Hacer que todos los Robots Xperia tengamos un hueco en el mundo.",
			"Es el primero de la cadena alimenticia y su fiereza es legendaria.",
			"Divertirse y jugar." };
	private static int[] vVida = { 325, 610, 520, 700, 250 };

	// constructora
	public Bicho(int pNum) {
		super(vNombres[pNum], vVida[pNum], vDescripcion[pNum], vObjetivo[pNum]);
		// Lista de ataques
		// Tux
		ListaAtaques la1 = new ListaAtaques();
		la1.anadirAtaque(new Ataque(1, "Picotazo",
				"Daña a su enemigo usando su pico.", 65));
		la1.anadirAtaque(new Ataque(
				2,
				"Casquete informático",
				"Coge una gran porción de lo primero que pilla por la red y se lo lanza a su objetivo",
				85));
		la1.anadirAtaque(new Ataque(3, "Aleteo",
				"Causa daño moviendo sus alas", 70));
		la1.anadirAtaque(new Ataque(
				4,
				"Virus",
				"Crea unos viruses los cuáles son lanzados a su objetivo causando daño",
				75));
		la1.anadirAtaque(new Ataque(5, "Sardina metálica",
				"Lanza una sardina que se ha encontrado en el mar informático",
				110));
		// Salamandra
		ListaAtaques la2 = new ListaAtaques();
		la2.anadirAtaque(new Ataque(1, "Triturar",
				"Clava su afilada dentadura en el objetivo causando así daño",
				85));
		la2.anadirAtaque(new Ataque(2, "Cola feroz",
				"Mueve con fuerza y agilidad su cola para hacer daño", 110));
		// Embestida recupera 1/3 hp TODO
		la2.anadirAtaque(new Ataque(3, "Embestida",
				"Se lanza hacia su enemigo derribándolo", 65));
		la2.anadirAtaque(new Ataque(4, "Colmillo venenoso",
				"Clava sus colmillos en su objetivo haciendo daño", 70));
		la2.anadirAtaque(new Ataque(5, "Garra brutal",
				"Ataca con sus garras a su objetivo causando daño", 85));
		// Xperia
		ListaAtaques la3 = new ListaAtaques();
		la3.anadirAtaque(new Ataque(
				1,
				"Grapar",
				"Cambia su mano a una grapadora para empezar a lanzar grapas con esta y así causar daño a su objetivo.",
				65));
		la3.anadirAtaque(new Ataque(
				2,
				"Misil Y8FN23",
				"Prepara este modelo de misil teledirigido que inflinge daño elevado una vez alcanza a su objetivo.",
				110));
		la3.anadirAtaque(new Ataque(3, "Puño extendible",
				"Extiende sus puños para intentar golpear a su enemigo.", 85));
		la3.anadirAtaque(new Ataque(4, "Patada extendible",
				"Extiende sus piernas para intentar patalear a su objetivo.",
				80));
		la3.anadirAtaque(new Ataque(
				5,
				"Mirada láser",
				"Una vez sus ojos se hayan fijado en su objetivo dispara un láser causando mucho daño.",
				75));
		// Sazandora
		ListaAtaques la4 = new ListaAtaques();
		la4.anadirAtaque(new Ataque(1, "Llamarada",
				"Escupe fuego por la boca abrasando a su objetivo.", 110));
		la4.anadirAtaque(new Ataque(
				2,
				"Caida dragon",
				"Desde las alturas se lanza en picado a su enemigo para causar daño.",
				85));
		la4.anadirAtaque(new Ataque(3, "Zarpazo",
				"Con sus garras inflinge daño a sus enemigos.", 75));
		la4.anadirAtaque(new Ataque(4, "Cola puntiaguda",
				"Hace daño a sus enemigos con su cola.", 65));
		la4.anadirAtaque(new Ataque(
				5,
				"Poder oculto",
				"Desata el poder que yace en su interior para inflingir daño a sus enemigos.",
				80));
		// Erundur
		ListaAtaques la5 = new ListaAtaques();
		la5.anadirAtaque(new Ataque(1, "Pisotón",
				"Patalea o pisotea a sus enemigos para causar daño.", 65));
		la5.anadirAtaque(new Ataque(2, "Mordisco",
				"Muerde con sus dientes para inflingir daño.", 60));
		la5.anadirAtaque(new Ataque(3, "Ira",
				"Acumula rabia y rencor para hacer mucho daño a su enemigo.",
				125));
		la5.anadirAtaque(new Ataque(4, "Latigazo",
				"Con el látigo que usa para saltar a la comba inflinge daño.",
				75));
		la5.anadirAtaque(new Ataque(
				5,
				"Golpe a dos manos",
				"Junta sus dos manos para golpear de arriba a abajo a sus enemigos.",
				80));

		ListaAtaques[] vListaAtaques = { la1, la2, la3, la4, la5 };
		this.setListaAtaques(vListaAtaques[pNum]);
	}

	public void imprimirInfo() {
		System.out.println("----------------------------------");
		System.out.println("Un enemigo aparecio: " + this.getNombre());
		System.out.println(this.getDescripcion());
		System.out.println(this.getObjetivo());
		// System.out.println("----------------------------------");
	}

	public void imprimirVida() {
		System.out.println(this.getNombre() + ": " + this.getVida());
	}
}
