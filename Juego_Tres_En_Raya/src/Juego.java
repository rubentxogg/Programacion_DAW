
/**
 * @author Rubentxo
 * Esta clase tendrá un único método contructor que se ocupará del flujo del juego
 */
public class Juego {
	
	// Método constructor que se ocupa del flujo del juego
	public Juego(){
		Tablero t = new Tablero();
		t.iniciaTablero();
		t.imprimeTablero();

		while(true) {
			t.actualizaTablero();
			t.imprimeTablero();
			t.chequeaGanador();
			t.cambiaJugador();
			t.tableroLLeno();
		}
	}
}
