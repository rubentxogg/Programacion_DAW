import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase Tmultiplicar
public class Tmultiplicar {
	
	/* El m�todo pide un n�mero entero y muestra la tabla de multiplicar
	 * de ese mismo n�mero
	 * */
	public void tablaMult() {
		int num;
		int mult;
		
		Scanner sc = new Scanner(System.in); // Creando objeto tipo Scanner
		
		System.out.print("Introduzca un n�mero entero: ");
		num = sc.nextInt(); // Guardamos el n�mero que hemos pedido en num
		
		System.out.println("********************************");
		
		for(int i=1;i<=10;i++) {
			mult = i * num; // En cada iteraci�n la variable mult guardar� el resultado de la multiplicaci�n de i * num
			System.out.println(i+" * "+num+" = "+mult);
		}
		
	}
}
