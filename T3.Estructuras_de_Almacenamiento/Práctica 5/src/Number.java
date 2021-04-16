import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubén García García
 * Clase Numbers con métodos relacionados con los números.
 */
public class Number {
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
		mayorNum();
		menorNum();
		positivNum();
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
	
	/**
	 * Método que calcula el mayor número introducido
	 */
	public void mayorNum() {
		Arrays.sort(arrayNum);
		System.out.println("El mayor número es: "+arrayNum[arrayNum.length-1]);
//		int mayor = 0;
//		for(int i=0;i<arrayNum.length;i++) {
//			if(arrayNum[i] > mayor) {
//				mayor = arrayNum[i];
//			}
//		}
//		System.out.println("El mayor número es: "+mayor);
	}
	
	/**
	 * Método que calcula el menor número introducido
	 */
	public void menorNum() {
		Arrays.sort(arrayNum);
		System.out.println("El menor número es: "+arrayNum[0]);
		System.out.println("--------------------------------------");
		
//		int menor = 0;
//		for(int i=0;i<arrayNum.length;i++) {
//			if(menor < arrayNum[i]) {
//				menor = arrayNum[i];
//			}
//		}
//		System.out.println("El mayor número es: "+menor);
//		System.out.println("--------------------------------------");
	}
	
	/**
	 * Mostrar la cantidad de números positivos introducidos
	 */
	public void positivNum() {
		int cantPositiv = 0, cantNegativ = 0, cantCeros = 0;
		Arrays.sort(arrayNum);
		for(int i=0;i<arrayNum.length;i++) {
			if(arrayNum[i] > 0) {
				cantPositiv++;
			}
			else if(arrayNum[i] < 0){
				cantNegativ++;
			}
			else {
				cantCeros++;
			}
		}
		System.out.println("La cantidad de números positivos introducidos es: "+cantPositiv
						+"\nLa cantidad de números negativos introducidos es: "+cantNegativ
						+"\nLa cantidad de ceros introducidos es: "+cantCeros
						+"\n--------------------------------------");
	}
	

	
}