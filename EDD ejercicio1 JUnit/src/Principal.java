import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduzca un nombre: ");
		String nombre1 = sc.next();
		
		System.out.print("Introduzca otro nombre: ");
		String nombre2 = sc.next();
		
		new Concatenar().concatenar(nombre1, nombre2);
	}
}
