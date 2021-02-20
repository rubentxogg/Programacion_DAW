
/**
 * @author Rubentxo
 *	Contiene las constantes que usaremos en el programa
 */
public class Constantes {
	
	// Tablero
	public static final int FILAS = 16;
	public static final int COLUMNAS = 16;
	
	// Barcos
	public static final int ACORAZADO = 3; // Ocupa 3 casillas
	public static final int DESTRUCTOR = 2; // Ocupa  2 casillas
	public static final int FRAGATA = 1; // Ocupa 1 casilla
	public static final int NUM_BLANCOS = Tablero.contBlancos; // Guarda el número de disparos acertados en el juego
	
	// Eventos
	public static final int OPORTUNIDADES = 10;
	public static final char MAR = '~';
	public static final char AGUA = 'O';
	public static final char TOCADO = 'X';
}
