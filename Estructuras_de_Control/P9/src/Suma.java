import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase Suma
public class Suma {
	
	/* Método que pedirá al usuario un número entero y lo irá sumando por el número de veces que se imprima hasta llegar a ese número
	 * mostrando la suma acumulada al final
	 * */
	public void sumaAc() {
		int num;
		int resultado = 0;
		
		Scanner sc = new Scanner(System.in); // Creando un objeto Scanner para usar sus métodos
		
		System.out.print("Introduzca un número entero: ");
		num = sc.nextInt(); // Guardando el número introducido por el usuario
		
		for(int i=0;i<=num;i++) {
			resultado+=i; // Cada vez que se cumple la condición el resultado es la suma de resultado con "i" (resultado = resultado + i)
			
			if(i==0) { // Si el valor de i es 0, solo imprimirá la i
				System.out.print(i);
			}
			else { // sino, imprimirá "+ i" consiguiendo que delante del 0 no imprima el operador "+"
				System.out.print(" + "+i);
			}
			
		}
		System.out.println(" = "+resultado); // Imprimimos el resultado en la misma línea
	
	}
}
