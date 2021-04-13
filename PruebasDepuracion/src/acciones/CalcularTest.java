package acciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcularTest {

	@Test
	void testCalcular() {
		fail("Not yet implemented");
	}

	@Test
	void testQueHago() {
		String valorDevuelto = new Calcular().queHago("1");
		assertEquals("andando", valorDevuelto);
		
		String valorDevuelto2 = new Calcular().queHago("2");
		assertEquals("en bicicleta", valorDevuelto2);
	}

}
