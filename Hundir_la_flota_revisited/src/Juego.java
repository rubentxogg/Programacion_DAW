
/**
 * @author Rubentxo
 * Clase que se encarga del flujo del juego
 * 
 * -Para introducir m�s o menos n�mero de barcos basta con a�adirlo con su m�todo correspondiente
 * 
 * { PARA INICIAR EL MODO DEPURACI�N, INTRODUCIR EL ARGUMENTO: -debug }
 */
public class Juego {
	Tablero t = new Tablero();
	
	// M�todo constructor de la clase
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
				t.disparar(Tablero.debug); // Disparar en modo depuraci�n (tablero descubierto)
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
