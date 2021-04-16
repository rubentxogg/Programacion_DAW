import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase Triangle
public class Triangle {
	
	/* Método imprTriangulo que pedirá al usuario un número entero e imprimirá un triángulo rectángulo
	 * con el número de filas que el usuario ha introducido
	 * */
	public void imprTriangulo() {
		int filas;
		int num = 1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca el número de filas: ");
		filas = sc.nextInt(); // Guardando el número introducido filas
		
		System.out.println("********************************");
		
		for(int i=1;i<=filas;i++) { // Mientras "i" sea menor o igual que el número de filas entra al bucle inferior
			for(int j=1;j<=i;j++) { // Mientras "j" es menor o igual a "i" imprime un espacio y "j"
				System.out.print(" "+j);
			}
			System.out.println(); // Una vez que sale del bucle, imprime un salto de línea
		}
		System.out.println();
	}
	
	/* Método imprTriangulo que pedirá al usuario un número entero e imprimirá un triángulo rectángulo
	 * invertido con el número de filas que el usuario ha introducido
	 * */
	public void imprTrianguloInv() {
		int filas;
		int num = 1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca el número de filas: ");
		filas = sc.nextInt(); // Guardando el número introducido filas
		
		System.out.println("********************************");
		
		for(int i=1;i<=filas;i++) { // Mientras "i" sea menor o igual que el número de filas entra al bucle inferior
			for(int j=filas;j>=i;j--) { // "j" tendrá el valor del número de filas introducido por el usuario y mientras éste sea mayor o igual a "i", ejecutará la declaración de abajo
				System.out.print(" "+j);
			}
			System.out.println(); // Una vez que sale del bucle, imprime un salto de línea
		}
		System.out.println(); // Salto de línea
	}
}
