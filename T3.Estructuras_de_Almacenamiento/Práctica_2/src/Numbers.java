import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubén García García
 * Clase Numbers con métodos relacionados con los números
 */
public class Numbers {
	int num1,num2,num3,num4,num5;
	int media;
	int suma;
	int product;
	
	/**
	 * Método que solicita 5 números enteros al usuario, los introduce en un array, calcula la media
	 * de los números, la suma, el producto y muestra los resultados por pantalla
	 */
	public void solicNum() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------Introduzca cinco números-------");
		
		System.out.print("Primer número: ");
		num1 = sc.nextInt();
		
		System.out.print("Segundo número: ");
		num2 = sc.nextInt();
		
		System.out.print("Tercer número: ");
		num3 = sc.nextInt();
		
		System.out.print("Cuarto número: ");
		num4 = sc.nextInt();
		
		System.out.print("Quinto número: ");
		num5 = sc.nextInt();
		
		System.out.println("--------------------------------------");
		
		crearArrayNum();
		mediaNum();
		sumaNum();
		productNum();
		mostrarResult();
		sc.close();
	}
	
	/**
	 * Método que crea un array con los números introducidos por el usuario y 
	 * lo muestra por pantalla
	 */
	public void crearArrayNum() {
		int[] arrayNum = {num1, num2, num3, num4, num5};
		
		System.out.println("Array creado: "+Arrays.toString(arrayNum));
	}
	
	/**
	 * Método que halla la media de los números introducidos por el usuario
	 */
	public void mediaNum() {
		media = (num1+num2+num3+num4+num5) / 2;
	}
	
	/**
	 * Método que halla la suma de los números introducidos por el usuario
	 */
	public void sumaNum() {
		suma = num1+num2+num3+num4+num5;
	}
	
	/**
	 * Método que halla el producto de los números introducidos por el usuario
	 */
	public void productNum() {
		product = num1*num2*num3*num4*num5;
	}
	
	/**
	 * Método que muestra los resultados de la media, la suma y el producto
	 * de los números introducidos por el usuario
	 */
	public void mostrarResult() {
		System.out.println("--------------------------------------");
		System.out.println("Media: "+media);
		System.out.println("Suma: "+suma);
		System.out.println("Producto: "+product);
		System.out.println("--------------------------------------");
	}
}
