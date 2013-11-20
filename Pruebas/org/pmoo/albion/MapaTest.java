package org.pmoo.albion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MapaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMapa() {
		assertNotNull(Mapa.getMapa());
	}

	@Test
	public void testGetDim() {
		assertEquals(25,Mapa.getMapa().getDim());
	}

	@Test
	public void testBuscarCasilla() {
		//Primer casilla (0,0) del mapa es * (piedra = true)
		System.out.println("Debe aparecer: *");
		Mapa.getMapa().buscarCasilla(0, 0).imprimir();
	}

	@Test
	public void testInicializarMapa() {
		
	}

	@Test
	public void testImprimirMapa() {
		System.out.println("\nEl mapa es:");
		System.out.println(" *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * ");
		System.out.println(" *  *  *        *                    *     o                             * ");
		System.out.println(" *     H        *                    *                                   * ");
		System.out.println(" *  *  *                             o  *  *                             * ");
		System.out.println(" *                                      *                                * ");
		System.out.println(" *        *  *  *  *  *  *              *                                * ");
		System.out.println(" *        *     o        *              *                                * ");
		System.out.println(" *        *              *              *                                * ");
		System.out.println(" *        *              *                                               * ");
		System.out.println(" *        *                                                              * ");
		System.out.println(" *        *                                   o                          * ");
		System.out.println(" *        *                                                              * ");
		System.out.println(" *     o  *                    *  *  *  *  *  *                    *  *  * ");
		System.out.println(" *  *  *  *                                   *  o                    o  * ");
		System.out.println(" *           L                 o              *  *                       * ");
		System.out.println(" *                                            *  o                       * ");
		System.out.println(" *                             *              *                          * ");
		System.out.println(" *     *                       *              *  B                       * ");
		System.out.println(" *  *  *  *  *  *              *              *  *                       * ");
		System.out.println(" *     *        o        *  *  *              *  *  *                    * ");
		System.out.println(" *  *  *                 *  o                 *  *  *  *                 * ");
		System.out.println(" *  o  *                                                           o     * ");
		System.out.println(" *                                               *                       * ");
		System.out.println(" *                                         o     *                       * ");
		System.out.println(" *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * ");
		System.out.println("El programa imprime: ");
		Mapa.getMapa().imprimirMapa();
	}

}
