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
	public void initGameBoard() {
		System.out.println("Bienvenidx al juego\n");

		arrayChar = new char[Constantes.ROWS][Constantes.COLUMNS];

		for(char[] x : arrayChar) {
			Arrays.fill(x, '~'); // Lleno las filas con el caracter ~
		}
	}

	/**
	 * Método que nos imprime el tablero
	 */
	public void showGameBoard() {

		char letter = 'A'; // Valor unicode 65
		System.out.print("\n\n    1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16");
		for(char[] x : arrayChar) {

			if(letter == 'A') {
				System.out.println("\n");
			}
			else {
				System.out.println("\n-");
			}

			System.out.print(letter+" | ");
			letter += 1;
			for(char y : x) {
				System.out.print(y+"   ");		
			}
		}
		System.out.println();
	}

	/**
	 * Método que colocará los siguientes barcos en el tablero: tres acorazados, dos destructores y tres fragatas.
	 * Se colocarán de manera aleatoria y en posición horizontal o vertical
	 */
	public void placeShips() {
		
		
		
	}	
}



