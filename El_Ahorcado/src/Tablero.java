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
	private int oportunidades = 10;
	
	/**
	 * Método que pide una palabra al jugador 1 y se crea un array de char con esas letras
	 */
	public void iniciarTablero() {
		System.out.println("Bienvenidx al juego");
		
		System.out.print("Jugador 1, introduzca una palabra: ");
		palabra = sc.nextLine();
	    
		arrayDescubierto = palabra.toCharArray(); // Paso el String a un array de char y lo guardo en el arrayDescubierto
		
		arrayTapado = new char[palabra.length()]; // La longitud del arrayTapado será la longitud del String
		
		Arrays.fill(arrayTapado, '_'); // Llenamos el arrayTapado de '_' para simular un caracter escondido
	    
		espacios(100);
		
	}
	
	/**
	 * Método que comprueba si la palabra está compuesta por letras
	 */
	public void validarPalabra(String palabraComp) {
		
		if(palabraComp.matches("[a-zA-Z]+")) {
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
		espacios(8);
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
		System.out.println("Introduce una letra: ");
		eleccion = sc.nextLine(); // Guarda el char
			
	}
	
	/**
	 * Método que comprueba si el char elegido por el segundo jugador está en la palabra elegida por el primer jugador 
	 */
	public void comprobarEleccion() {
		for(int i=0; i<arrayTapado.length; i++) {
			if(arrayDescubierto[i] == eleccion.charAt(0)) {
				System.out.println("ACIERTO");
				arrayTapado[i] = eleccion.charAt(0);
			}
			else {
				System.out.println("FALLO");
				oportunidades--;
				System.out.println();
			}
		}
	}
}
