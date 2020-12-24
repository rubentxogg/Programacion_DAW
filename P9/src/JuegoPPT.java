import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase juego piedra papel o tijera
public class JuegoPPT {
	
	/* M�todo que iniciar� un juego en el que se le pide al usuario que escoja entre piedra, papel y tijera,
	 * el programa escoger� aleatoriamente e imprimir� un mensaje diciendo lo que ha escogido cada uno y seg�n
	 * las normas deljuego si el usuario ha ganado, empatado o perdido
	 * */
	public void piedraPapelTijera() {
		int opc;
		
		do {
			Scanner sc = new Scanner(System.in); // Creando objeto de la clase Scanner

			System.out.println("�Piedra, papel o tijera?\n1.-Piedra\n2.-Papel\n3.-Tijera");
			opc = sc.nextInt(); // Guardando la opci�n del usuario
			int bot = (int) (Math.random() * 3 + 1); // Guardamos la opci�n del programa que se generar� aleatoriamente entre el rango 1-3

			System.out.println("********************************");
			
			/* Dependiendo el valor que le haya tocado a bot y la opci�n que haya introducido el usuario,
			 * imprimir� un mensaje u otro
			 * */
			if (bot == 1) { // Si aleatoriamente a bot le ha tocado 1 que equivale a piedra
				if (opc == 1) { // Si el usuario ha elegido la opci�n 1 que equivale a piedra
					System.out.println("Has elegido piedra y yo piedra �Hemos empatado!"); // Imprimir� un empate, etc
				} 
				else if (opc == 2) {
					System.out.println("Has elegido papel y yo piedra �Has ganado!");
				} 
				else if (opc == 3) {
					System.out.println("Has elegido tijera y yo piedra �Has perdido!");
				}
				else {
					System.out.println("Ha introducido una opci�n inv�lida, vuelva a intentarlo");
				}
			}

			if (bot == 2) {
				if (opc == 1) {
					System.out.println("Has elegido piedra y yo papel �Has perdido!");
				}
				else if (opc == 2) {
					System.out.println("Has elegido papel y yo papel �Hemos empatado!");
				}
				else if (opc == 3) {
					System.out.println("Has elegido tijera y yo papel �Has ganado!");
				}
				else {
					System.out.println("Ha introducido una opci�n inv�lida, vuelva a intentarlo");
				}

			}

			if (bot == 3) {
				if (opc == 1) {
					System.out.println("Has elegido piedra y yo tijera �Has ganado!");
				} 
				else if (opc == 2) {
					System.out.println("Has elegido papel y yo tijera �Has perdido!");
				} 
				else if (opc == 3) {
					System.out.println("Has elegido tijera y yo tijera �Hemos empatado!");
				}
				else {
					System.out.println("Ha introducido una opci�n inv�lida, vuelva a intentarlo");
				}
				
			}
			
		}while((opc != 1) && (opc != 2) && (opc != 3)); // Si el usuario introduce una opci�n diferente a cualquiera de las disponibles, le volver� a pedir que introduzca otra opci�n
		
		
	}
}
