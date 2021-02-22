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
	
	            // Arrays
	private char[][] arrayChar; // Array donde se sitúan los barcos del juego
	private char[][] arrayJugador; // Array que se mostrará al usuario en el modo normal de juego
	private char[][] arrayDestructor; // Array solamente de destructores para diferenciarlos al hundirlos de los otros barcos
	private char[][] arrayAcorazado; // Array solamente de acorazados para diferenciarlos al hundirlos de los otros barcos
	
				// Contadores
	private int numDisparos; // Disparos efectuados por el jugador
	static int contBlancos = 0; // Cada vez que se crea un barco incrementa su valor en 1
	private int contAcertados; // Se incrementa cada vez que el jugador acierta un disparo
	private int contHundidos; // Contador de barcos hundidos
	private int numBarcos; // Guarda el número de barcos en juego
	private int oportRestantes = Constantes.OPORTUNIDADES; // Variable para mostrar las oportunidades restantes del jugador
	private int vida; // Para calcular las oportunidades restantes
		
				// Booleanos
	private boolean hundido;
	private boolean libre;
	private boolean ganar;
	static boolean debug; // Para comprobar si el usuario ha iniciado el juego en modo debug
	
				// Integers
	private int randFila;
	private int randColumna;
	private int charNumericValue; // Variable que utilizaré para guardar el valor numérico de un char
	private int fila;
	private int columna;
	
	/**
	 * Método que se encarga de crear el tablero vacío
	 */
	public void iniciarTablero() {
		System.out.println("\t\t\t<------ Hundir la Flota Revisited ------>"
				+ "\n\n¡Bienvenido al juego!, el juego consiste en hundir la flota del enemigo."
				+ "\n"
				+ "\n-En cada turno efectuarás un disparo en las coordenadas que indiques."
				+ "\n-Si aciertas, se marcará con una X en el tablero, en caso de fallar se marcará con una O."
				+ "\n-Cada fallo resta una oportunidad."
				+ "\n-Los barcos se colocarán de manera aleatoria."
				+ "\n-Existen tres tipos de barcos: \n\t\t·Acorazado: ocupa 3 casillas. \n\t\t·Destructor: ocupa 2 casillas. \n\t\t·Fragata: ocupa 1 casilla."
				+ "\n-Tienes "+Constantes.OPORTUNIDADES+" oportunidades, ¡vamos allá! [Enter]");
		pulsaEnter();
		
		arrayChar = new char[Constantes.FILAS][Constantes.COLUMNAS];
		arrayJugador = new char[Constantes.FILAS][Constantes.COLUMNAS];
		arrayDestructor = new char[Constantes.FILAS][Constantes.COLUMNAS];
		arrayAcorazado = new char[Constantes.FILAS][Constantes.COLUMNAS];
		
		for(char[] x : arrayChar) {
			Arrays.fill(x, Constantes.MAR); // Lleno las filas con el caracter ~
		}
		
		for(char[] y : arrayJugador) {
			Arrays.fill(y, Constantes.MAR); // Inicio el array para mostrar al usuario
		}
		
		for(char[] j : arrayDestructor) {
			Arrays.fill(j, Constantes.MAR); 
		}
		
		for(char[] k : arrayAcorazado) {
			Arrays.fill(k, Constantes.MAR); 
		}
	}

	/**
	 * Método que nos imprime el tablero
	 */
	private void imprimirTablero() {
		char letter = 'A';
		int num = 1;
		boolean numLimite = false;

		System.out.print("\n    ");
		while(numLimite == false) {
			if(num < 10 && num < arrayChar.length) { // Si el número es menor que 10 y que el límite del array, me imprimirá el número con dos espacios para que el tablero quede proporcionado
				System.out.print("·"+num+"  ");
				num++;
			}
			else if(num < arrayChar.length+1) {
				System.out.print("·"+num+" ");
				num++;
			}
			else {
				numLimite = true;
			}
		}
		
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
		
		num = 1;
		numLimite = false;
		
		System.out.println("\n");
		System.out.print("    ");
		while(numLimite == false) {
			if(num < 10 && num < arrayChar.length) {
				System.out.print("·"+num+"  ");
				num++;
			}
			else if(num < arrayChar.length+1) {
				System.out.print("·"+num+" ");
				num++;
			}
			else {
				numLimite = true;
			}
		}
		System.out.println();
	}
	
	/**
	 * Método que nos imprime el tablero en {MODO DEPURACIÓN}
	 */
	private void imprimirTablero(String depuracion) {
		char letter = 'A';
		int num = 1;
		boolean numLimite = false;

		System.out.print("\n    ");
		while(numLimite == false) {
			if(num < 10 && num < arrayChar.length) { // Si el número es menor que 10 y que el límite del array, me imprimirá el número con dos espacios para que el tablero quede proporcionado
				System.out.print("·"+num+"  ");
				num++;
			}
			else if(num < arrayChar.length+1) {
				System.out.print("."+num+" ");
				num++;
			}
			else {
				numLimite = true;
			}
		}
		
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
		
		num = 1;
		numLimite = false;
		
		System.out.println("\n");
		System.out.print("    ");
		while(numLimite == false) {
			if(num < 10 && num < arrayChar.length) {
				System.out.print("·"+num+"  ");
				num++;
			}
			else if(num < arrayChar.length+1) {
				System.out.print("."+num+" ");
				num++;
			}
			else {
				numLimite = true;
			}
		}
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
							arrayDestructor[randFila][randColumna] = 'D';
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
							arrayAcorazado[randFila][randColumna] = 'A';
							posBarco();
							contBlancos+=3;
						}
					}
					libre = false;
					break;		  
		}
	}
	
	
	/**
	 * Método que cuando haya dos casillas con X seguidas entiende que se ha hundido un destructor
	 * y marca esas casillas con O para evitar confusión si se encontrase otro destructor al lado
	 */
	private void comprobarDestructor() {
		
		if(arrayDestructor[fila][columna] == 'X' && arrayDestructor[fila-1][columna] == 'X') {
			arrayDestructor[fila][columna] = 'O';
			arrayDestructor[fila-1][columna] = 'O';
			hundido = true;
		}
		else if(arrayDestructor[fila][columna] == 'X' && arrayDestructor[fila][columna+1] == 'X') {
			arrayDestructor[fila][columna] = 'O';
			arrayDestructor[fila][columna+1] = 'O';
			hundido = true;
		}
		else if(arrayDestructor[fila][columna] == 'X' && arrayDestructor[fila+1][columna] == 'X') {
			arrayDestructor[fila][columna] = 'O';
			arrayDestructor[fila+1][columna] = 'O';
			hundido = true;
		}
		else if(arrayDestructor[fila][columna] == 'X' && arrayDestructor[fila][columna-1] == 'X') {
			arrayDestructor[fila][columna] = 'O';
			arrayDestructor[fila][columna-1] = 'O';
			hundido = true;
		}
		else {
			hundido = false;
		}
	}
	
	/**
	 * Método que cuando haya tres casillas con X seguidas entiende que se ha hundido un acorazado
	 * y marca esas casillas con O para evitar confusión si se encontrase otro acorazado al lado
	 */
	private void comprobarAcorazado() {
		
		if(arrayAcorazado[fila][columna] == 'X' && arrayAcorazado[fila-1][columna] == 'X' && arrayAcorazado[fila-2][columna] == 'X') {
			arrayAcorazado[fila][columna] = 'O';
			arrayAcorazado[fila-1][columna] = 'O';
			arrayAcorazado[fila-2][columna] = 'O';
			hundido = true;
		}
		else if(arrayAcorazado[fila][columna] == 'X' && arrayAcorazado[fila][columna+1] == 'X' && arrayAcorazado[fila][columna+2] == 'X') {
			arrayAcorazado[fila][columna] = 'O';
			arrayAcorazado[fila][columna+1] = 'O';
			arrayAcorazado[fila][columna+2] = 'O';
			hundido = true;
		}
		else if(arrayAcorazado[fila][columna] == 'X' && arrayAcorazado[fila+1][columna] == 'X' && arrayAcorazado[fila+2][columna] == 'X') {
			arrayAcorazado[fila][columna] = 'O';
			arrayAcorazado[fila+1][columna] = 'O';
			arrayAcorazado[fila+2][columna] = 'O';
			hundido = true;
		}
		else if(arrayAcorazado[fila][columna] == 'X' && arrayAcorazado[fila][columna-1] == 'X' && arrayAcorazado[fila][columna-2] == 'X') {
			arrayAcorazado[fila][columna] = 'O';
			arrayAcorazado[fila][columna-1] = 'O';
			arrayAcorazado[fila][columna-2] = 'O';
			hundido = true;
		}
		else {
			hundido = false;
		}
		
	}
	
	/**
	 * @param destructor
	 * Coloca el destructor de forma horizontal o vertical de manera aleatoria
	 */
	private void posBarco(int destructor) {
		int pos = r.nextInt(2); // Variable aleatoria que dicta si el barco se pone horizontal o vertical
		int verticalHorizontal; // Variable que indica de que manera se coloca el barco tanto verticalmente como horizontalmente
		
		switch(pos) {
			case 0:
				verticalHorizontal = r.nextInt(2);
				
				if(verticalHorizontal == 1) {
					arrayChar[randFila-1][randColumna] = 'D'; // Vertical
					arrayDestructor[randFila-1][randColumna] = 'D'; 
				}
				else {
					arrayChar[randFila+1][randColumna] = 'D'; // Vertical
					arrayDestructor[randFila+1][randColumna] = 'D'; 
				}
				break;
				
			case 1:
				verticalHorizontal = r.nextInt(2);
				
				if(verticalHorizontal == 1) {
					arrayChar[randFila][randColumna+1] = 'D'; // Horizontal
					arrayDestructor[randFila][randColumna+1] = 'D'; 
				}
				else {
					arrayChar[randFila][randColumna-1] = 'D'; // Horizontal
					arrayDestructor[randFila][randColumna-1] = 'D'; 
				}
				break;
		}
		
	}
	
	/**
	 * Coloca el acorazado de forma horizontal o vertical de manera aleatoria
	 */
	private void posBarco() {
		int pos = r.nextInt(2); // Variable aleatoria que dicta de que manera colocar el barco, si en horizontal o en vertical
		int verticalHorizontal; // Variable que indica de que manera se coloca el barco tanto verticalmente como horizontalmente
		
		switch(pos) {

			case 0:
				verticalHorizontal = r.nextInt(2);
				
				if(verticalHorizontal == 1) {
					arrayChar[randFila-1][randColumna] = 'A'; // Vertical
					arrayChar[randFila-2][randColumna] = 'A'; 
					arrayAcorazado[randFila-1][randColumna] = 'A';
					arrayAcorazado[randFila-2][randColumna] = 'A';
				}
				else {
					arrayChar[randFila+1][randColumna] = 'A'; // Vertical
					arrayChar[randFila+2][randColumna] = 'A'; 
					arrayAcorazado[randFila+1][randColumna] = 'A';
					arrayAcorazado[randFila+2][randColumna] = 'A';
					
				}
				break;
			
			case 1:
				verticalHorizontal = r.nextInt(2);
				
				if(verticalHorizontal == 1) {
					arrayChar[randFila][randColumna+1] = 'A'; // Horizontal
					arrayChar[randFila][randColumna+2] = 'A';
					arrayAcorazado[randFila][randColumna+1] = 'A';
					arrayAcorazado[randFila][randColumna+2] = 'A';
					
				}
				else {
					arrayChar[randFila][randColumna-1] = 'A'; // Horizontal
					arrayChar[randFila][randColumna-2] = 'A';
					arrayAcorazado[randFila][randColumna-1] = 'A';
					arrayAcorazado[randFila][randColumna-2] = 'A';
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
			if(fila < 0 || fila > arrayChar.length-1) {
				System.out.println("\nHas introducido una entrada no válida, pulsa [Enter] para volver a intentarlo.");
				pulsaEnter(); // Pide al usuario que presione la tecla enter
				continue;
			}
			
			System.out.print("Columna (nº): ");
			columna = sc.nextInt();
			columna -= 1;
			if(columna < 0 || columna > arrayChar.length-1) {
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
						
						// Si los contadores son menores que 9 se imprimirá solamente un espacio, en caso contrario dos espacios para que la caja mostrada al jugador sea proporcional
						if(numDisparos < 9) {
							System.out.println("| Número de disparos: "+numDisparos+"           |");
						}
						else {
							System.out.println("| Número de disparos: "+numDisparos+"          |");
						}
						
						if(contAcertados < 9) {
							System.out.println("| Número de blancos acertados: "+contAcertados+"  |");
						}
						else {
							System.out.println("| Número de blancos acertados: "+contAcertados+" |");
						}
						
						if(contHundidos < 9) {
							System.out.println("| Número de barcos hundidos: "+contHundidos+"    |");
						}
						else {
							System.out.println("| Número de barcos hundidos: "+contHundidos+"   |");
						}
						
						if(numBarcos < 9) {
							System.out.println("| Número de barcos restantes: "+numBarcos+"   |");
						}
						else {
							System.out.println("| Número de barcos restantes: "+numBarcos+"  |");
						}
						
						System.out.println("-----------------------------------");
						System.out.println("\nPulsa [Enter] para descubrir el tablero y finalizar.");
						pulsaEnter();
						System.out.println("\n\t {LEYENDA}");
						System.out.println("-------------------------");
						System.out.println("| Fragata: F            |");
						System.out.println("| Destructor: D         |");
						System.out.println("| Acorazado: A          |");
						System.out.println("-------------------------\n");
						imprimirTablero("MODO DEPURACION"); // Descubre la posición de los barcos restantes
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
					arrayAcorazado[fila][columna] = Constantes.TOCADO;
					imprimirTablero();
					contAcertados++;
					ganar();
					comprobarAcorazado(); // Comprueba si el acorazado se ha hundido
					if(hundido == true) {
						System.out.println("\n--------------------------------------------------------");
						System.out.println("| ¡Tocado y hundido! Has hundido un acorazado. [Enter] |");
						System.out.println("--------------------------------------------------------");
						contHundidos++;
					}
					else {
						System.out.println("\n---------------------------------------------------");
						System.out.println("| ¡Tocado! Has acertado en un acorazado. [Enter]  |");
						System.out.println("---------------------------------------------------");
					}
					hundido = false; // Vuelve a su valor por defecto para realizar la próxima comprobación
					pulsaEnter();
					break;
				
				case 'D': // Destructor
					arrayChar[fila][columna] = Constantes.TOCADO;
					arrayJugador[fila][columna] = Constantes.TOCADO;
					arrayDestructor[fila][columna] = Constantes.TOCADO;
					imprimirTablero();
					contAcertados++;
					ganar();
					comprobarDestructor(); // Comprueba si el destructor se ha hundido
					if(hundido == true) {
						System.out.println("\n--------------------------------------------------------");
						System.out.println("| ¡Tocado y hundido! Has hundido un destructor [Enter] |");
						System.out.println("--------------------------------------------------------");
						contHundidos++;
					}
					else {
						System.out.println("\n---------------------------------------------------");
						System.out.println("| ¡Tocado! Has acertado en un destructor. [Enter] |");
						System.out.println("---------------------------------------------------");
					}
					hundido = false; // Vuelve a su valor por defecto para realizar la próxima comprobación
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
					contHundidos++;
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
	 * Método que pide al usuario unas coordenadas donde quiera efectuar el disparo y dependiendo de lo que haya en la casilla disparada, 
	 * se mostrará el símbolo y mensaje correspondiente
	 */
	public void disparar(boolean depuracion) {
		numDisparos++;
		Scanner sc = new Scanner(System.in);
		boolean disparo = false;
		char resultado;
		
		while(disparo == false) {
			imprimirTablero("MODO DEPURACION");
			System.out.println("\n---------------------------------");
			System.out.println("| Oportunidades restantes: "+(oportRestantes-vida)+".   |");
			System.out.println("---------------------------------");
			System.out.println("\nIntroduce las coordenadas del disparo.");
			System.out.print("\nFila (letra): ");
			char filaChar = sc.next().charAt(0); // Pedimos una letra (fila)
			charToNumericValue(filaChar); // Convertimos esa letra a valor numérico y lo guardamos en la variable charNumericValue. Ej: A = 10 --> letraInt = 10
			numericValueToFila(charNumericValue); // Convertimos el valor numérico al correspondiente de la fila y lo guardamos en la variable fila. Ej: 10 = 1 --> fila = 1
			if(fila < 0 || fila > arrayChar.length-1) {
				System.out.println("\nHas introducido una entrada no válida, pulsa [Enter] para volver a intentarlo.");
				pulsaEnter(); // Pide al usuario que presione la tecla enter
				continue;
			}
			
			System.out.print("Columna (nº): ");
			columna = sc.nextInt();
			columna -= 1;
			if(columna < 0 || columna > arrayChar.length-1) {
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
					imprimirTablero("MODO DEPURACION");
					vida++;
					if(vida == Constantes.OPORTUNIDADES) {
						System.out.println("\nHas perdido, se han agotado las oportunidades.");
						System.out.println("\n\t    {RESULTADOS}");
						System.out.println("-----------------------------------");
						
						// Si los contadores son menores que 9 se imprimirá solamente un espacio, en caso contrario dos espacios para que la caja mostrada al jugador sea proporcional
						if(numDisparos < 9) {
							System.out.println("| Número de disparos: "+numDisparos+"           |");
						}
						else {
							System.out.println("| Número de disparos: "+numDisparos+"          |");
						}
						
						if(contAcertados < 9) {
							System.out.println("| Número de blancos acertados: "+contAcertados+"  |");
						}
						else {
							System.out.println("| Número de blancos acertados: "+contAcertados+" |");
						}
						
						if(contHundidos < 9) {
							System.out.println("| Número de barcos hundidos: "+contHundidos+"    |");
						}
						else {
							System.out.println("| Número de barcos hundidos: "+contHundidos+"   |");
						}
						
						if(numBarcos < 9) {
							System.out.println("| Número de barcos restantes: "+numBarcos+"   |");
						}
						else {
							System.out.println("| Número de barcos restantes: "+numBarcos+"  |");
						}
						
						System.out.println("-----------------------------------");
						System.out.println("\nPulsa [Enter] para descubrir el tablero y finalizar.");
						pulsaEnter();
						System.out.println("\n\t {LEYENDA}");
						System.out.println("-------------------------");
						System.out.println("| Fragata: F            |");
						System.out.println("| Destructor: D         |");
						System.out.println("| Acorazado: A          |");
						System.out.println("-------------------------\n");
						imprimirTablero("MODO DEPURACION"); // Descubre la posición de los barcos restantes
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
					arrayAcorazado[fila][columna] = Constantes.TOCADO;
					imprimirTablero("MODO DEPURACION");
					contAcertados++;
					ganar();
					comprobarAcorazado(); // Comprueba si el acorazado se ha hundido
					if(hundido == true) {
						System.out.println("\n--------------------------------------------------------");
						System.out.println("| ¡Tocado y hundido! Has hundido un acorazado. [Enter] |");
						System.out.println("--------------------------------------------------------");
						contHundidos++;
					}
					else {
						System.out.println("\n---------------------------------------------------");
						System.out.println("| ¡Tocado! Has acertado en un acorazado. [Enter]  |");
						System.out.println("---------------------------------------------------");
					}
					hundido = false; // Vuelve a su valor por defecto para realizar la próxima comprobación
					pulsaEnter();
					break;
				
				case 'D': // Destructor
					arrayChar[fila][columna] = Constantes.TOCADO;
					arrayJugador[fila][columna] = Constantes.TOCADO;
					arrayDestructor[fila][columna] = Constantes.TOCADO;
					imprimirTablero("MODO DEPURACION");
					contAcertados++;
					ganar();
					comprobarDestructor(); // Comprueba si el destructor se ha hundido
					if(hundido == true) {
						System.out.println("\n--------------------------------------------------------");
						System.out.println("| ¡Tocado y hundido! Has hundido un destructor [Enter] |");
						System.out.println("--------------------------------------------------------");
						contHundidos++;
					}
					else {
						System.out.println("\n---------------------------------------------------");
						System.out.println("| ¡Tocado! Has acertado en un destructor. [Enter] |");
						System.out.println("---------------------------------------------------");
					}
					hundido = false; // Vuelve a su valor por defecto para realizar la próxima comprobación
					pulsaEnter();
					break;
					
				case 'F': // Fragata
					arrayChar[fila][columna] = Constantes.TOCADO;
					arrayJugador[fila][columna] = Constantes.TOCADO;
					imprimirTablero("MODO DEPURACION");
					contAcertados++;
					ganar();
					System.out.println("\n--------------------------------------------------------"); // Al ocupar solamente una casilla siempre que acertemos una fragata la hundiremos
					System.out.println("| ¡Tocado y hundido! Has hundido una fragata. [Enter]  |");
					System.out.println("--------------------------------------------------------");
					contHundidos++;
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
	private void pulsaEnter() {
		Scanner enter = new Scanner(System.in);
		enter.nextLine();
	}
	
	/**
	 * @param letra
	 * Método que convierte a int el caracter que le pasamos
	 */
	private void charToNumericValue(char letra) {
		charNumericValue = Character.getNumericValue(letra);
	}
	
	/**
	 * @param convertirFila
	 * Método que convierte el valor numérico de un char al número de su fila correspondiente
	 */
	private void numericValueToFila(int convertirFila) {
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
				
			case 26: // Q,q
				fila = 16;
				break;
				
			case 27: // R,r
				fila = 17;
				break;
				
			case 28: // S,s
				fila = 18;
				break;
				
			case 29: // T,t
				fila = 19;
				break;
				
			case 30: // U,u
				fila = 20;
				break;
				
			case 31: // V,v
				fila = 21;
				break;
				
			case 32: // W,w
				fila = 22;
				break;
				
			case 33: // X,x
				fila = 23;
				break;
				
			case 34: // Y,y
				fila = 24;
				break;
				
			case 35: // Z,z
				fila = 25;
				
			default: // Si se introduce una letra con diferente valor numérico al de los casos
				fila = -1;
				break;
		}
	}
	
	/**
	 * Método que comprueba que el número de blancos acertados es igual al máximo de blancos del juego,
	 * si es así, el jugador obtiene la victoria
	 */
	private void ganar() {
		ganar = (Constantes.NUM_BLANCOS == contAcertados)?true:false;
		
		if(ganar == true) {
			System.out.println("\n--------------------------------------");
			System.out.println("| ¡Enhorabuena! has ganado el juego. |");
			System.out.println("--------------------------------------");
			System.out.println("\n\t    {RESULTADOS}");
			System.out.println("----------------------------------");
			
			// Si los contadores son menores que 9 se imprimirá solamente un espacio, en caso contrario dos espacios para que la caja mostrada al jugador sea proporcional
			if(numDisparos < 9) {
				System.out.println("| Número de disparos: "+numDisparos+"          |");
			}
			else {
				System.out.println("| Número de disparos: "+numDisparos+"         |");
			}
			
			if(contAcertados < 9) {
				System.out.println("| Número de blancos acertados: "+contAcertados+" |");
			}
			else {
				System.out.println("| Número de blancos acertados: "+contAcertados+"|");
			}
			
			if(contHundidos < 9){
				System.out.println("| Número de barcos hundidos: "+contHundidos+"   |");
			}
			else {
				System.out.println("| Número de barcos hundidos: "+contHundidos+"  |");
			}
			
			if((oportRestantes-vida) < 9) {
				System.out.println("| Oportunidades restantes: "+(oportRestantes-vida)+"     |");
			}
			else {
				System.out.println("| Oportunidades restantes: "+(oportRestantes-vida)+"    |");
			}
			System.out.println("----------------------------------");
			
			System.exit(0); // Finaliza el programa
		}
	}
}	




