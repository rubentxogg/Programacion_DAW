
/**
 * @author Rubentxo
 * Clase que se encarga del flujo del juego
 */
public class Juego {

	public Juego() {
		Tablero t = new Tablero();
		t.initGameBoard();
		t.showGameBoard();
		t.placeShips();
		t.showGameBoard();

	}
}
