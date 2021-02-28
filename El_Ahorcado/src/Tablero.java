import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 20207
 * Clase que contiene la mecánica del juego
 */
public class Tablero {
	Scanner sc = new Scanner(System.in);
	
	public static String palabra;
	private char[] arrayDescubierto;
	private char[] arrayTapado;
	public static String eleccion;
	private boolean validacion;
	private int oportunidades = 5;
	private boolean acierto;
	
	/**
	 * Método que pide una palabra al jugador 1 y se crea un array de char con esas letras
	 */
	public void iniciarTablero() {
		System.out.println("\t\t<------------El Ahorcado------------>\n"
				+ "\nLas reglas son simples: el jugador 1 escribe la palabra que tiene que adivinar el jugador 2."
				+ "\n\n-El jugador 2 tiene cinco oportunidades."
				+ "\n-En cada turno el jugador 2 introduce una letra, en caso de fallar perderá una oportunidad."
				+ "\n-El jugador 2 también puede introducir la palabra completa pero si falla, se le restará una oportunidad."
				+ "\n-El jugador 2 gana la partida adivinando la palabra, el jugador 1 la gana si el jugador 2 pierde todas las oportunidades."
				+ "\n\n¡Vamos allá! [Enter]");
		System.out.println("\n----------------------------------------------");
		pulsaEnter();
		
		
		while(!validacion) {
			System.out.print("\nJugador 1, introduce una palabra: ");
			palabra = sc.nextLine();
			palabra = palabra.toUpperCase(); // Convertimos la palabra en mayúsculas
			
			validarPalabra(palabra);
			
			if(!validacion) {
				System.out.println("\n[Error] La palabra introducida es inválida, vuelva a intentarlo.\n");
				continue;
			}
			
			arrayDescubierto = palabra.toCharArray(); // Paso el String a un array de char y lo guardo en el arrayDescubierto
	
			arrayTapado = new char[arrayDescubierto.length]; // La longitud del arrayTapado será la longitud del array de String
		
			Arrays.fill(arrayTapado, '_'); // Llenamos el arrayTapado de '_' para simular un caracter escondido
		}
		espacios(100);
		
	}
	
	/**
	 * Método que comprueba si la palabra está compuesta por letras
	 */
	private void validarPalabra(String palabraComp) {
		
		if(palabraComp.matches("[A-Z]+")) {
			validacion = true;
		}
		else {
			validacion = false;
		}
		
	}
	
	/**
	 * Método que imprime el tablero donde el jugador tendrá que adivinar la palabra
	 */
	public void imprimirTablero() {
		for(char x : arrayTapado) {
			System.out.print(x+" ");
		}

		espacios(4);
	}
	
	/**
	 * @param espacios
	 * Método que te imprime el número de espacios que se le pasen
	 */
	private void espacios(int espacios) {
		for(int i=0;i<espacios;i++) {
			System.out.println();
		}
	}
	
	
	/**
	 * Método que pide un char al usuario para posteriormente comprobar si el char se encuentra o no en el array
	 */
	public void iniciarTurno() {
		validacion = false;
		
		while(!validacion) {
			System.out.print("\nJugador 2, introduce una letra: ");
			eleccion = sc.nextLine(); // Guarda el char
			
			eleccion = eleccion.toUpperCase();
			
			validarPalabra(eleccion);
			
			if(!validacion) {
				System.out.println("\n----------------------------------------------");
				System.out.println("\n[Error] Has introducido una letra inválida, vuelve a intentarlo.");
				System.out.println("\n----------------------------------------------");
			}
			
			if(eleccion.length() > 1 && eleccion.equals(palabra)) {
				System.out.println("\n----------------------------------------------");
				System.out.println("\n¡Acertaste! la palabra es: "+palabra+".");
				System.out.println("\nHas ganado, enhorabuena jugador 2.");
				System.out.println("\n----------------------------------------------");
				System.exit(0);
			}
			else if(eleccion.length() > 1 && !eleccion.equals(palabra)){
				System.out.println("\n----------------------------------------------");
				System.out.println("\nBuen intento pero esa no es la palabra.");
				oportunidades--;
				perder();
				System.out.println("\nOportunidades restantes: "+oportunidades+".");
				System.out.println("\n----------------------------------------------\n\n\n");
				validacion = false;
			}
			
		}
			
	}
	
	/**
	 * Método que comprueba si el char elegido por el segundo jugador está en la palabra elegida por el primer jugador 
	 */
	public void comprobarEleccion() {
		acierto = false; // Valor por defecto
		
		for(int i=0; i<arrayDescubierto.length; i++) {
			if(arrayDescubierto[i] == eleccion.charAt(0)) {
				acierto = true;
				arrayTapado[i] = eleccion.charAt(0);
				ganar();
			}
		}
		
		if(acierto) {
			System.out.println("\n----------------------------------------------");
			System.out.println("\n¡Has acertado!\n");
			System.out.println("----------------------------------------------\n\n\n");
			return;
		}
		else{
			System.out.println("\n----------------------------------------------");
			System.out.println("\n¡Fallaste!");
			oportunidades--;
			perder();
			System.out.println("\nOportunidades restantes: "+oportunidades+".");
			System.out.println("\n----------------------------------------------\n\n\n");
		}
		
	}
	
	private void perder() {
		if(oportunidades == 0) {
			System.out.println("\n----------------------------------------------");
			System.out.println("\nJuego terminado, has agotado las oportunidades. Gana el jugador 1.\n\nLa palabra era: "+palabra+".");
			System.out.println("\n----------------------------------------------");
			System.exit(0);
		}
	}
	
	private void ganar() {
		int cont = 0;
		
		for(int i=0; i<arrayTapado.length; i++) {
			if(arrayDescubierto[i] == arrayTapado[i]) {
				cont++;
			}
		}
		
		if(cont == arrayTapado.length) {
			System.out.println("\n----------------------------------------------");
			System.out.println("\n¡Has ganado! enhorabuena jugador 2.");
			System.out.println("\n----------------------------------------------");
			System.exit(0);
		}
		else {
			cont = 0;
		}
	}
	
	/**
	 * Método que pide al jugador que pulse enter para avanzar
	 */
	private void pulsaEnter() {
		sc.nextLine();
	}
}
