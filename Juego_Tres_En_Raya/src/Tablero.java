import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubentxo
 * Esta clase se ocupará de todas las operaciones relacionadas con el tablero
 */
public class Tablero {
	
	// Atributos
	private char jugadorActual; // Representa al jugador 'x' u 'o'
	private char[][] arrayChar;
	private int filas = 3, columnas = 3;
	private boolean ganador = false; // Me servirá más tarde para el método tableroLleno()
	
	// Método que inicializa el tablero (lo usaremos en el método constructor de la clase Juego)
	public void iniciaTablero() {
		Scanner start = new Scanner(System.in);
		System.out.println("\t\t\t<------ Tres en raya ------>"
				+ "\nCada jugador solo debe colocar su símbolo una vez por turno y no debe ser sobre una casilla ya jugada."
				+ "\nSe debe conseguir realizar una línea recta o diagonal por símbolo."
				+ "\n¿Preparado/a? Pulsa enter para comenzar:");
		start.nextLine();
				
		arrayChar = new char[filas][columnas];
		for(int i=0;i<arrayChar.length;i++) {
			Arrays.fill(arrayChar[i], '-'); // Llena cada fila con el caracter '-'
		}
		jugadorActual = 'X';
	}
	
	// Método que imprimirá por consola el tablero
	public void imprimeTablero() {
		int cont = 0; // Creo un contador para indicar la fila
		System.out.print("\n    1     2     3");
		for(char[] x : arrayChar) {
			cont += 1; // Por cada fila suma 1, logrando representar el número de fila
			System.out.println("\n  -----------------");
			System.out.print(cont+" ");
			for(char y : x) {
				System.out.print("| "+y+" | ");
			}
		}
		System.out.println("\n  -----------------");
	}
	
	// Método que pedirá una posición al usuario y validará o invalidará su movimiento
	public void actualizaTablero() {
		int updFila, updColumna;
		boolean movimiento = false;
		Scanner sc = new Scanner(System.in);
		
		while(movimiento == false) {
			System.out.print("\nJugador "+jugadorActual+", introduzca una fila: ");
			updFila = sc.nextInt();
			updFila -= 1; // Restamos -1 a la fila para que funcionen los índices establecidos
			if(updFila > 2 | updFila < 0 ) {
				System.out.println("\nLa fila seleccionada está fuera del rango del tablero, pulse [ENTER] para volver a intentarlo.");
				sc.nextLine();
				sc.nextLine();
				imprimeTablero();
				continue;
			}
			
			System.out.print("Jugador "+jugadorActual+", introduzca una columna: ");
			updColumna = sc.nextInt();
			updColumna -= 1; // Restamos -1 a la columna elegida para que funcionen los índices establecidos
			if(updColumna > 2 | updColumna < 0 ) {
				System.out.println("\nLa columna seleccionada está fuera del rango del tablero, pulse [ENTER] para volver a intentarlo.");
				sc.nextLine();
				sc.nextLine();
				imprimeTablero();
				continue;
			}
			
			if(arrayChar[updFila][updColumna] == 'X' || arrayChar[updFila][updColumna] == 'O') {
				System.out.println("\nLa fila seleccionada ya está ocupada, pulse [ENTER] para volver a intentarlo.");
				sc.nextLine();
				sc.nextLine();
				imprimeTablero();
				continue;
			}
			else {
				arrayChar[updFila][updColumna] = jugadorActual; 
				movimiento = true;
			}
		}
	}
	
	// Método que comprobará si existe un ganador en el juego, en el caso de haberlo devolverá true y en caso contrario false
	public void chequeaGanador() {
//		chequeaFilas();
//		if(ganador == true) {
//			System.exit(0);
//		}
//		
//		chequeaColumnas();
//		if(ganador == true) {
//			System.exit(0);
//		}
//		
//		chequeaDiagonales();
//		if(ganador == true) {
//			System.exit(0);
//		}
		
		if(chequeaFilas() == true || chequeaColumnas() == true || chequeaDiagonales() == true) {
			System.exit(0); // Terminamos el programa
		}
	}
	
