import java.util.Arrays;

public class FunctionalWay {
	

	/**
	 * M�todo que lo que har� es recibir por par�metro un array de String y un string.
	 * El m�todo devolver� void y lo que har� es filtrar todos los elementos que del array que empiecen por el string que le hemos pasado por par�metro, 
	 * luego los ordenar� y luego los imprimir�. 
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
	 * El m�todo recibir� un array de int, calcular� los cuadrados de cada uno de los elementos y 
	 * posteriormente calcular� la media de esos n�meros. 
	 * @param numeros
	 */
	public void calculaCuadradoyMedia(int [] numeros) {
		Arrays.stream(numeros)
			.map(x -> x*x)
			.average()
			.ifPresent(x -> System.out.println((int) x));
	}
	
	/**
	 * Convierte a todos los strings del array a min�sculas, filtra los que empiecen con el String s que le pasamos por par�metro y los imprime. 
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
