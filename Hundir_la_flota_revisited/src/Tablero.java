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
	private char[][] arrayChar; // Array donde se sitúan los barcos del juego
	private char[][] arrayJugador; // Array que se mostrará al usuario en el modo normal de juego
	private int randFila;
	private int randColumna;
	private boolean libre;
	private int oportRestantes = Constantes.OPORTUNIDADES; // Variable para mostrar las oportunidades restantes del jugador
	private int vida; // Para calcular las oportunidades restantes
	private int charNumericValue; // Variable que utilizaré para guardar el valor numérico de un char
	private int fila;
	private int numDisparos; // Disparos efectuados por el jugador
	static int contBlancos = 0; // Cada vez que se crea un barco incrementa su valor en 1
	private boolean ganar;
	private int numBarcos; // Guarda el número de barcos en juego
	private int contAcertados; // Se incrementa cada vez que el jugador acierta un disparo

	/**
	 * Método que se encarga de crear el tablero vacío
	 */
	public void iniciarTablero() {
		System.out.println("\t\t\t<------ Hundir la Flota Revisited ------>"
				+ "\n\n¡Bienvenido al juego!, el juego consiste en hundir la flota del enemigo."
				+ "\n"
				+ "\n-En cada turno efectuas un disparo en las coordenadas introducidas."
				+ "\n-Si aciertas, se marcará con una X en el tablero, en caso de fallar se marcará con una O."
				+ "\n-Cada fallo resta una oportunidad."
				+ "\n-Los barcos se colocarán de manera aleatoria"
				+ "\n-Tienes "+Constantes.OPORTUNIDADES+" oportunidades, ¡vamos allá! [Enter]");
		pulsaEnter();
		
		arrayChar = new char[Constantes.FILAS][Constantes.COLUMNAS];
		arrayJugador = new char[Constantes.FILAS][Constantes.COLUMNAS];
		

		for(char[] x : arrayChar) {
			Arrays.fill(x, Constantes.MAR); // Lleno las filas con el caracter ~
		}
		
		for(char[] y : arrayJugador) {
			Arrays.fill(y, Constantes.MAR); // Inicio el array para mostrar al usuario
		}
	}

	/**
	 * Método que nos imprime el tablero
	 */
	public void imprimirTablero() {
		char letter = 'A';
		System.out.print("\n\n    ·1  ·2  ·3  ·4  ·5  ·6  ·7  ·8  ·9  ·10 ·11 ·12 ·13 ·14 ·15 ·16");
		for(char[] x : arrayJugador) {

			if(letter == 'A') {
				System.out.println("\n");
			}
			else {
				System.out.println("\n-");
			}

			System.out.print(letter+" |  ");
			letter += 1;
			for(char y : x) {
				System.out.print(y+"   ");
			}
			letter -= 1;
			System.out.print("| "+letter);
			letter += 1;
		}
		System.out.print("\n\n    ·1  ·2  ·3  ·4  ·5  ·6  ·7  ·8  ·9  ·10 ·11 ·12 ·13 ·14 ·15 ·16");
		System.out.println();
	}
	
	/**
	 * Método que nos imprime el tablero en modo depuración
	 */
	public void imprimirTablero(String depuracion) {
		char letter = 'A';
		System.out.print("\n\n    ·1  ·2  ·3  ·4  ·5  ·6  ·7  ·8  ·9  ·10 ·11 ·12 ·13 ·14 ·15 ·16");
		for(char[] x : arrayChar) {

			if(letter == 'A') {
				System.out.println("\n");
			}
			else {
				System.out.println("\n-");
			}

			System.out.print(letter+" |  ");
			letter += 1;
			for(char y : x) {
				System.out.print(y+"   ");
			}
			letter -= 1;
			System.out.print("| "+letter);
			letter += 1;
		}
		System.out.print("\n\n    ·1  ·2  ·3  ·4  ·5  ·6  ·7  ·8  ·9  ·10 ·11 ·12 ·13 ·14 ·15 ·16");
		System.out.println();
	}
	
	/**
	 * Método que colocará los siguientes barcos en el tablero: tres acorazados, dos destructores y tres fragatas.
	 * Se colocarán de manera aleatoria y en posición horizontal o vertical; también comprueba que estén libres las casillas.
	 */
	public void colocarBarcos(int tipoBarco) {
		numBarcos++;
		switch(tipoBarco) {
			case Constantes.FRAGATA:
					while(libre == false) {
						randFila = r.nextInt(Constantes.FILAS);
						randColumna = r.nextInt(Constantes.COLUMNAS);
						if(arrayChar[randFila][randColumna] != Constantes.MAR) {
							libre = false;
						}
						else {
							libre = true;
							arrayChar[randFila][randColumna] = 'F';
							contBlancos++;
						}
					}
					libre = false;
					break;
				
			case Constantes.DESTRUCTOR:
				 while(libre == false) {
						randFila = r.nextInt(Constantes.FILAS-2)+1;
						randColumna = r.nextInt(Constantes.FILAS-2)+1; 
						if(arrayChar[randFila][randColumna] != Constantes.MAR || arrayChar[randFila-1][randColumna] != Constantes.MAR ||  arrayChar[randFila][randColumna+1] != Constantes.MAR || 
							arrayChar[randFila+1][randColumna] != Constantes.MAR || arrayChar[randFila][randColumna-1] != Constantes.MAR) {
							libre = false;
						}
						else {
							libre = true;
							arrayChar[randFila][randColumna] = 'D';
							posBarco(1);
							contBlancos+=2;
						}
					}
					libre = false;
					break;
					 
			case Constantes.ACORAZADO:
					while(libre == false) {
						randFila = r.nextInt(Constantes.FILAS-4)+2;
						randColumna = r.nextInt(Constantes.FILAS-4)+2;
						 
						if(arrayChar[randFila][randColumna] != Constantes.MAR || arrayChar[randFila-1][randColumna] != Constantes.MAR || arrayChar[randFila-2][randColumna] != Constantes.MAR ||
							arrayChar[randFila][randColumna+1] != Constantes.MAR || arrayChar[randFila][randColumna+2] != Constantes.MAR || arrayChar[randFila][randColumna-1] != Constantes.MAR || 
							arrayChar[randFila][randColumna-2] != Constantes.MAR || arrayChar[randFila+1][randColumna] != Constantes.MAR || arrayChar[randFila+2][randColumna] != Constantes.MAR) {
							libre = false;
						}
						else {
							libre = true;
							arrayChar[randFila][randColumna] = 'A';
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
		int pos = r.nextInt(2); // Variable aleatoria que dicta si el barco se pone horizontal o vertical
		int verticalHorizontal; // Variable que indica de que manera se coloca el barco tanto verticalmente como horizontalmente
		
		switch(pos) {
			case 0:
				verticalHorizontal = r.nextInt(2);
				
				if(verticalHorizontal == 1) {
					arrayChar[randFila-1][randColumna] = 'D'; // Vertical
				}
				else {
					arrayChar[randFila+1][randColumna] = 'D'; // Vertical
				}
				break;
				
			case 1:
				verticalHorizontal = r.nextInt(2);
				
				if(verticalHorizontal == 1) {
					arrayChar[randFila][randColumna+1] = 'D'; // Horizontal
				}
				else {
					arrayChar[randFila][randColumna-1] = 'D'; // Horizontal
				}
				break;
		}
		
	}
	
	/**
	 * Coloca el acorazado de forma horizontal o vertical de manera aleatoria
	 */
	public void posBarco() {
		int pos = r.nextInt(2); // Variable aleatoria que dicta de que manera colocar el barco, si en horizontal o en vertical
		int verticalHorizontal; // Variable que indica de que manera se coloca el barco tanto verticalmente como horizontalmente
		
		switch(pos) {

			case 0:
				verticalHorizontal = r.nextInt(2);
				
				if(verticalHorizontal == 1) {
					arrayChar[randFila-1][randColumna] = 'A'; // Vertical
					arrayChar[randFila-2][randColumna] = 'A'; 
				}
				else {
					arrayChar[randFila+1][randColumna] = 'A'; // Vertical
					arrayChar[randFila+2][randColumna] = 'A'; 
				}
				break;
			
			case 1:
				verticalHorizontal = r.nextInt(2);
				
				if(verticalHorizontal == 1) {
					arrayChar[randFila][randColumna+1] = 'A'; // Horizontal
					arrayChar[randFila][randColumna+2] = 'A';
					
				}
				else {
					arrayChar[randFila][randColumna-1] = 'A'; // Horizontal
					arrayChar[randFila][randColumna-2] = 'A'; 
				}
				break;
		}
		
	}
	
	/**
	 * Método que pide al usuario unas coordenadas donde quiera efectuar el disparo y dependiendo de lo que haya en la casilla disparada, 
	 * se mostrará el símbolo y mensaje correspondiente
	 */
	public void disparar() {
		numDisparos++;
		Scanner sc = new Scanner(System.in);
		boolean disparo = false;
		char resultado;
		
		while(disparo == false) {
			imprimirTablero();
			System.out.println("\n---------------------------------");
			System.out.println("| Oportunidades restantes: "+(oportRestantes-vida)+".   |");
			System.out.println("---------------------------------");
			System.out.println("\nIntroduce las coordenadas del disparo.");
			System.out.print("\nFila (letra): ");
			char filaChar = sc.next().charAt(0); // Pedimos una letra (fila)
			charToNumericValue(filaChar); // Convertimos esa letra a valor numérico y lo guardamos en la variable charNumericValue. Ej: A = 10 --> letraInt = 10
			numericValueToFila(charNumericValue); // Convertimos el valor numérico al correspondiente de la fila y lo guardamos en la variable fila. Ej: 10 = 1 --> fila = 1
			if(fila < 0 || fila > 15) {
				System.out.println("\nHas introducido una entrada no válida, pulsa [Enter] para volver a intentarlo.");
				pulsaEnter(); // Pide al usuario que presione la tecla enter
				continue;
			}
			
			System.out.print("Columna (nº): ");
			int columna = sc.nextInt();
			columna -= 1;
			if(columna < 0 || columna > 15) {
				System.out.println("\nLa columna introducida está fuera de rango, pulsa [Enter] para volver a intentarlo.");
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
					arrayJugador[fila][columna] = Constantes.AGUA;
					imprimirTablero();
					vida++;
					if(vida == Constantes.OPORTUNIDADES) {
						System.out.println("\nHas perdido, se han agotado las oportunidades.");
						System.out.println("\n\t    {RESULTADOS}");
						System.out.println("-----------------------------------");
						System.out.println("| Número de disparos: "+numDisparos+"           |");
						System.out.println("| Número de blancos acertados: "+contAcertados+"  |");
						System.out.println("| Número de barcos hundidos:      |");
						System.out.println("| Número de barcos restantes: "+numBarcos+"   |");
						System.out.println("-----------------------------------");
						System.out.println("\nPulsa [Enter] para descubrir el tablero y finalizar.");
						pulsaEnter();
						System.out.println("\n\t    {LEYENDA}");
						System.out.println("-----------------------------------");
						System.out.println("| Fragata: F                      |");
						System.out.println("| Destructor: D                   |");
						System.out.println("| Acorazado: A                    |");
						System.out.println("-----------------------------------");
						imprimirTablero("depuracion");
						System.exit(0);
					}
					else {
						System.out.println("\n¡Agua!");
						System.out.println("\n---------------------------------");
						System.out.print("| Has fallado el disparo.       |");
						System.out.println("\n| Pulsa [Enter] para continuar. |");
						System.out.println("---------------------------------");
						pulsaEnter();
					}
					break;
				
				case 'A': // Acorazado
					arrayChar[fila][columna] = Constantes.TOCADO;
					arrayJugador[fila][columna] = Constantes.TOCADO;
					imprimirTablero();
					contAcertados++;
					ganar();
					
					System.out.println("\n---------------------------------------------------");
					System.out.println("| ¡Tocado! Has acertado en un acorazado. [Enter]  |");
					System.out.println("---------------------------------------------------");
					pulsaEnter();
					break;
				
				case 'D': // Destructor
					arrayChar[fila][columna] = Constantes.TOCADO;
					arrayJugador[fila][columna] = Constantes.TOCADO;
					imprimirTablero();
					contAcertados++;
					ganar();
					
					System.out.println("\n---------------------------------------------------");
					System.out.println("| ¡Tocado! Has acertado en un destructor. [Enter] |");
					System.out.println("---------------------------------------------------");
					pulsaEnter();
					break;
					
				case 'F': // Fragata
					arrayChar[fila][columna] = Constantes.TOCADO;
					arrayJugador[fila][columna] = Constantes.TOCADO;
					imprimirTablero();
					contAcertados++;
					ganar();
					System.out.println("\n--------------------------------------------------------"); // Al ocupar solamente una casilla siempre que acertemos una fragata la hundiremos
					System.out.println("| ¡Tocado y hundido! Has hundido una fragata. [Enter]  |");
					System.out.println("--------------------------------------------------------");
					pulsaEnter();
					break;
					
				default: // Disparo repetido
					System.out.println("\n-------------------------------------------------------------------------------");
					System.out.println("| [Disparo repetido] Ya has efectuado un disparo en esas coordenadas. [Enter] |");
					System.out.println("-------------------------------------------------------------------------------");
					pulsaEnter();
					continue;
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
	public void charToNumericValue(char letra) {
		charNumericValue = Character.getNumericValue(letra);
	}
	
	/**
	 * @param convertirFila
	 * Método que convierte el valor numérico de un char al número de su fila correspondiente
	 */
	public void numericValueToFila(int convertirFila) {
		switch(charNumericValue) {
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
	
	/**
	 * Método que comprueba que el número de blancos acertados es igual al máximo de blancos del juego,
	 * si es así, el jugador obtiene la victoria
	 */
	public void ganar() {
		ganar = (Constantes.NUM_BLANCOS == contAcertados)?true:false;
		
		if(ganar == true) {
			System.out.println("\n--------------------------------------");
			System.out.println("| ¡Enhorabuena! has ganado el juego. |");
			System.out.println("--------------------------------------");
			System.out.println("\n\t    {RESULTADOS}");
			System.out.println("----------------------------------");
			System.out.println("| Número de disparos: "+numDisparos+"          |");
			System.out.println("| Número de blancos acertados: "+contAcertados+" |");
			System.out.println("| Número de barcos hundidos: "+"    |");
			System.out.println("| Oportunidades restantes: "+(oportRestantes-vida)+"    |");
			System.out.println("----------------------------------");
			
			System.exit(0); // Finaliza el programa
		}
	}
}	




