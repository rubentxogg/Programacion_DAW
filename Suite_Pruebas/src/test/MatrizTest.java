package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.MatrizException;
import main.matriz.Matriz;


class MatrizTest {
	
	static Matriz matriz;
	static int[][] matrizBase = {{2,2,2,2}, {2,2,2,2}, {2,2,2,2}, {2,2,2,2}};
	
	// Objetos para probar excepciones
	static Matriz exc1SumaFila;
	static Matriz exc2SumaFila;
	static Matriz exc1SumaColumna;
	static Matriz exc2SumaColumna;
	static Matriz exc1CalcularMedia;
	static Matriz exc1GetValorConcreto;
	static Matriz exc2GetValorConcreto;
	static Matriz exc3GetValorConcreto;
	
	@BeforeAll
	static void inicializarMatriz() {
		matriz = new Matriz();
		matriz.setMatriz(matrizBase);
		matriz.setMatrizRellena(true);
		
		// Objetos para probar excepciones
		exc1SumaFila = new Matriz();
		exc2SumaFila = new Matriz();
		exc2SumaFila.setMatrizRellena(true);
		exc1SumaColumna = new Matriz();
		exc1SumaColumna.setMatrizRellena(true);
		exc2SumaColumna = new Matriz();
		exc1CalcularMedia = new Matriz();
		exc1GetValorConcreto = new Matriz();
		exc2GetValorConcreto = new Matriz();
		exc2GetValorConcreto.setMatrizRellena(true);
		exc3GetValorConcreto = new Matriz();
		exc3GetValorConcreto.setMatrizRellena(true);
	}
	
	@Test
	void testSumaFila() throws MatrizException {
		assertEquals(8, matriz.sumaFila(1));
	}
	
	@Test
	void excepcion1SumaFila() throws MatrizException {
		Exception exc = assertThrows(MatrizException.class, () -> exc1SumaFila.sumaFila(3));
		assertEquals("La matriz no está inicializada", exc.getMessage());
	}
	
	@Test
	void excepcion2SumaFila() {
		Exception exc = assertThrows(MatrizException.class, () -> exc2SumaFila.sumaFila(5));
		assertEquals("No existe en la matriz la fila indicada", exc.getMessage());
	}

	@Test
	void testSumaColumna() throws MatrizException {
		assertEquals(8, matriz.sumaColumna(4));
	}
	
	@Test
	void excepcionSumaColumna1() throws MatrizException {
		Exception exc = assertThrows(MatrizException.class, () -> exc1SumaColumna.sumaColumna(5));
		assertEquals("No existe en la matriz la columna indicada", exc.getMessage());
	}
	
	@Test
	void excepcionSumaColumna2() throws MatrizException {
		Exception exc = assertThrows(MatrizException.class, () -> exc2SumaColumna.sumaColumna(5));
		assertEquals("La matriz no está inicializada", exc.getMessage());
	}

	@Test
	void testCalcularMedia() throws MatrizException {
		assertEquals(2, matriz.calcularMedia());
	}
	
	@Test
	void excepcion1CalcularMedia() throws MatrizException {
		Exception exc = assertThrows(MatrizException.class, () -> exc1CalcularMedia.calcularMedia());
		assertEquals("La matriz no está inicializada", exc.getMessage());
	}

	@Test
	void testIsMatrizRellenaTrue() {
		assertTrue(matriz.isMatrizRellena());
	}
	
	@Test
	void testIsMatrizRellenaFalse() {
		matriz.setMatrizRellena(false);
		assertFalse(matriz.isMatrizRellena());
		matriz.setMatrizRellena(true);
	}
	
	@Test
	void testGetValorConcreto() throws MatrizException {
		assertEquals(2, matriz.getValorConcreto(2, 2));
	}
	
	@Test
	void excepcion1testGetValorConcreto() throws MatrizException {
		Exception exc = assertThrows(MatrizException.class, () -> exc1GetValorConcreto.getValorConcreto(3, 3));
		assertEquals("La matriz no está inicializada", exc.getMessage());
	}
	
	@Test
	void excepcion2testGetValorConcreto() throws MatrizException {
		Exception exc = assertThrows(MatrizException.class, () -> exc2GetValorConcreto.getValorConcreto(6, 3));
		assertEquals("No existe en la matriz la fila indicada", exc.getMessage());
	}
	
	@Test
	void excepcion3testGetValorConcreto() throws MatrizException {
		Exception exc = assertThrows(MatrizException.class, () -> exc3GetValorConcreto.getValorConcreto(3, 6));
		assertEquals("No existe en la matriz la columna indicada", exc.getMessage());
	}
}
