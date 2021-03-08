import java.util.Arrays;

public class FunctionalWay {
	

	/**
	 * Método que lo que hará es recibir por parámetro un array de String y un string.
	 * El método devolverá void y lo que hará es filtrar todos los elementos que del array que empiecen por el string que le hemos pasado por parámetro, 
	 * luego los ordenará y luego los imprimirá. 
	 * @param nombres
	 * @param c
	 */
	public void filtraOrdenaImprime(String[] nombres, String c) {
		Arrays.stream(nombres) // Creo el flujo del array
			.filter(x -> x.startsWith(c))  // Lo filtro
			.sorted()  // Lo ordeno
			.forEach(System.out::println); // Lo imprimo
	}
	
	/**
	 * El método recibirá un array de int, calculará los cuadrados de cada uno de los elementos y 
	 * posteriormente calculará la media de esos números. 
	 * @param numeros
	 */
	public void calculaCuadradoyMedia(int [] numeros) {
		Arrays.stream(numeros)
			.map(x -> x*x)
			.average()
			.ifPresent(x -> System.out.println((int) x));
	}
	
	/**
	 * Convierte a todos los strings del array a minúsculas, filtra los que empiecen con el String s que le pasamos por parámetro y los imprime. 
	 * @param nombres
	 * @param s
	 */
	public void convierteAMinusculasFiltra(String[] nombres, String s) {
		Arrays.stream(nombres)
			.filter(x -> x.startsWith(s))
			.map(x -> x.toLowerCase())
			.forEach(System.out::println);;
	}
}
