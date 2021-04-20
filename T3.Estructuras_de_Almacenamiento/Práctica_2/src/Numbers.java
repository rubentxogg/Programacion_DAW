import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rub�n Garc�a Garc�a
 * Clase Numbers con m�todos relacionados con los n�meros
 */
public class Numbers {
	int num1,num2,num3,num4,num5;
	int media;
	int suma;
	int product;
	
	/**
	 * M�todo que solicita 5 n�meros enteros al usuario, los introduce en un array, calcula la media
	 * de los n�meros, la suma, el producto y muestra los resultados por pantalla
	 */
	public void solicNum() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-------Introduzca cinco n�meros-------");
		
		System.out.print("Primer n�mero: ");
		num1 = sc.nextInt();
		
		System.out.print("Segundo n�mero: ");
		num2 = sc.nextInt();
		
		System.out.print("Tercer n�mero: ");
		num3 = sc.nextInt();
		
		System.out.print("Cuarto n�mero: ");
		num4 = sc.nextInt();
		
		System.out.print("Quinto n�mero: ");
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
	 * M�todo que crea un array con los n�meros introducidos por el usuario y 
	 * lo muestra por pantalla
	 */
	public void crearArrayNum() {
		int[] arrayNum = {num1, num2, num3, num4, num5};
		
		System.out.println("Array creado: "+Arrays.toString(arrayNum));
	}
	
	/**
	 * M�todo que halla la media de los n�meros introducidos por el usuario
	 */
	public void mediaNum() {
		media = (num1+num2+num3+num4+num5) / 2;
	}
	
	/**
	 * M�todo que halla la suma de los n�meros introducidos por el usuario
	 */
	public void sumaNum() {
		suma = num1+num2+num3+num4+num5;
	}
	
	/**
	 * M�todo que halla el producto de los n�meros introducidos por el usuario
	 */
	public void productNum() {
		product = num1*num2*num3*num4*num5;
	}
	
	/**
	 * M�todo que muestra los resultados de la media, la suma y el producto
	 * de los n�meros introducidos por el usuario
	 */
	public void mostrarResult() {
		System.out.println("--------------------------------------");
		System.out.println("Media: "+media);
		System.out.println("Suma: "+suma);
		System.out.println("Producto: "+product);
		System.out.println("--------------------------------------");
	}
}
