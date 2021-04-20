import java.io.IOException;

public class P4 {
	
	public static void main(String[] args) {
		
		try {
			Numbers.imprimirNumero(Numbers.leerNumero());
		} catch(IOException ioe) {
			System.out.println("¡Error esquivado!");
		} finally {
			System.out.println("Programa finalizado.");
		}
		
	}
}
