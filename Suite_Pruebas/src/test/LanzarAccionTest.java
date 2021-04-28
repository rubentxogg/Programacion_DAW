package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.MatrizException;
import principal.LanzarAccion;

class LanzarAccionTest {
	static LanzarAccion lanzarAccion;
	static Scanner sc;
	
	@BeforeAll
	static void testLanzarAccion() {
		lanzarAccion = new LanzarAccion();
		lanzarAccion.inicializarAcciones();
		sc = lanzarAccion.getScanner();
	}

	@Test
	void testInicializarAcciones() {
		assertSame(sc, lanzarAccion.getScanner());
	}

	@Test
	void testRecuperarValorEntrada() throws MatrizException {
		System.out.print("[testRecuperarValorEntrada] Introduce valor de entrada v�lido: ");
		assertEquals(5, lanzarAccion.recuperarValorEntrada()); // Introducir 5 como valor de entrada
	}

	@Test
	void excepcionRecuperarValorEntrada() {
		System.out.print("[excepcionRecuperarValorEntrada] Introduce un valor de entrada inv�lido: "); // Introducir un car�cter
		Exception exc = assertThrows(MatrizException.class, () -> lanzarAccion.recuperarValorEntrada()); 
		assertEquals("El valor introducido no es del tipo correcto", exc.getMessage());
	}
	
	@AfterAll
	static void testTerminar() {
		lanzarAccion.terminar();
	}

	@Test
	void testRellenarMatriz() {
		System.out.println("[testRellenarMatriz] Rellena la matriz correctamente.");
		assertEquals("matriz rellena", lanzarAccion.rellenarMatriz());
	}
	
	@Test
	void excepcionRellenarMatriz() {
		System.out.println("[excepcionRellenarMatriz] Introduce un valor inv�lido."); // Introducir un car�cter
		Exception exc = assertThrows(MatrizException.class, () -> lanzarAccion.recuperarValorEntrada());
		assertEquals(exc.getMessage()+" la matriz no se ha rellenado.", lanzarAccion.rellenarMatriz());
	}


	@Test
	void testSumarDatosFila() {
		fail("Not yet implemented");
	}

	@Test
	void testSumarDatosColumna() {
		fail("Not yet implemented");
	}

	@Test
	void testCalcularMediaValores() {
		fail("Not yet implemented");
	}

	@Test
	void testRecuperarCeldaMatriz() {
		fail("Not yet implemented");
	}

}
