import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase Tmultiplicar
public class Tmultiplicar {
	
	/* El método pide un número entero y muestra la tabla de multiplicar
	 * de ese mismo número
	 * */
	public void tablaMult() {
		int num;
		int mult;
		
		Scanner sc = new Scanner(System.in); // Creando objeto tipo Scanner
		
		System.out.print("Introduzca un número entero: ");
		num = sc.nextInt(); // Guardamos el número que hemos pedido en num
		
		System.out.println("********************************");
		
		for(int i=1;i<=10;i++) {
			mult = i * num; // En cada iteración la variable mult guardará el resultado de la multiplicación de i * num
			System.out.println(i+" * "+num+" = "+mult);
		}
		
	}
}
