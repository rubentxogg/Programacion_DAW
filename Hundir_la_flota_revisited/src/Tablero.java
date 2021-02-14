import java.util.Arrays;

/**
 * @author Rubentxo
 * Contiene los métodos relacionados con el tablero
 */
public class Tablero {
	
	// Atributos
	private char[][] arrayChar;

	/**
	 * Método que se encarga de crear el tablero vacío
	 */
	public void initGameGoard() {
		System.out.println("Bienvenidx al juego");
		
		arrayChar = new char[Constantes.ROWS][Constantes.COLUMNS];
		
		for(char[] x : arrayChar) {
			Arrays.fill(x, '~');
			System.out.println();
			for(char y : x) {
				System.out.print(x);
			}
		}
	}
}
