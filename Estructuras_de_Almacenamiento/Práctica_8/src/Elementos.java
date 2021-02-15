/**
 * @author Rubentxo
 * Clase que contendr� m�todos sobre arrays
 */
public class Elementos {
	
	/**
	 * M�todo de ordenamiento bubble sort
	 * @param Introducir array
	 * @return array
	 */
	public static int[] ordenarElementosManual(int[] array) { 
		int aux = 0;
		
// Array->		 5  1  3  7  9  4
// Index->		 0  1  2  3  4  5
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length;j++) {
				if(array[i] < array[j]) {
					aux = array[j];
					array[j] = array[i];
					array[i] = aux;
				}
			}
		}
		
		System.out.println("--------------------------------------------------------");
		System.out.print("Array ordenado manualmente: ");
		for(int x : array) {
			System.out.print(x+" ");
		}
		
		System.out.println("\n--------------------------------------------------------\n");
		return array;
	}
	
	/**
	 * Devuelve la posici�n si se ha encontrado y un n�mero negativo si no se encuentra
	 * @param array
	 * @return
	 */
	public static int buscarElementosManual(int[] array, int element) {
		int index = -1;
		
		for(int x : array) {
			index++;
			if(element == x) {
				System.out.println("--------------------------------------------------------");
				System.out.println("Se ha encontrado el elemento "+element+" en la posici�n: "+index);
				System.out.println("--------------------------------------------------------\n");
				return index;
			}
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("No se ha podido encontrar el elemento.");
		System.out.println("--------------------------------------------------------\n");
		return -1;
	}
	
	/**
	 * @param array
	 * M�todo que acepta un array y muestra por pantalla los elementos con un bucle for-each
	 */
	public static void mostrarElementosManual(int[] array) {
		System.out.println("--------------------------------------------------------");
		System.out.print("Mostrando el array: ");
		for(int x : array) {
			System.out.print(x+" ");
		}
		System.out.println("\n--------------------------------------------------------");
	}
	
	/**
	 * Creando un array con un mill�n de n�meros enteros
	 */
	public static void createArray() {
		int[] array = new int[1000000];
		
		for(int x : array) {
			array[x] = (int) Math.random()*11;
			System.out.print(x+" ");
		}
	}
}
