package calculos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	static Calculadora calc;
	
	@BeforeAll
	static void inicializar() {
		calc = new Calculadora();
	}
	
	@Test
	void testSuma() {
		int resultado = calc.suma(5, 5);
		assertEquals(10, resultado);
		assertNotNull(resultado);
	}

	@Test
	void testResta() {
		int resultado = calc.resta(10, 5);
		assertEquals(5, resultado);
		assertNotNull(resultado);
	}

	@Test
	void testMultiplica() {
		float resultado = calc.multiplica(5,6);
		assertEquals(30, resultado);
		assertNotNull(resultado);
	}

	@Test
	void testDivide() {
		float resultado = calc.divide(150,3);
		assertEquals(50, resultado);
	}
}
