import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase Triangle
public class Triangle {
	
	/* M�todo imprTriangulo que pedir� al usuario un n�mero entero e imprimir� un tri�ngulo rect�ngulo
	 * con el n�mero de filas que el usuario ha introducido
	 * */
	public void imprTriangulo() {
		int filas;
		int num = 1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca el n�mero de filas: ");
		filas = sc.nextInt(); // Guardando el n�mero introducido filas
		
		System.out.println("********************************");
		
		for(int i=1;i<=filas;i++) { // Mientras "i" sea menor o igual que el n�mero de filas entra al bucle inferior
			for(int j=1;j<=i;j++) { // Mientras "j" es menor o igual a "i" imprime un espacio y "j"
				System.out.print(" "+j);
			}
			System.out.println(); // Una vez que sale del bucle, imprime un salto de l�nea
		}
		System.out.println();
	}
	
	/* M�todo imprTriangulo que pedir� al usuario un n�mero entero e imprimir� un tri�ngulo rect�ngulo
	 * invertido con el n�mero de filas que el usuario ha introducido
	 * */
	public void imprTrianguloInv() {
		int filas;
		int num = 1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca el n�mero de filas: ");
		filas = sc.nextInt(); // Guardando el n�mero introducido filas
		
		System.out.println("********************************");
		
		for(int i=1;i<=filas;i++) { // Mientras "i" sea menor o igual que el n�mero de filas entra al bucle inferior
			for(int j=filas;j>=i;j--) { // "j" tendr� el valor del n�mero de filas introducido por el usuario y mientras �ste sea mayor o igual a "i", ejecutar� la declaraci�n de abajo
				System.out.print(" "+j);
			}
			System.out.println(); // Una vez que sale del bucle, imprime un salto de l�nea
		}
		System.out.println(); // Salto de l�nea
	}
}
