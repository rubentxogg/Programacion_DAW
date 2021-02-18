import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
	private int vida;
	private int letraInt; // Variable que utilizaré para guardar el valor numérico de un char
	private int fila;
	private boolean hundidoDestrucor;
	private boolean hundidoAcorazado;
	static int contBlancos = 0; // Cada vez que se crea un barco incrementa su valor en 1
	private boolean ganar;
	private int contAcertados;

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
		System.out.print("\n\n   ·1  ·2  ·3  ·4  ·5  ·6  ·7  ·8  ·9  ·10 ·11 ·12 ·13 ·14 ·15 ·16");
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
					contBlancos++;
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
							contBlancos+=2;
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
							contBlancos+=3;
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
	
	/**
	 * Método que pide al usuario unas coordenadas donde quiera efectuar el disparo y dependiendo de lo que haya en la casilla disparada, 
	 * se mostrará el símbolo y mensaje correspondiente
	 */
	public void disparar() {
		Scanner sc = new Scanner(System.in);
		boolean disparo = false;
		char resultado;
		
		while(disparo == false) {
			System.out.println("\nIntroduzca las coordenadas del disparo.");
			System.out.print("\nFila (letra): ");
			char filaChar = sc.next().charAt(0); // Pedimos una letra (fila)
			charToInt(filaChar); // Convertimos esa letra a valor numérico y lo guardamos en la variable letraInt. Ej: A = 10 --> letraInt = 10
			charAfila(letraInt); // Convertimos el valor numérico al correspondiente de la fila y lo guardamos en la variable fila. Ej: 10 = 1 --> fila = 1
			if(fila < 0 || fila > 15) {
				System.out.println("\nHa introducido una entrada no válida, pulse [Enter] para volver a intentarlo.");
				pulsaEnter(); // Pide al usuario que presione la tecla enter
				continue;
			}
			
			System.out.print("Columna (nº): ");
			int columna = sc.nextInt();
			columna -= 1;
			if(columna < 0 || columna > 15) {
				System.out.println("\nLa columna introducida está fuera de rango, pulse [Enter] para volver a intentarlo.");
				pulsaEnter();
				continue;
			}
			else {
				disparo = true;
				resultado = arrayChar[fila][columna];
			}
			
			switch(resultado) {
				case Constantes.MAR:
					arrayChar[fila][columna] = Constantes.AGUA;
					imprimirTablero();
					vida++;
					if(vida == Constantes.OPORTUNIDADES) {
						System.out.println("Has perdido, se han agotado las oportunidades.");
						System.exit(0);
					}
					else {
						System.out.println("\n¡Fallaste!");
						int oportRestantes = Constantes.OPORTUNIDADES; // Variable para mostrar las oportunidades restantes del jugador
						System.out.println("\n---------------------------------");
						System.out.print("| Oportunidades restantes: "+(oportRestantes-vida)+".   |");
						System.out.println("\n| Pulse [Enter] para continuar. |");
						System.out.println("---------------------------------");
						pulsaEnter();
					}
					break;
				
				case 'A': // Acorazado
					arrayChar[fila][columna] = Constantes.TOCADO;
					imprimirTablero();
					contAcertados++;
					ganar();
					
					System.out.println("\n---------------------------------------------------");
					System.out.println("| ¡Blanco! Has acertado en un acorazado. [Enter]  |");
					System.out.println("---------------------------------------------------");
					pulsaEnter();
					break;
				
				case 'D': // Destructor
					arrayChar[fila][columna] = Constantes.TOCADO;
					imprimirTablero();
					contAcertados++;
					ganar();
					
					System.out.println("\n---------------------------------------------------");
					System.out.println("| ¡Blanco! Has acertado en un destructor. [Enter] |");
					System.out.println("---------------------------------------------------");
					
					pulsaEnter();
					break;
					
				case 'F': // Fragata
					arrayChar[fila][columna] = Constantes.TOCADO;
					imprimirTablero();
					contAcertados++;
					ganar();
					System.out.println("\n----------------------------------------------"); // Al ocupar solamente una casilla siempre que acertemos una fragata la hundiremos
					System.out.println("| ¡Blanco! Has hundido una fragata. [Enter]  |");
					System.out.println("----------------------------------------------");
					pulsaEnter();
					break;
			}
		}
	}
	
	/**
	 * Método que pide al usuario que presione la tecla enter para poder continuar
	 */
	public void pulsaEnter() {
		Scanner enter = new Scanner(System.in);
		enter.nextLine();
	}
	
	/**
	 * @param letra
	 * Método que convierte a int el caracter que le pasamos
	 */
	public void charToInt(char letra) {
		letraInt = Character.getNumericValue(letra);
	}
	
	/**
	 * @param convertirFila
	 * Método que convierte el valor numérico de un char al número de su fila correspondiente
	 */
	public void charAfila(int convertirFila) {
		switch(letraInt) {
			case 10: // A,a
				fila = 0;
				break;
				
			case 11: // B,b
				fila = 1;
				break;
				
			case 12: // C,c
				fila = 2;
				break;
			
			case 13: // D,d
				fila = 3;
				break;
			
			case 14: // E,e
				fila = 4;
				break;
				
			case 15: // F,f
				fila = 5;
				break;
				
			case 16: // G,g
				fila = 6;
				break;
				
			case 17: // H,h
				fila = 7;
				break;
				
			case 18: // I,i
				fila = 8;
				break;
				
			case 19: // J,j
				fila = 9;
				break;
				
			case 20: // K,k
				fila = 10;
				break;
				
			case 21: // L,l
				fila = 11;
				break;
				
			case 22: // M,m
				fila = 12;
				break;
				
			case 23: // N,n
				fila = 13;
				break;
				
			case 24: // O,o
				fila = 14;
				break;
				
			case 25: // P,p
				fila = 15;
				break;
				
			default: // Si se introduce una letra con diferente valor numérico al de los casos
				fila = -1;
				break;
		}
	}
	
	// TODO
	/**
	 * Método que comprueba si se ha hundido un acorazado o un destructor, en caso de que se haya hundido devolverá false
	 */
	public void barcoHundido() { 
		hundidoDestrucor = ((arrayChar[rand][rand] == 'X') && (arrayChar[rand-1][rand] == 'X' || arrayChar[rand][rand+1] == 'X'))?true:false; // Al comenzar el juego siempre será false
		
		hundidoAcorazado = ((arrayChar[rand][rand] == 'X') && ((arrayChar[rand-1][rand] == 'X' && arrayChar[rand-2][rand] == 'X') || (arrayChar[rand][rand+1] == 'X' && arrayChar[rand][rand+2] == 'X')))?true:false; // Al comenzar el juego siempre será false
	}
	
	/**
	 * Método que comprueba que el número de blancos acertados es igual al máximo de blancos del juego,
	 * si es así, el jugador obtiene la victoria
	 */
	public void ganar() {
		ganar = (Constantes.NUM_BLANCOS == contAcertados)?true:false;
		
		if(ganar == true) {
			System.out.println("ganar");
			System.exit(0);
		}
	}
}	




