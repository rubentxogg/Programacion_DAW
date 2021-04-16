import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase Suma
public class Suma {
	
	/* M�todo que pedir� al usuario un n�mero entero y lo ir� sumando por el n�mero de veces que se imprima hasta llegar a ese n�mero
	 * mostrando la suma acumulada al final
	 * */
	public void sumaAc() {
		int num;
		int resultado = 0;
		
		Scanner sc = new Scanner(System.in); // Creando un objeto Scanner para usar sus m�todos
		
		System.out.print("Introduzca un n�mero entero: ");
		num = sc.nextInt(); // Guardando el n�mero introducido por el usuario
		
		for(int i=0;i<=num;i++) {
			resultado+=i; // Cada vez que se cumple la condici�n el resultado es la suma de resultado con "i" (resultado = resultado + i)
			
			if(i==0) { // Si el valor de i es 0, solo imprimir� la i
				System.out.print(i);
			}
			else { // sino, imprimir� "+ i" consiguiendo que delante del 0 no imprima el operador "+"
				System.out.print(" + "+i);
			}
			
		}
		System.out.println(" = "+resultado); // Imprimimos el resultado en la misma l�nea
	
	}
}
