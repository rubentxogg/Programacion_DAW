
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
		t.validarPalabra(Tablero.palabra);
		t.imprimirTablero();
		t.iniciarTurno();
		t.validarPalabra(Tablero.eleccion);
		t.comprobarEleccion();
		t.imprimirTablero();
	}
}
