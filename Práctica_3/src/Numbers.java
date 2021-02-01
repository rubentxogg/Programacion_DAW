import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubén García García
 * Clase Numbers con métodos relacionados con los números
 */
public class Numbers {
	int[] arrayNum;
	
	/**
	 * Método que solicita la cantidad a incluir en el array de números enteros al usuario, los introduce en un array, calcula la media
	 * de los números, la suma, el producto y muestra los resultados por pantalla
	 */
	public void solicNum() {
		Scanner sc = new Scanner(System.in);
		int cantidad;
		
		System.out.println("--------------------------------------");
		System.out.print("Introduzca la cantidad de números que desea introducir: ");
		cantidad = sc.nextInt();
		arrayNum = new int[cantidad];
		
		for(int i=0;i<arrayNum.length;i++) {
			System.out.print("Introduzca un número: ");
			arrayNum[i] = sc.nextInt();
		}
		
		System.out.println("--------------------------------------");
		System.out.println(Arrays.toString(arrayNum));
		System.out.println("--------------------------------------");
		
		mediaNum();
		sumaNum();
		productNum();
		sc.close();
	}
	
	/**
	 * Método que halla la media de los números introducidos por el usuario
	 */
	public void mediaNum() {
		int media = 0;
		for(int i=0;i<arrayNum.length;i++) {
			media += arrayNum[i];
		}
		media = media / arrayNum.length;
		System.out.println("La media es: "+media);
	}
	
	/**
	 * Método que halla la suma de los números introducidos por el usuario
	 */
	public void sumaNum() {
		int suma = 0;
		for(int i=0;i<arrayNum.length;i++) {
			suma += arrayNum[i];
		}
		System.out.println("La suma es: "+suma);
	}


	/**
	 * Método que halla el producto de los números introducidos por el usuario
	 */
	public void productNum() {
		int producto = 1;
		for(int i=0;i<arrayNum.length;i++) {
			producto = producto * arrayNum[i];
		}
		System.out.println("El producto es: "+producto);
		System.out.println("--------------------------------------");
	}
}
	