import java.util.Arrays;
import java.util.Random;

/**
 * @author Rubentxo
 * Contiene los métodos relacionados con el tablero
 */
public class Tablero {
	
	// Objeto de la clase Random
	Random r = new Random();
	
	// Atributos
	private char[][] arrayChar;
	private int rand;
	private int pos;
	private boolean libre;

	/**
	 * Método que se encarga de crear el tablero vacío
	 */
	public void iniciarTablero() {
		System.out.println("Bienvenidx al juego\n");
		
		arrayChar = new char[Constantes.FILAS][Constantes.COLUMNAS];

		for(char[] x : arrayChar) {
			Arrays.fill(x, Constantes.MAR); // Lleno las filas con el caracter ~
		}
	}

	/**
	 * Método que nos imprime el tablero
	 */
	public void imprimirTablero() {
	
		char letter = 'A'; // Valor unicode 65
		System.out.print("\n\n    1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16");
		for(char[] x : arrayChar) {

			if(letter == 'A') {
				System.out.println("\n");
			}
			else {
				System.out.println("\n-");
			}

			System.out.print(letter+" | ");
			letter += 1;
			for(char y : x) {
				System.out.print(y+"   ");		
			}
		}
		System.out.println();
	}
	
	/**
	 * Método que colocará los siguientes barcos en el tablero: tres acorazados, dos destructores y tres fragatas.
	 * Se colocarán de manera aleatoria y en posición horizontal o vertical; también comprueba que estén libres las casillas.
	 */
	public void colocarBarcos(int tipoBarco) {
		
		switch(tipoBarco) {
				case Constantes.FRAGATA:
					 
					 arrayChar[r.nextInt(arrayChar.length)][r.nextInt(arrayChar.length)] = 'F';
					 break;
				
				case Constantes.DESTRUCTOR:
					
					 while(libre == false) {
						 rand = r.nextInt(14)+1;
						 
						 if(arrayChar[rand][rand] != Constantes.MAR || arrayChar[rand-1][rand] != Constantes.MAR ||  arrayChar[rand][rand+1] != Constantes.MAR) {
							 libre = false;
						 }
						 else {
							 libre = true;
							 arrayChar[rand][rand] = 'D';
							 posBarco(1);
						 }
					 }
					 libre = false;
					 break;
					 
				case Constantes.ACORAZADO:
					
					 while(libre == false) {
						 rand = r.nextInt(12)+2;
						 
						 if(arrayChar[rand][rand] != Constantes.MAR || arrayChar[rand-1][rand] != Constantes.MAR || arrayChar[rand-2][rand] != Constantes.MAR ||
							arrayChar[rand][rand+1] != Constantes.MAR || arrayChar[rand][rand+2] != Constantes.MAR) {
							 libre = false;
						 }
						 else {
							 libre = true;
							 arrayChar[rand][rand] = 'A';
							 posBarco();
						 }
					 }
					 libre = false;
					 break;		  
		}
	}
	
	/**
	 * @param destructor
	 * Coloca el destructor de forma horizontal o vertical de manera aleatoria
	 */
	public void posBarco(int destructor) {
		pos = r.nextInt(2);
		
		if(pos == 1) {
			arrayChar[rand-1][rand] = 'D'; // Vertical
		}
		else {
			arrayChar[rand][rand+1] = 'D'; // Horizontal
		}
	}
	
	/**
	 * Coloca el acorazado de forma horizontal o vertical de manera aleatoria
	 */
	public void posBarco() {
		pos = r.nextInt(2);
		
		if(pos == 1) {
			arrayChar[rand-1][rand] = 'A'; // Vertical
			arrayChar[rand-2][rand] = 'A'; 
		}
		else {
			arrayChar[rand][rand+1] = 'A'; // Horizontal
			arrayChar[rand][rand+2] = 'A'; 
		}
	}
	
}	




