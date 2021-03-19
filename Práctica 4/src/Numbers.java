import java.io.IOException;
import java.util.Scanner;

public class Numbers {
	static Scanner sc = new Scanner(System.in);
	
	public static int leerNumero() throws IOException{
		System.out.print("Introduce un número entero: ");
		
		return sc.nextInt();
	}
	
	public static void imprimirNumero(int numero) {
		System.out.println("El número introducido por el usuario es: "+numero);
		sc.close();
	}
}
