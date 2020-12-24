import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase SpecialNumbers
public class SpecialNumbers {
	
	/* Este método pide al usuario un número entero y el programa debe imprimir los números pares
	 * desde el número introducido hasta 0 y por último contar cuantos pares hay desde ese número hasta 0
	 * */
	public void numPares() {
		int num;
		int cont = 0;
		
		Scanner sc = new Scanner(System.in); // Creando objeto de la clase Scanner
		
		System.out.print("Introduzca un número entero: ");
		num = sc.nextInt(); // Guardamos en num el número que hemos pedido
		
		System.out.println("********************************\nLos números pares de "+num+" a cero son:");
		for(int i=num;i>=0;i--) { // Se producirá una iteración desde el número elegido hasta 0
			
			if(i %2 == 0) { // Entrará en esta estructura condicional si el resto de num es 0
				System.out.print(i+" ");
				cont++; // Cada vez que se ejecute esta condición, el contador se incrementará en una unidad
			}
		}
		System.out.println("\nTotal: "+cont+" pares."); // Una vez finalizado, se imprimirá el total de números pares
	}
	
	public void numPrimos() { // ESTUDIAR
		int num;
		int contPrimos = 0;
		int cont;
		
		Scanner sc = new Scanner(System.in); // Creando objeto de la clase Scanner
		
		System.out.print("Introduzca un número entero: ");
		num = sc.nextInt(); // Guardamos en num el número que hemos pedido
		
		System.out.println("********************************\nLos números primos de "+num+" a cero son:");
		
		for(int i=num;i>=1;i--) { // Cuando i sea mayor o igual a 1, entra al código
			cont=0; // Reseteo el contador a 0
			
			for(int j=i;j>=1;j--) { // Necesitamos este bucle para que dividamos el número introducido por el mismo hasta cero
				
				if (i%j==0) { // Cada vez que el resto de i entre j es 0, se incrementa en una unidad el contador
					cont++;
				}
			}
			
			if (cont==2) { // Si el contador es 2, significará que el número es primo porque un número primo solo tiene 2 divisiones e incrementaremos el contador de números primos en una unidad
				contPrimos++;
				System.out.print(i+" "); // Vamos imprimiendo los números primos
			}
		}

		System.out.println("\nTotal: "+contPrimos+" primos."); // Una vez finalizado, se imprimirá el total de números primos
	}
}
