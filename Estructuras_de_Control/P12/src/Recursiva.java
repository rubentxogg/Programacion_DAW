/**
 * @author Rubentxo
 * Práctica 12 de programación
 */

import java.util.Scanner;

public class Recursiva{

  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);  
	
	int n;
    
    System.out.print("Introduzca un número: ");
    n = sc.nextInt();
	
	if(n<1){
		System.out.println("ERROR. El número debe ser mayor que cero.");
		return; //Salimos del programa.
	}

	System.out.println("Elija una de las siguientes opciones: ");
	System.out.println("1.- Calcular mediante recursividad.");
	System.out.println("2.- Calcular mediante bucle.");	
	int opc = sc.nextInt();
		
	if(opc == 1){
		System.out.println("Recursividad --> El resultado del factorial del número "+n+" es "+ factorialNum(n));
	}
	else if(opc == 2){
		System.out.print("Bucle --> El resultado del factorial del número "+n+" es ");
		int resultado = n;
		
		while(n>1){ // Mientras "n" sea mayor que 1
			
			if(n == 1) { // Si "n" es 1
				resultado = 1; // El resultado será 1
			}
			else {
				n--; // Se resta una unidad a n
				resultado *= n;	 // Se multiplica resultado(valor inicial de "n") * "n"
			}
			
		}
		System.out.print(resultado);
	}
	else{
		System.out.println("ERROR. Elección del menú incorrecta.");
		return;
	}

  }
  
 /**
 * Método recursivo que realiza el factorial de un número
 * @param numero Número que le pasa el usuario
 * @return Devuelve el factorial de ese número
 */
static int factorialNum(int numero){ // El usuario le pasa un número
	  
	  if(numero == 1){ // Caso base: cuando se cumpla esta expresión se parará la recursividad 
		  return 1;
	  }
	  else{
		  return numero * factorialNum(numero-1); /*Va multiplicando numero *numero-1 y se queda en stand by, 
		  											y vuelve a realizar la operación hasta que llega al caso base*/
	  }
  }
}