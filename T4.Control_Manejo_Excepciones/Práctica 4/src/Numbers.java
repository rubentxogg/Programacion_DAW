import java.io.IOException;
import java.util.Scanner;

public class Numbers {
	static Scanner sc = new Scanner(System.in);
	
	public static int leerNumero() throws IOException{
		System.out.print("Introduce un n�mero entero: ");
		
		return sc.nextInt();
	}
	
	public static void imprimirNumero(int numero) {
		System.out.println("El n�mero introducido por el usuario es: "+numero);
		sc.close();
	}
}
