
/**
 * @author Rubentxo
 * Clase que se encarga del flujo del juego
 * 
 * -Para introducir más o menos número de barcos basta con añadirlo con su método correspondiente
 * 
 * { PARA INICIAR EL MODO DEPURACIÓN, INTRODUCIR EL ARGUMENTO: -debug }
 */
public class Juego {
	Tablero t = new Tablero();
	
	// Método constructor de la clase
	public Juego(boolean debug) {
		
		if(debug == true) {
			t.iniciarTablero();
			t.colocarBarcos(Constantes.FRAGATA);
			t.colocarBarcos(Constantes.FRAGATA);
			t.colocarBarcos(Constantes.FRAGATA);
			t.colocarBarcos(Constantes.ACORAZADO);
			t.colocarBarcos(Constantes.ACORAZADO);
			t.colocarBarcos(Constantes.ACORAZADO);
			t.colocarBarcos(Constantes.DESTRUCTOR);
			t.colocarBarcos(Constantes.DESTRUCTOR);
			
			while(true) {
				t.disparar(Tablero.debug); // Disparar en modo depuración (tablero descubierto)
			}
		}
		else {
			t.iniciarTablero();
			t.colocarBarcos(Constantes.FRAGATA);
			t.colocarBarcos(Constantes.FRAGATA);
			t.colocarBarcos(Constantes.FRAGATA);
			t.colocarBarcos(Constantes.ACORAZADO);
			t.colocarBarcos(Constantes.ACORAZADO);
			t.colocarBarcos(Constantes.ACORAZADO);
			t.colocarBarcos(Constantes.DESTRUCTOR);
			t.colocarBarcos(Constantes.DESTRUCTOR);
			
			while(true) {
				t.disparar();
			}
		}
		
	}
}
