import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rub�n Garc�a Garc�a
 * Clase Numbers con m�todos relacionados con los n�meros.
 */
public class Number {
	int[] arrayNum;
	
	/**
	 * M�todo que solicita la cantidad a incluir en el array de n�meros enteros al usuario, los introduce en un array, calcula la media
	 * de los n�meros, la suma, el producto y muestra los resultados por pantalla
	 */
	public void solicNum() {
		Scanner sc = new Scanner(System.in);
		int cantidad;
		
		System.out.println("--------------------------------------");
		System.out.print("Introduzca la cantidad de n�meros que desea introducir: ");
		cantidad = sc.nextInt();
		arrayNum = new int[cantidad];
		
		for(int i=0;i<arrayNum.length;i++) {
			System.out.print("Introduzca un n�mero: ");
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
	 * M�todo que halla la media de los n�meros introducidos por el usuario
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
	 * M�todo que halla la suma de los n�meros introducidos por el usuario
	 */
	public void sumaNum() {
		int suma = 0;
		for(int i=0;i<arrayNum.length;i++) {
			suma += arrayNum[i];
		}
		System.out.println("La suma es: "+suma);
	}


	/**
	 * M�todo que halla el producto de los n�meros introducidos por el usuario
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
	 * M�todo que calcula el mayor n�mero introducido
	 */
	public void mayorNum() {
		Arrays.sort(arrayNum);
		System.out.println("El mayor n�mero es: "+arrayNum[arrayNum.length-1]);
//		int mayor = 0;
//		for(int i=0;i<arrayNum.length;i++) {
//			if(arrayNum[i] > mayor) {
//				mayor = arrayNum[i];
//			}
//		}
//		System.out.println("El mayor n�mero es: "+mayor);
	}
	
	/**
	 * M�todo que calcula el menor n�mero introducido
	 */
	public void menorNum() {
		Arrays.sort(arrayNum);
		System.out.println("El menor n�mero es: "+arrayNum[0]);
		System.out.println("--------------------------------------");
		
//		int menor = 0;
//		for(int i=0;i<arrayNum.length;i++) {
//			if(menor < arrayNum[i]) {
//				menor = arrayNum[i];
//			}
//		}
//		System.out.println("El mayor n�mero es: "+menor);
//		System.out.println("--------------------------------------");
	}
	
	/**
	 * Mostrar la cantidad de n�meros positivos introducidos
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
		System.out.println("La cantidad de n�meros positivos introducidos es: "+cantPositiv
						+"\nLa cantidad de n�meros negativos introducidos es: "+cantNegativ
						+"\nLa cantidad de ceros introducidos es: "+cantCeros
						+"\n--------------------------------------");
	}
	

	
}