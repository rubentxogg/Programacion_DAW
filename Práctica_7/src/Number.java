import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubén García García
 * Clase Numbers con métodos relacionados con los números.
 */
public class Number {
	int[] arrayUniNum;
	int[][] arrayBiNum;
	
	/**
	 * Método que solicita la cantidad a incluir en el array de números enteros al usuario, los introduce en un array, calcula la media
	 * de los números, la suma, el producto y muestra los resultados por pantalla
	 */
	public void solicNum() {
		Scanner sc = new Scanner(System.in);
		int opc = 0;
		
		do {
			System.out.println("¿Qué tipo de array desea crear?"
					+"\n1.- Unidimensional"
					+"\n2.- Bidimensional");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1: arrayUnidimensional();
				break;
				
				case 2: arrayBidimensional();
				break;
				
				default: System.out.println("Ha seleccionado una opción inválida, vuelva a intentarlo.");
				System.out.println("--------------------------------------");
			}
			
			
		}while((opc != 1) && (opc != 2));
		
		
	}
	
	/**
	 * Método que crea un array bidimensional y lo rellena de números aleatorios
	 */
	public void arrayBidimensional() {
		Scanner sc = new Scanner(System.in);
		int filas, columnas;
		
		System.out.println("--------------------------------------");
		System.out.print("Introduzca la cantidad de filas que desea introducir: ");
		filas = sc.nextInt();
	
		System.out.print("Introduzca la cantidad de columnas que desea introducir: ");
		columnas = sc.nextInt();
		arrayBiNum = new int[filas][columnas];
		
		Arrays.fill(arrayBiNum, Math.random()*arrayBiNum.length);
	}
//		for(int i=0;i<arrayBiNum.length;i++) {
//			for(int j=0;j<arrayBiNum[i].length;j++) {
//				arrayBiNum[i][j] = (int) (Math.random()*arrayBiNum.length);
//			}
//			
//		}
//		
//		System.out.println("--------------------------------------");
//		System.out.println(Arrays.toString(arrayBiNum));
//		System.out.println("--------------------------------------");
//		
//		mediaNum();
//		sumaNum();
//		productNum();
//		mayorNum();
//		menorNum();
//		positivNum();
//		sc.close();
//	}
//	
	
	/**
	 * Método que crea un array unidimensional
	 */
	public void arrayUnidimensional() {
		Scanner sc = new Scanner(System.in);
		int cantidad;
		
		System.out.println("--------------------------------------");
		System.out.print("Introduzca la cantidad de números que desea introducir: ");
		cantidad = sc.nextInt();
		arrayUniNum = new int[cantidad];
		
		for(int i=0;i<arrayUniNum.length;i++) {
			System.out.print("Introduzca un número: ");
			arrayUniNum[i] = sc.nextInt();
		}
		
		System.out.println("--------------------------------------");
		System.out.println(Arrays.toString(arrayUniNum));
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
		for(int i=0;i<arrayUniNum.length;i++) {
			media += arrayUniNum[i];
		}
		media = media / arrayUniNum.length;
		System.out.println("La media es: "+media);
	}
	
	/**
	 * Método que halla la suma de los números introducidos por el usuario
	 */
	public void sumaNum() {
		int suma = 0;
		for(int i=0;i<arrayUniNum.length;i++) {
			suma += arrayUniNum[i];
		}
		System.out.println("La suma es: "+suma);
	}


	/**
	 * Método que halla el producto de los números introducidos por el usuario
	 */
	public void productNum() {
		int producto = 1;
		for(int i=0;i<arrayUniNum.length;i++) {
			producto = producto * arrayUniNum[i];
		}
		System.out.println("El producto es: "+producto);
		System.out.println("--------------------------------------");
	}
	
	/**
	 * Método que calcula el mayor número introducido
	 */
	public void mayorNum() {
		Arrays.sort(arrayUniNum);
		System.out.println("El mayor número es: "+arrayUniNum[arrayUniNum.length-1]);
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
		Arrays.sort(arrayUniNum);
		System.out.println("El menor número es: "+arrayUniNum[0]);
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
		Arrays.sort(arrayUniNum);
		for(int i=0;i<arrayUniNum.length;i++) {
			if(arrayUniNum[i] > 0) {
				cantPositiv++;
			}
			else if(arrayUniNum[i] < 0){
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