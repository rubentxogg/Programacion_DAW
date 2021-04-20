import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase Number
public class Number {
	
	// Atributos
	private int num;
	
	/*
	 *  Se le pedirá al usuario que introduzca un número y el programa imprimirá los números naturales
	 *  hasta llegar al número seleccionado.
	 */
	public void imprNum() {
		Scanner sc = new Scanner(System.in); // Creando objeto de la clase Scanner
		
		System.out.print("Introduzca un número: ");
		num = sc.nextInt(); // Guardando el número elegido por el usuario
		
		System.out.println("********************************");
		
		for(int i = 0;i<=num;i++) { // Bucle for donde se imprimirán los números desde el 0 hasta el número introducido por el usuario
			System.out.println(i);
		}
		
	}
	
}
