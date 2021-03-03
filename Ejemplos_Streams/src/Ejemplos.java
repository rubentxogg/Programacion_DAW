import java.util.Arrays;

/**
 * @author Rubén García
 * Ejemplos del método stream
 */
public class Ejemplos {
	
	// Método main
	public static void main(String[] args) {
		int arrayDeNumeros[] = {14, 24, 344, 44, 35, 336, 73, 338, 39, 110};
		int arrayNumeros[] = {1, 5, 6, 9};
		
		// Saltar los 5 primeros elementos del array
		Arrays.stream(arrayDeNumeros)
			.skip(5)
			.forEach(x -> System.out.println(x));
		
		// Sumar todos los elementos del array
		System.out.println("\n"+Arrays.stream(arrayDeNumeros)
			.sum());
		
		// Map, multiplica cada elemento por si mismo
		System.out.println();
		Arrays.stream(arrayNumeros)
			.map(x -> x * x)
			.forEach(System.out::println);
		
		// Map, asignamos al nuevoArray los elementos de arrayNumeros multipliados por si mismos
		int[] nuevoArray = Arrays.stream(arrayNumeros)
				.map(x -> x * x)
				.toArray();
		System.out.println();
		Arrays.stream(nuevoArray)
		.forEach(System.out::println);
		
		// FlatMap
		Integer [][] arrayNumerosBi = {{1, 3}, {5, 8}, {10, 4}};
		
		Arrays.stream(arrayNumerosBi)
		.flatMap(x -> Arrays.stream(x))
	}
}
