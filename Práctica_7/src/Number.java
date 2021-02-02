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
			System.out.print("¿Qué tipo de array desea crear?"
					+"\n1.- Unidimensional"
					+"\n2.- Bidimensional"
					+"\nSeleccione una opción: ");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1: arrayUnidimensional();
				break;
				
				case 2: arrayBidimensional();
				break;
				
				default: System.out.println("-----------------------------------------------------------------");
						 System.out.println("Ha seleccionado una opción inválida, vuelva a intentarlo.");
						 System.out.println("-----------------------------------------------------------------");
						 break;
			}
			
			
		}while((opc != 1) && (opc != 2));
		
		
	}
	
	/**
	 * Método que crea un array bidimensional y lo rellena de números aleatorios
	 */
	public void arrayBidimensional() {
		Scanner sc = new Scanner(System.in);
		int filas, columnas;
		
		System.out.println("-----------------------------------------------------------------");
		System.out.print("Introduzca la cantidad de filas que desea introducir: ");
		filas = sc.nextInt();
	
		System.out.print("Introduzca la cantidad de columnas que desea introducir: ");
		columnas = sc.nextInt();
		arrayBiNum = new int[filas][columnas];
		
		
		for(int i=0;i<arrayBiNum.length;i++) {
			for(int j=0;j<arrayBiNum[i].length;j++) {
				arrayBiNum[i][j] = (int) (Math.random()* 10);
			}	
		}
		
		System.out.println("-----------------------------------------------------------------"
				+ "\nArray bidimensional:");
		for(int[] x: arrayBiNum) {
			System.out.println();
			for(int num: x) {
				System.out.print(num+" ");
			}
		}
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		
		mediaNum(arrayBiNum);
		sumaNum(arrayBiNum);
		productNum(arrayBiNum);
		mayorNum(arrayBiNum);
		menorNum(arrayBiNum);
		positivNum(arrayBiNum);
		sc.close();
	}
	
	
	/**
	 * Método que crea un array unidimensional y lo rellena de números pasados por el usuario
	 */
	public void arrayUnidimensional() {
		Scanner sc = new Scanner(System.in);
		int cantidad;
		
		System.out.println("-----------------------------------------------------------------");
		System.out.print("Introduzca la cantidad de números que desea introducir: ");
		cantidad = sc.nextInt();
		arrayUniNum = new int[cantidad];
		
		for(int i=0;i<arrayUniNum.length;i++) {
			System.out.print("Introduzca un número: ");
			arrayUniNum[i] = sc.nextInt();
		}
		
		System.out.println("-----------------------------------------------------------------"
				+ "\nArray unidimensional:\n");
		System.out.println(Arrays.toString(arrayUniNum));
		System.out.println("-----------------------------------------------------------------");
		
		mediaNum(arrayUniNum);
		sumaNum(arrayUniNum);
		productNum(arrayUniNum);
		mayorNum(arrayUniNum);
		menorNum(arrayUniNum);
		positivNum(arrayUniNum);
		sc.close();
	}
	
	/**
	 * Método que halla la media de los números del array unidimensional
	 */
	public void mediaNum(int[] arrayUniNum) {
		int media = 0;
		for(int i=0;i<arrayUniNum.length;i++) {
			media += arrayUniNum[i];
		}
		media = media / arrayUniNum.length;
		System.out.println("La media es: "+media);
	}
	
	/**
	 * Método que halla la media de los números del array bidimensional
	 */
	public void mediaNum(int[][] arrayBiNum) {
		int media = 0, tot = 0;
		for(int i=0;i<arrayBiNum.length;i++) {
			for(int j=0;j<arrayBiNum[i].length;j++,tot++)
				media += arrayBiNum[i][j];
		}
		media = media / tot;
		System.out.println("La media es: "+media);
	}
	
	
	/**
	 * Método que halla la suma de los números del array unidimensional
	 */
	public void sumaNum(int[] arrayUniNum) {
		int suma = 0;
		for(int i=0;i<arrayUniNum.length;i++) {
			suma += arrayUniNum[i];
		}
		System.out.println("La suma es: "+suma);
	}
	
	/**
	 * Método que halla la suma de los números del array bidimensional
	 */
	public void sumaNum(int[][] arrayBiNum) {
		int suma = 0;
		for(int i=0;i<arrayBiNum.length;i++) {
			for(int j=0;j<arrayBiNum[i].length;j++)
			suma += arrayBiNum[i][j];
		}
		System.out.println("La suma es: "+suma);
	}


	/**
	 * Método que halla el producto de los números del array unidimensional
	 */
	public void productNum(int[] arrayUniNum) {
		int producto = 1;
		for(int i=0;i<arrayUniNum.length;i++) {
			producto = producto * arrayUniNum[i];
		}
		System.out.println("El producto es: "+producto);
		System.out.println("-----------------------------------------------------------------");
	}
	
	/**
	 * Método que halla el producto de los números del array bidimensional
	 */
	public void productNum(int[][] arrayBiNum) {
		int producto = 1;
		for(int i=0;i<arrayBiNum.length;i++) {
			for(int j=0;j<arrayBiNum[i].length;j++)
			producto = producto * arrayBiNum[i][j];
		}
		System.out.println("El producto es: "+producto);
		System.out.println("-----------------------------------------------------------------");
	}
	
	/**
	 * Método que calcula el mayor número del array unidimensional
	 */
	public void mayorNum(int[] arrayUniNum) {
		Arrays.sort(arrayUniNum);
		System.out.println("El mayor número es: "+arrayUniNum[arrayUniNum.length-1]);
	}
	
	/**
	 * Método que calcula el mayor número del array bidimensional
	 */
	public void mayorNum(int[][] arrayBiNum) {
		int numMay = 0;
		for(int i=0;i<arrayBiNum.length;i++) {
			for(int j=0;j<arrayBiNum[i].length;j++) {
				if(numMay < arrayBiNum[i][j]) {
					numMay = arrayBiNum[i][j];
				}
			}	
		}
		System.out.println("El mayor número es: "+numMay);
	}
	
	/**
	 * Método que calcula el menor número del array unidimensional
	 */
	public void menorNum(int[] arrayUniNum) {
		Arrays.sort(arrayUniNum);
		System.out.println("El menor número es: "+arrayUniNum[0]);
		System.out.println("-----------------------------------------------------------------");
	}
	
	/**
	 * Método que calcula el menor número del array bidimensional
	 */
	public void menorNum(int[][] arrayBiNum) {
		int numMen = 999;
		for(int i=0;i<arrayBiNum.length;i++) {
			for(int j=0;j<arrayBiNum[i].length;j++) {
				if(numMen > arrayBiNum[i][j]) {
					numMen = arrayBiNum[i][j];
				}

			}	
		}
		System.out.println("El menor número es: "+numMen);
	}
	
	/**
	 * Mostrar la cantidad de números positivos introducidos del array unidimensional
	 */
	public void positivNum(int[] arrayUniNum) {
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
						+"\n-----------------------------------------------------------------");
	}
	
	/**
	 * Mostrar la cantidad de números positivos introducidos del array bidimensional
	 */
	public void positivNum(int[][] arrayBiNum) {
		int cantPositiv = 0, cantNegativ = 0, cantCeros = 0;
		
		for(int i=0;i<arrayBiNum.length;i++) {
			for(int j=0;j<arrayBiNum[i].length;j++) {
				if(arrayBiNum[i][j] > 0) {
					cantPositiv++;
				}
				else if(arrayBiNum[i][j] < 0){
					cantNegativ++;
				}
				else {
					cantCeros++;
				}
			}
		}
		System.out.println("La cantidad de números positivos introducidos es: "+cantPositiv
						+"\nLa cantidad de números negativos introducidos es: "+cantNegativ
						+"\nLa cantidad de ceros introducidos es: "+cantCeros
						+"\n-----------------------------------------------------------------");
	}
	
}