package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import excepciones.MatrizException;
import principal.LanzarAccion;

class LanzarAccionTest {
	static LanzarAccion lanzarAccion;
	static Scanner sc;
	
	// Objetos para probar excepciones
	static LanzarAccion excRellenarMatriz;
	static LanzarAccion excRecuperarValorEntrada;
	
	@BeforeAll
	static void testLanzarAccion() {
		lanzarAccion = new LanzarAccion();
		lanzarAccion.inicializarAcciones();
		sc = lanzarAccion.getScanner();
		
		excRellenarMatriz = new LanzarAccion();
		excRellenarMatriz.inicializarAcciones();
		excRecuperarValorEntrada = new LanzarAccion();
		excRecuperarValorEntrada.inicializarAcciones();
	}

	@Test
	void testInicializarAcciones() {
		assertSame(sc, lanzarAccion.getScanner());
	}

	@Test
	@DisplayName("testRecuperarValorEntrada() -> Valor 5")
	void testRecuperarValorEntrada() throws MatrizException {
		assertEquals(5, lanzarAccion.recuperarValorEntrada());
	}

	@Test
	@DisplayName("excepcionRecuperarValorEntrada() -> Un carácter")
	void excepcionRecuperarValorEntrada() {
		Exception exc = assertThrows(MatrizException.class, () -> excRecuperarValorEntrada.recuperarValorEntrada());
		assertEquals("El valor introducido no es del tipo correcto", exc.getMessage());
	}
	
	@AfterAll 
	static void testTerminar() {
		lanzarAccion.terminar();
	}

	@Test
	void testRellenarMatriz() {
		assertEquals("matriz rellena", lanzarAccion.rellenarMatriz());
	}
	
	@Test
	@DisplayName("excepcionRellenarMatriz() -> Un carácter")
	void excepcionRellenarMatriz() {
		Exception exc = assertThrows(MatrizException.class, () -> excRellenarMatriz.recuperarValorEntrada());
		assertEquals(exc.getMessage()+" la matriz no se ha rellenado.", excRellenarMatriz.rellenarMatriz());
	}

	@Test
	@DisplayName("testSumarDatosFila() -> Valor 2 en la fila 4")
	void testSumarDatosFila() {
		lanzarAccion.rellenarMatriz();
		assertEquals("La suma de los valores de la fila " + 4 + " es: " + 8, lanzarAccion.sumarDatosFila());
	}

	@Test
	@DisplayName("testSumarDatosColumna() -> Valor 1 en la columna 1")
	void testSumarDatosColumna() {
		lanzarAccion.rellenarMatriz(); // Introducir el valor 1 en la columna uno
		assertEquals("La suma de los valores de la columna " + 1 + " es: " + 4, lanzarAccion.sumarDatosColumna());
	}

	@Test
	@DisplayName("testCalcularMediaValores() -> Solo valor 5")
	void testCalcularMediaValores() {
		lanzarAccion.rellenarMatriz(); // Introducir solamente el 5 como valor
		assertEquals("La media de los valores de la " + "matriz es de " + 5.0, lanzarAccion.calcularMediaValores());
	}

	@Test
	@DisplayName("testRecuperarCeldaMatriz() -> Valor 9 en fila 2, columna 3")
	void testRecuperarCeldaMatriz() {
		lanzarAccion.rellenarMatriz(); // Introducir el valor 9 en la fila dos, columna tres
		assertEquals("El valor almacenado en la fila " + 2 + " columna " + 3 + "es " + 9, lanzarAccion.recuperarCeldaMatriz());
	}

}
