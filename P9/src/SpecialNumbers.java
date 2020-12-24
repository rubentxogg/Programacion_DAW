import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase SpecialNumbers
public class SpecialNumbers {
	
	/* Este m�todo pide al usuario un n�mero entero y el programa debe imprimir los n�meros pares
	 * desde el n�mero introducido hasta 0 y por �ltimo contar cuantos pares hay desde ese n�mero hasta 0
	 * */
	public void numPares() {
		int num;
		int cont = 0;
		
		Scanner sc = new Scanner(System.in); // Creando objeto de la clase Scanner
		
		System.out.print("Introduzca un n�mero entero: ");
		num = sc.nextInt(); // Guardamos en num el n�mero que hemos pedido
		
		System.out.println("********************************\nLos n�meros pares de "+num+" a cero son:");
		for(int i=num;i>=0;i--) { // Se producir� una iteraci�n desde el n�mero elegido hasta 0
			
			if(i %2 == 0) { // Entrar� en esta estructura condicional si el resto de num es 0
				System.out.print(i+" ");
				cont++; // Cada vez que se ejecute esta condici�n, el contador se incrementar� en una unidad
			}
		}
		System.out.println("\nTotal: "+cont+" pares."); // Una vez finalizado, se imprimir� el total de n�meros pares
	}
	
	public void numPrimos() { // ESTUDIAR
		int num;
		int contPrimos = 0;
		int cont;
		
		Scanner sc = new Scanner(System.in); // Creando objeto de la clase Scanner
		
		System.out.print("Introduzca un n�mero entero: ");
		num = sc.nextInt(); // Guardamos en num el n�mero que hemos pedido
		
		System.out.println("********************************\nLos n�meros primos de "+num+" a cero son:");
		
		for(int i=num;i>=1;i--) { // Cuando i sea mayor o igual a 1, entra al c�digo
			cont=0; // Reseteo el contador a 0
			
			for(int j=i;j>=1;j--) { // Necesitamos este bucle para que dividamos el n�mero introducido por el mismo hasta cero
				
				if (i%j==0) { // Cada vez que el resto de i entre j es 0, se incrementa en una unidad el contador
					cont++;
				}
			}
			
			if (cont==2) { // Si el contador es 2, significar� que el n�mero es primo porque un n�mero primo solo tiene 2 divisiones e incrementaremos el contador de n�meros primos en una unidad
				contPrimos++;
				System.out.print(i+" "); // Vamos imprimiendo los n�meros primos
			}
		}

		System.out.println("\nTotal: "+contPrimos+" primos."); // Una vez finalizado, se imprimir� el total de n�meros primos
	}
}
