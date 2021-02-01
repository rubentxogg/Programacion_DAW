
/**
 * @author Rubentxo
 * Arrays predefinidos para la pr�ctica 6 de programaci�n
 */
public class ArraysPred {
	
	/**
	 * M�todo que llama a los m�todos arrayBi() y arrayTri()
	 */
	public void ejercicioArrays() {
		arrayBi();
		arrayTri();
	}
	
	/**
	 * M�todo que crea un array bidimensional predefinido y lo muestra por pantalla
	 */
	public void arrayBi() {
		int[][] bi = {{2,3,1,4},{5,2,7,3},{3,4,9,1},{5,2,1,7}};
		System.out.println("------------------------------------");
		System.out.println("Array bidimensional:");
		for(int[] x: bi) { // Fila
			System.out.println();
			for(int num: x) { // Elemento
				System.out.print(num+" ");
			}
		}
		System.out.println();
	}
		
	
	/**
	 * M�todo que crea un array bidimensional predefinido y lo muestra por pantalla
	 */
	public void arrayTri() {
		int[][][] tri = {{{2,3,1,4},{5,2,7,3}},{{3,4,9,1},{5,2,1,7}}};
		System.out.println("------------------------------------");
		System.out.println("Array tridimensional:");
		 for (int[][] x: tri) { // Tabla
			 System.out.println();
	            for (int[] y: x) { // Fila
	            	System.out.println();
	                for(int z: y) { // Elemento
	                    System.out.print(z+" ");
	                }
	            }
	        }
	    }
		
		
}

