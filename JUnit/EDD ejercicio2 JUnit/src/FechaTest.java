import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FechaTest {

	@Test
	void testDevuelveFecha() {
		String resultado1 = new Fecha().devuelveFecha(1);
		
		assertEquals(resultado1, "2021/04");
		assertNotNull(resultado1);
		
		String resultado2 = new Fecha().devuelveFecha(2);
		assertEquals(resultado2, "04/2021");
		assertNotNull(resultado2);
		
		String resultado3 = new Fecha().devuelveFecha(3);
		assertEquals(resultado3, "04/21");
		assertNotNull(resultado3);
		
		String resultadoError = new Fecha().devuelveFecha(5);
		assertEquals(resultadoError, "ERROR");
		assertNotNull(resultadoError);
		
	}

}
