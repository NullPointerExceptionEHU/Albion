package org.pmoo.albion;

public class Boss extends Personaje
{
	//constructora
	public Boss(){
		super("Dimitry Presnyakov", 1400, "Es un temerario, asalta toda la región en busca de oro y no duda en matar a mujeres y niños para conseguirlo,\nse dice que derrotó a un dragón con sus propias manos.\nNadie se atreve a contradecirle. Muchos por miedo a estar en el bando contrario, se unen a él y se hacen llamar los Renegados.",
				"Su objetivo es asesinar a todo el que se cruce en mi camino.");
		this.setListaAtaques(new ListaAtaques());
		
		//Lista de ataques 
		this.getListaAtaques().anadirAtaque(new Ataque(1, "Llave karate", "Hace una llave al objetivo para causar daño", 75));
		this.getListaAtaques().anadirAtaque(new Ataque(2, "Combo breaker", "Ataca consecutivamente con puños y patadas al enemigo, como si fuera a romperlo", 100));
		this.getListaAtaques().anadirAtaque(new Ataque(3, "Golpe bajo", "Con tal de alzarse con la victoria, usa este ataque como estrategia sucia para acabar cuando antes con sus enemigos", 150));
		this.getListaAtaques().anadirAtaque(new Ataque(4, "Lanzazo", "Lanza la lanza que lleva consigo causando daño a sus enemigos", 70));
		this.getListaAtaques().anadirAtaque(new Ataque(5, "Puño de hierro", "Se concentra para hacer de su puño un ataque que es capaz de atravesar casi cualquier cosa", 85));
	}
	
	//otros metodos
	/**
	 * @param pAtaque
	 * Calcula el dano que recibe el boss.
	 */
	public void recibirDano(Ataque pAtaque)
	{
//		// al boss le hace menos daño del que marca el ataque y se redondea el dano que le hace la cantidad 0,6 puede variar
//		this.setVida(this.getVida()-Math.round(pAtaque.getDano()*0.6f));
////		this.setVida(this.getVida()-(pAtaque.getDano()));		int probCritico = 33; //Entre 0 y 100
		int probCritico = 15; //probabilidad de critico del heroe.
		double porcenAt = 1.55;
		int danoTotal;
		if((int)(Math.random()*100) < probCritico){
			danoTotal = pAtaque.getDano() + (int) (pAtaque.getDano()*porcenAt);
			this.setVida(this.getVida() - danoTotal);
			System.out.println("Fue un ataque crítico! " + this.getNombre() + " ha sufrido " + danoTotal + " de daño");
		} else{
			danoTotal = (int) ((pAtaque.getDano())*0.6f);
			this.setVida(this.getVida() - danoTotal);
			System.out.println(this.getNombre() + " ha sufrido " + danoTotal + " de daño");
		}
	}

	@Override
	public void imprimirInfo() {
		System.out.println("----------------------------------");
		System.out.println("Enemigo final: " + this.getNombre());
		System.out.println(this.getDescripcion());
		System.out.println(this.getObjetivo());
//		System.out.println("----------------------------------");
	}

	@Override
	public void imprimirVida() {
		System.out.println(this.getNombre() + ": " + this.getVida());
	}
}