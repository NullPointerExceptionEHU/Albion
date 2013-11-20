package org.pmoo.albion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mapa {
	// atributos
	private int dim = this.dimensionMapa(); 
	private Casilla matriz[][] = new Casilla[dim][dim];
	private static Mapa mapaJuego = new Mapa();

	// constructora
	private Mapa() {
		this.inicializarMapa();
	}

	// getters y setters
	public static Mapa getMapa() {
		return mapaJuego;
	}

	public int getDim() {
		return dim;
	}

	/**
	 * @param pPosX
	 * @param pPosY
	 * @return Devuelve la casilla que tiene de parametros pPosX y pPosY en la
	 *         matriz de i x j casillas.
	 */
	public Casilla buscarCasilla(int pPosX, int pPosY) {
		return this.matriz[pPosX][pPosY];
	}

	/**
	 * Usando el metodo de inicializarCasilla() lo aplicamos a una matriz de i x j
	 * casillas.
	 */
	public void inicializarMapa() {
		int i = 0;
		//Para piedras
		File archivo = new File("src/org/pmoo/albion/MapaAscii_1.txt");
		try {
			Scanner lectura = new Scanner(archivo);
			while (lectura.hasNextLine()) {
				String unaLinea = lectura.nextLine();
				for (int j = 0; j < dim; j++) {
					Casilla unaCasilla = new Casilla();
					unaCasilla.inicializarCasilla(unaLinea.charAt(j));
					if (unaLinea.charAt(j) == 'H'){
						Juego.getJuego().getHeroe().inicPos(i, j);
					}
					this.matriz[i][j] = unaCasilla;
				}
				i++;
				System.out.println("");
			}
			lectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo."+ archivo.getAbsolutePath());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			System.out.println("Ha ocurrido algún error al mostrar el archivo.");
		}
	}	
	/**
	 * Mete pLineas en blanco para simular el clear de una consola.
	 * @param pLineas
	 */
	public void limpiar(int pLineas) {
		for (int i=0; i<pLineas;i++)
		System.out.println();
		}
	
	/**
	 * Nos lee la primera linea del fichero que contiene al mapa.
	 * Nos saca la longitud de la primera linea para dimensionar el mapa.
	 * @return
	 */
	
	private int dimensionMapa() {
		File archivo = new File("src/org/pmoo/albion/MapaAscii_1.txt");
		int dim = 0;
		try {
			Scanner lectura = new Scanner(archivo);
			dim = lectura.nextLine().length();
			lectura.close();
		}catch (FileNotFoundException e){
			System.out.println("No se encuentra el archivo");
			e.getStackTrace();
		}return dim;
	}

	/**
	 * Imprime el Mapa
	 *  
	 */
	public void imprimirMapa() {
		this.limpiar(40);
		int i, j;
		for (i = 0; i < this.matriz.length; i++) {
			for (j = 0; j < this.matriz.length; j++) {
				if (i == Juego.getJuego().getHeroe().getPosX() && j == Juego.getJuego().getHeroe().getPosY()) {
					System.out.print(" "+Juego.getJuego().getHeroe().getNombre().charAt(0)+" ");
				}else {
					this.matriz[i][j].imprimir();
				}
			}
			System.out.println();
		}
	}
}