
/**
 * @author Rubentxo
 * Esta clase tendr� un �nico m�todo contructor que se ocupar� del flujo del juego
 */
public class Juego {
	
	// M�todo constructor que se ocupa del flujo del juego
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
