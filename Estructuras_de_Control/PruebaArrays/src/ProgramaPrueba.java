import java.util.Arrays;

public class ProgramaPrueba {

	public static void main(String[] args) {

		/*
		 * char[] caja = {'a', 'b', 'c'};
		 * 
		 * for(char x: caja) { System.out.println(x); } System.out.println();
		 * 
		 * for(int i=0; i<caja.length; i++) { System.out.println(caja[i]); }
		 * 
		 * int[][] cajaIntegers = {{1, 2, 3}, {4, 5, 6}};
		 * 
		 * for(int i=0; i<cajaIntegers.length; i++) { System.out.println(); for(int j=0;
		 * j<cajaIntegers[i].length; j++) { System.out.print(cajaIntegers[i][j]);
		 * 
		 * } }
		 * 
		 * for (String[] x : arrayDeNombresBi) { System.out.println(); for (String
		 * nombre : x) { System.out.println(nombre + " "); } }
		 

		String[][] arraydeNombresBi = { { "pepe", "juan", "kike" }, { "lou", "kiko", "r. iniesta" },
				{ "e. paramos", "bowie", "pepito" } };

		String[] arraydeNombresUni = { "juan", "kike", "Ernesto" };

		int[] arraydeIntegers = { 6, 3, 8, 1, 2 };
		
		int a = Arrays.binarySearch(arraydeNombresUni, "kikess");
		
		Arrays.sort(arraydeNombresUni);
		Arrays.sort(arraydeIntegers);
		// Arrays.sort(arraydeNombresBi);

		
		 * for(String[] x: arraydeNombresBi) { for(String nombre: x) {
		 * System.out.println(nombre); } }
		 

		imprimeStringUnidimensional(arraydeNombresUni);

		for (int elemento : arraydeIntegers) {
				System.out.println(elemento);
			}
		}

		private static void imprimeStringUnidimensional(String[] arraydeNombresUni) {
			for (String x : arraydeNombresUni) {
				System.out.println(x);
			}
		*/
		
		/*
		int[] comparar1;
		int[] comparar2;
		
		comparar1 = new int[] {1, 2, 3, 4}; // Nota: también se podría haber inicializado de una sola sentencia int[] comparar1 = {1, 2};
		comparar2 = comparar1; // Apuntan a la misma zona de memoria
		
		int comparar3[] = {1, 2, 3, 4};
		
		System.out.println(comparar1 == comparar2);
		System.out.println(comparar1 == comparar3);
		System.out.println(Arrays.equals(comparar1, comparar2));
		System.out.println(Arrays.equals(comparar1,  comparar3));
		
		comparar2[0] = 0;
		
		System.out.println(comparar1[0]);
		*/
		
		int[] num1Ori = {1,2,3}; // Una dimensión y tipo int
		int[] num1Clon = num1Ori.clone(); // Se crea un clon exacto
		int[][] num2Ori = {{1, 2}, {3}}; // Varias dimensiones, entonces contiene arrays que son objetos: num2Ori[0] es un array con 2 elementos
		int[][] num2Clon = num2Ori.clone(); // Se hace un clon pero se clona las direcciones de memoria. Cuidado
		num1Clon[0] = 7;
		num2Clon[0][0] = 25;
		System.out.println(num1Ori == num1Clon); // falso, no tienen la misma dirección de memoria
		System.out.println(num2Ori == num2Clon); // falso, no tienen la misma dirección de memoria
		System.out.println(num1Clon[0]); // 7 se cambió a 7, no afecta a num1Ori.
		System.out.println(num1Ori[0]);// 1
		System.out.println(num2Ori[0][0]); // 25 se cambió num2Clon[0][0] pero aquí se observa que también ha cambiado num2Ori[0][0]
		System.out.println(num2Clon[0][0]); // 25
		
	}
}
