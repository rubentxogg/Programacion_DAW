import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase Number
public class Number {
	
	// Atributos
	private int num;
	
	/*
	 *  Se le pedir� al usuario que introduzca un n�mero y el programa imprimir� los n�meros naturales
	 *  hasta llegar al n�mero seleccionado.
	 */
	public void imprNum() {
		Scanner sc = new Scanner(System.in); // Creando objeto de la clase Scanner
		
		System.out.print("Introduzca un n�mero: ");
		num = sc.nextInt(); // Guardando el n�mero elegido por el usuario
		
		System.out.println("********************************");
		
		for(int i = 0;i<=num;i++) { // Bucle for donde se imprimir�n los n�meros desde el 0 hasta el n�mero introducido por el usuario
			System.out.println(i);
		}
		
	}
	
}
