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
		 */

		String[][] arraydeNombresBi = { { "pepe", "juan", "kike" }, { "lou", "kiko", "r. iniesta" },
				{ "e. paramos", "bowie", "pepito" } };

		String[] arraydeNombresUni = { "juan", "kike", "Ernesto" };

		int[] arraydeIntegers = { 6, 3, 8, 1, 2 };

		Arrays.sort(arraydeNombresUni);
		Arrays.sort(arraydeIntegers);
		// Arrays.sort(arraydeNombresBi);

		/*
		 * for(String[] x: arraydeNombresBi) { for(String nombre: x) {
		 * System.out.println(nombre); } }
		 */

		imprimeStringUnidimensional(arraydeNombresUni);

		for (int elemento : arraydeIntegers) {
			System.out.println(elemento);
		}
	}

	private static void imprimeStringUnidimensional(String[] arraydeNombresUni) {
		for (String x : arraydeNombresUni) {
			System.out.println(x);
		}
	}
}
