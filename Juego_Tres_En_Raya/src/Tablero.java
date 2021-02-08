import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubentxo
 * Esta clase se ocupar� de todas las operaciones relacionadas con el tablero
 */
public class Tablero {
	
	// Atributos
	private char jugadorActual;
	private char[][] arrayChar;
	private int filas = 3, columnas = 3;
	
	// M�todo constructor que inicializa el tablero
	public void iniciaTablero() {
		arrayChar = new char[filas][columnas];
		Arrays.fill(arrayChar,"-");
		jugadorActual = 'x';
	}
	
	// M�todo que imprimir� por consola el tablero
	public void imprimeTablero() {
		for(char[] x : arrayChar) {
			for(char y : x) {
				System.out.println(x);
			}
		}
	}
	
	// M�todo que pedir� una posici�n al usuario y validar� o invalidar� su movimiento
	public void actualizaTablero() {
		int updFila, updColumna;
		boolean movimiento = false;
		Scanner sc = new Scanner(System.in);
		
		while(movimiento == false) {
			System.out.print("Introduzca una fila: ");
			updFila = sc.nextInt();
			
			System.out.print("Introduzca una columna: ");
			updColumna = sc.nextInt();
			
			if(arrayChar[updFila][updColumna] == jugadorActual) {
				System.out.println("Ha seleccionado una posici�n inv�lida (posici�n elegida anteriormente), vuelva a intentarlo.");
			}
			else if(updFila > 3 || updFila < 0 || updColumna > 3 || updColumna < 0) {
				System.out.println("Ha seleccionado una posici�n inv�lida (fuera del rango del tablero), vuelva a intentarlo.");
			}
			else {
				movimiento = true;
			}
		}
	}
	
	// M�todo que comprobar� si existe un ganador en el juego, en el caso de haberlo devolver� true y en caso contrario false
	public void chequeaGanador() {
		chequeaFilas();
		chequeaColumnas();
		chequeaDiagonales();
	}
	
	// M�todo que comprueba que haya tres en raya en las filas
	public boolean chequeaFilas() {
		
		if(arrayChar[0][0] == jugadorActual && arrayChar[0][1] == jugadorActual && arrayChar[0][2] == jugadorActual) {
			return true;
		}
		else if(arrayChar[1][0] == jugadorActual && arrayChar[1][1] == jugadorActual && arrayChar[1][2] == jugadorActual) {
			return true;
		}
		else if(arrayChar[2][0] == jugadorActual && arrayChar[2][1] == jugadorActual && arrayChar[2][2] == jugadorActual) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// M�todo que comprueba que haya tres en raya en las columnas
	public boolean chequeaColumnas() {
		
		if(arrayChar[0][0] == jugadorActual && arrayChar[1][0] == jugadorActual && arrayChar[2][0] == jugadorActual) {
			return true;
		}
		else if(arrayChar[0][1] == jugadorActual && arrayChar[1][1] == jugadorActual && arrayChar[2][1] == jugadorActual) {
			return true;
		}
		else if(arrayChar[0][2] == jugadorActual && arrayChar[1][2] == jugadorActual && arrayChar[2][2] == jugadorActual) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// M�todo que comprueba que haya tres en raya en las diagonales
	public boolean chequeaDiagonales() {
		if(arrayChar[0][0] == jugadorActual && arrayChar[1][1] == jugadorActual && arrayChar[2][2] == jugadorActual) {
			return true;
		}
		else if(arrayChar[0][2] == jugadorActual && arrayChar[1][1] == jugadorActual && arrayChar[2][0] == jugadorActual) {
			return true;
		}
		else {
			return false;
		}
	}
}
