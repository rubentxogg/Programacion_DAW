import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcatenarTest {

	@Test
	void testConcatenar() {
		String resultado = new Concatenar().concatenar("hola", "holi");
		assertEquals(resultado, "holaholi");
	}

}
