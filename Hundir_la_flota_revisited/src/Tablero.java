import java.util.Arrays;

/**
 * @author Rubentxo
 * Contiene los m�todos relacionados con el tablero
 */
public class Tablero {
	
	// Atributos
	private char[][] arrayChar;

	/**
	 * M�todo que se encarga de crear el tablero vac�o
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
