
/**
 * @author Rubentxo
 * Clase que se encarga del flujo del juego
 */
public class Juego {

	public Juego() {
		Tablero t = new Tablero();
		t.iniciarTablero();
		t.colocarBarcos(Constantes.FRAGATA);
		t.colocarBarcos(Constantes.FRAGATA);
		t.colocarBarcos(Constantes.FRAGATA);
		t.colocarBarcos(Constantes.ACORAZADO);
		t.colocarBarcos(Constantes.ACORAZADO);
		t.colocarBarcos(Constantes.ACORAZADO);
		t.colocarBarcos(Constantes.DESTRUCTOR);
		t.colocarBarcos(Constantes.DESTRUCTOR);
		t.imprimirTablero();
		t.disparar();
	}
}
