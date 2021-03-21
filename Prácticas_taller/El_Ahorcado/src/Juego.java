
/**
 * @author Rubén García
 * Clase que contiene el flujo del juego
 */
public class Juego {
	
	/**
	 * Constructor de la clase Juego
	 */
	public Juego(){
		Tablero t = new Tablero();
		t.iniciarTablero();
		t.imprimirTablero();
		
		while(true) {
			t.iniciarTurno();
			t.comprobarEleccion();
			t.imprimirTablero();
		}
	}
}