	// Método que comprueba que haya tres en raya en las filas
	public boolean chequeaFilas() {
		
		if(arrayChar[0][0] == jugadorActual && arrayChar[0][1] == jugadorActual && arrayChar[0][2] == jugadorActual) {
			System.out.println("\n¡"+jugadorActual+" gana la partida por fila!");
			ganador = true;
			return ganador;
		}
		else if(arrayChar[1][0] == jugadorActual && arrayChar[1][1] == jugadorActual && arrayChar[1][2] == jugadorActual) {
			System.out.println("\n¡"+jugadorActual+" gana la partida por fila!");
			ganador = true;
			return ganador;
		}
		else if(arrayChar[2][0] == jugadorActual && arrayChar[2][1] == jugadorActual && arrayChar[2][2] == jugadorActual) {
			System.out.println("\n¡"+jugadorActual+" gana la partida por fila!");
			ganador = true;
			return ganador;
		}
		else {
			ganador = false;
			return ganador;
		}
	}
	
	// Método que comprueba que haya tres en raya en las columnas
	public boolean chequeaColumnas() {
		
		if(arrayChar[0][0] == jugadorActual && arrayChar[1][0] == jugadorActual && arrayChar[2][0] == jugadorActual) {
			System.out.println("\n¡"+jugadorActual+" gana la partida por columna!");
			ganador = true;
			return ganador;
		}
		else if(arrayChar[0][1] == jugadorActual && arrayChar[1][1] == jugadorActual && arrayChar[2][1] == jugadorActual) {
			System.out.println("\n¡"+jugadorActual+" gana la partida por columna!");
			ganador = true;
			return ganador;
		}
		else if(arrayChar[0][2] == jugadorActual && arrayChar[1][2] == jugadorActual && arrayChar[2][2] == jugadorActual) {
			System.out.println("\n¡"+jugadorActual+" gana la partida por columna!");
			ganador = true;
			return ganador;
		}
		else {
			ganador = false;
			return ganador;
		}
	}
	
	// Método que comprueba que haya tres en raya en las diagonales
	public boolean chequeaDiagonales() {
		if(arrayChar[0][0] == jugadorActual && arrayChar[1][1] == jugadorActual && arrayChar[2][2] == jugadorActual) {
			System.out.println("\n¡"+jugadorActual+" gana la partida por diagonal!");
			ganador = true;
			return ganador;
		}
		else if(arrayChar[0][2] == jugadorActual && arrayChar[1][1] == jugadorActual && arrayChar[2][0] == jugadorActual) {
			System.out.println("\n¡"+jugadorActual+" gana la partida por diagonal!");
			ganador = true;
			return ganador;
		}
		else {
			ganador = false;
			return ganador;
		}
	}
	
	// Método que recorre todas las casillas y comprueba que estén llenas
	public boolean tableroLLeno() {
		int cont = 0;
		for(int i=0;i<arrayChar.length;i++) {
			for(int j=0;j<arrayChar[i].length;j++) {
				if(arrayChar[i][j] != '-') {
					cont++;
				}
			}
		}
		
		if(cont == 9 && ganador == false) { // Si el contador ha llegado a 9 significa que todas las casillas están ocupadas, por lo tanto hay un empate
			System.out.println("\n¡Empate técnico!, todas las casillas han sido ocupadas.");
			System.exit(0); // Terminamos el programa
			return true;
		}
		else {
			return false;
		}
		
	}
	
	// Método que chequea cual es el jugador actual y lo cambia al opuesto
	public void cambiaJugador() {
		
		if(jugadorActual == 'X') {
			jugadorActual = 'O';
		}
		else {
			jugadorActual = 'X';
		}
	}
	
}
