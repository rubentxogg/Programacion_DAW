import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase juego piedra papel o tijera
public class JuegoPPT {
	
	/* Método que iniciará un juego en el que se le pide al usuario que escoja entre piedra, papel y tijera,
	 * el programa escogerá aleatoriamente e imprimirá un mensaje diciendo lo que ha escogido cada uno y según
	 * las normas deljuego si el usuario ha ganado, empatado o perdido
	 * */
	public void piedraPapelTijera() {
		int opc;
		
		do {
			Scanner sc = new Scanner(System.in); // Creando objeto de la clase Scanner

			System.out.println("¿Piedra, papel o tijera?\n1.-Piedra\n2.-Papel\n3.-Tijera");
			opc = sc.nextInt(); // Guardando la opción del usuario
			int bot = (int) (Math.random() * 3 + 1); // Guardamos la opción del programa que se generará aleatoriamente entre el rango 1-3

			System.out.println("********************************");
			
			/* Dependiendo el valor que le haya tocado a bot y la opción que haya introducido el usuario,
			 * imprimirá un mensaje u otro
			 * */
			if (bot == 1) { // Si aleatoriamente a bot le ha tocado 1 que equivale a piedra
				if (opc == 1) { // Si el usuario ha elegido la opción 1 que equivale a piedra
					System.out.println("Has elegido piedra y yo piedra ¡Hemos empatado!"); // Imprimirá un empate, etc
				} 
				else if (opc == 2) {
					System.out.println("Has elegido papel y yo piedra ¡Has ganado!");
				} 
				else if (opc == 3) {
					System.out.println("Has elegido tijera y yo piedra ¡Has perdido!");
				}
				else {
					System.out.println("Ha introducido una opción inválida, vuelva a intentarlo");
				}
			}

			if (bot == 2) {
				if (opc == 1) {
					System.out.println("Has elegido piedra y yo papel ¡Has perdido!");
				}
				else if (opc == 2) {
					System.out.println("Has elegido papel y yo papel ¡Hemos empatado!");
				}
				else if (opc == 3) {
					System.out.println("Has elegido tijera y yo papel ¡Has ganado!");
				}
				else {
					System.out.println("Ha introducido una opción inválida, vuelva a intentarlo");
				}

			}

			if (bot == 3) {
				if (opc == 1) {
					System.out.println("Has elegido piedra y yo tijera ¡Has ganado!");
				} 
				else if (opc == 2) {
					System.out.println("Has elegido papel y yo tijera ¡Has perdido!");
				} 
				else if (opc == 3) {
					System.out.println("Has elegido tijera y yo tijera ¡Hemos empatado!");
				}
				else {
					System.out.println("Ha introducido una opción inválida, vuelva a intentarlo");
				}
				
			}
			
		}while((opc != 1) && (opc != 2) && (opc != 3)); // Si el usuario introduce una opción diferente a cualquiera de las disponibles, le volverá a pedir que introduzca otra opción
		
		
	}
}
