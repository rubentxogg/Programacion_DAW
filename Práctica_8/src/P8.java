import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubentxo
 * Práctica 8 de programación
 */
public class P8 {
	
	public static void main(String[] args) {
		int[] caja1 = {5, 1, 3, 7, 9, 4};
		int[] caja2 = {9, 1, 5, 3, 2, 6};
		int[] caja3 = {3, 2, 9, 8, 7, 4};
		int num;
		
		// Ordenando el método manualmente
		Elementos.ordenarElementosManual(caja1);
		
		// Ordenando el método con el método de la clase Arrays
		System.out.println("--------------------------------------------------------");
		Arrays.sort(caja1);
		System.out.println("Array ordenado con el método de Arrays: "+Arrays.toString(caja1));
		System.out.println("--------------------------------------------------------\n");
		
		// Buscando el número que ha introducido el usuario
		System.out.println("--------------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número para buscar en el array: ");
		num = sc.nextInt();
		System.out.println();
		Elementos.buscarElementosManual(caja1, num);
		
		// Creando un array de 1.000.000 de números enteros aleatorios
//		Elementos.createArray();
	}
}
