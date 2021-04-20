/**
 * @author Rubentxo
 * Pr�ctica 12 de programaci�n
 */

import java.util.Scanner;

public class Recursiva{

  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);  
	
	int n;
    
    System.out.print("Introduzca un n�mero: ");
    n = sc.nextInt();
	
	if(n<1){
		System.out.println("ERROR. El n�mero debe ser mayor que cero.");
		return; //Salimos del programa.
	}

	System.out.println("Elija una de las siguientes opciones: ");
	System.out.println("1.- Calcular mediante recursividad.");
	System.out.println("2.- Calcular mediante bucle.");	
	int opc = sc.nextInt();
		
	if(opc == 1){
		System.out.println("Recursividad --> El resultado del factorial del n�mero "+n+" es "+ factorialNum(n));
	}
	else if(opc == 2){
		System.out.print("Bucle --> El resultado del factorial del n�mero "+n+" es ");
		int resultado = n;
		
		while(n>1){ // Mientras "n" sea mayor que 1
			
			if(n == 1) { // Si "n" es 1
				resultado = 1; // El resultado ser� 1
			}
			else {
				n--; // Se resta una unidad a n
				resultado *= n;	 // Se multiplica resultado(valor inicial de "n") * "n"
			}
			
		}
		System.out.print(resultado);
	}
	else{
		System.out.println("ERROR. Elecci�n del men� incorrecta.");
		return;
	}

  }
  
 /**
 * M�todo recursivo que realiza el factorial de un n�mero
 * @param numero N�mero que le pasa el usuario
 * @return Devuelve el factorial de ese n�mero
 */
static int factorialNum(int numero){ // El usuario le pasa un n�mero
	  
	  if(numero == 1){ // Caso base: cuando se cumpla esta expresi�n se parar� la recursividad 
		  return 1;
	  }
	  else{
		  return numero * factorialNum(numero-1); /*Va multiplicando numero *numero-1 y se queda en stand by, 
		  											y vuelve a realizar la operaci�n hasta que llega al caso base*/
	  }
  }
}