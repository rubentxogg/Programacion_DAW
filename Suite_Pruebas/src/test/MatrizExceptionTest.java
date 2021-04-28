package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.MatrizException;

class MatrizExceptionTest {
	
	static MatrizException me1;
	static MatrizException me2;
	static MatrizException me3;
	static MatrizException me4;
	static MatrizException meDefault;
	
	@BeforeAll
	static void inicializarMatrizExcepcion() {
		me1 = new MatrizException(1);
		me2 = new MatrizException(2);
		me3 = new MatrizException(3);
		me4 = new MatrizException(4);
		meDefault = new MatrizException(0);
	}
	
	@Test
	void testGetMessage1() {
		assertEquals("La matriz no está inicializada", me1.getMessage());
	}
	
	@Test
	void testGetMessage2() {
		assertEquals("No existe en la matriz la fila indicada", me2.getMessage());
	}
	
	@Test
	void testGetMessage3() {
		assertEquals("No existe en la matriz la columna indicada", me3.getMessage());
	}
	
	@Test
	void testGetMessage4() {
		assertEquals("El valor introducido no es del tipo correcto", me4.getMessage());
	}
	
	@Test
	void testGetMessageDefault() {
		assertEquals("Se desconoce la causa del error", meDefault.getMessage());
	}


}
