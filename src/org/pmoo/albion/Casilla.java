package org.pmoo.albion;

import java.io.IOException;

public class Casilla{
	//atributos
	private boolean llave;
	private boolean boss;
	private boolean piedra;
	private boolean objeto;
	
	public Casilla() {
	}

	//getters y setters
	/**
	 * devuelve si esta o no la llave
	 * @return
	 */
	private boolean getLlave() {
		return llave;
	}


	private void setLlave(boolean pLlave) {
		llave = pLlave;
	}

	/**
	 * devuelve si hay o no Boss
	 * @return
	 */
	private boolean getBoss() {
		return boss;
	}


	private void setBoss(boolean pBoss) {
		boss = pBoss;
	}

	/**
	 * devuelve si hay Piedra o no
	 * @return
	 */
	private boolean getPiedra() {
		return piedra;
	}


	private void setPiedra(boolean pPiedra) {
		piedra = pPiedra;
	}


	/**
	 * devuelve si hay Objeto o no
	 * @return
	 */
	private boolean getObjeto() {
		return objeto;
	}


	private void setObjeto(boolean pObjeto) {
		objeto = pObjeto;
	}
	
	//otros metodos
	/**
	 * Inicializa los valores booleanos que hay en la casilla.
	 */
	public void inicializarCasilla(char pCondicion){
		if(pCondicion == ('*')){
			this.setPiedra(true);
		}else if(pCondicion == ('B')){
			this.setBoss(true);
		}else if(pCondicion == ('L')){
			this.setLlave(true);
		}else if(pCondicion == ('o')){
			this.setObjeto(true);
		}
	}
	/**
	 * @return Comprobamos con un booleano si en la siguiente casilla hay un obstaculo.
	 */
	public boolean comprobarObstaculo(){
		if (this.getPiedra()){
			System.out.println("No puedes moverte!, hay una piedra.");
			this.pausar();
			return true;
		}else if(this.getBoss() && !Juego.getJuego().getHeroe().getLlave()){
			System.out.println("No puedes pasar, las puertas de la guarida están cerradas.");
			this.pausar();
			return true;
		}
		return false;
	}
	
	private void pausar() {
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return devolvera Personaje o Null dependiendo de si en la casilla en la que vamos a caer
	 * hay un personaje o no.
	 */
	public Personaje descubrirPersonaje(){
		int probBich = 5;// indice de probabilidad de que aparezca un bicho
		if(this.getBoss()){
			this.setBoss(false);
			return new Boss();
		}else{
			int x = (int)(Math.random()*100); //Entre 0 y 100
			if(x < probBich){
				return new Bicho((((int) (Math.random() * 1000)) % 5));
			}
		}
		return null;
	}
	
	/**
	 * @return devolvera Objeto o Null dependiendo de si en la casilla en la que vamos a caer hay un
	 * objeto o no.
	 */
	public Objeto descubrirObjeto(){
		if(this.getObjeto()){
			this.setObjeto(false);
			return InventarioJuego.getInventarioJuego().getListaObjetos().aleatorioObjetoPorPos();
		}else if(this.getLlave()){
			this.setLlave(false);
			return new OLlave();
		}
		return null;
	}
	
	/**
	 * Imprime la casilla
	 */
	public void imprimir(){
		if (this.getPiedra()){
			System.out.print(" * ");
		} else if (this.getObjeto()){
			System.out.print(" o ");
		} else if (this.getBoss()){
			System.out.print(" B ");
		} else if (this.getLlave()){
			System.out.print(" L ");
		}else{
			System.out.print("   ");
		}
	}
}