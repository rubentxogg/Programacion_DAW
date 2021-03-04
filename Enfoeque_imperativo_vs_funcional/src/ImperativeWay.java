import java.util.Arrays;

public class ImperativeWay {
	
	/**
	 * M�todo que lo que har� es recibir por par�metro un array de String y un string.
	 * El m�todo devolver� void y lo que har� es filtrar todos los elementos que del array que empiecen por el string que le hemos pasado por par�metro, 
	 * luego los ordenar� y luego los imprimir�. 
	 * @param nombres
	 * @param c
	 */
	public void filtraOrdenaImprime(String[] nombres, String c) {
		String[] arrayAux = null; // Array auxiliar
		int cont = 0; // Contador
		
		for(String x : nombres) {
			
			if(x.startsWith(c)) {
				cont++;
			}
		}
		
		arrayAux = new String[cont]; // Le ponemos la longitud del contador al array auxiliar
		cont = 0; // Volvemos a poner el contador a 0;
		
		for(String x : nombres) {
			
			if(x.startsWith(c)) {
				arrayAux[cont] = x;
				cont++;
			}
		}
		
		Arrays.sort(arrayAux); // Ordenamos el array
		
		for(String x : arrayAux) { // Imprimimos el array
			System.out.println(x);
		}
	}
	
	/**
	 * El m�todo recibir� un array de int, calcular� los cuadrados de cada uno de los elementos y 
	 * posteriormente calcular� la media de esos n�meros. 
	 * @param numeros
	 */
	public void calculaCuadradoyMedia(int [] numeros) {
		int media = 0;
		
		for(int x : numeros) {
			
			x *= x; // Hallo el cuadrado de cada elemento
			media = media + x; // Sumo el cuadrado de cada elemento a media
		}
		
		media = media / numeros.length; // Divido la suma de los elementos entre la longitud del array
		System.out.println(media);	
	}
	
	/**
	 * Convierte a todos los strings del array a min�sculas, filtra los que empiecen con el String s que le pasamos por par�metro y los imprime. 
	 * @param nombres
	 * @param s
	 */
	public void convierteAMinusculasFiltra(String[] nombres, String s) {
		String[] arrayAux = null; // Array auxiliar
		int cont = 0;
		
		for(String x : nombres) {
			if(x.startsWith(s)) {
				cont++;
			}
		}
		
		arrayAux = new String[cont]; // Creo el array auxiliar con un m�ximo de elementos cont
		cont = 0; // Contador a 0
		
		for(String x : nombres) {
			if(x.startsWith(s)) {
				arrayAux[cont] = x;
				cont++;
			}
		}
		
		
		for(String x : arrayAux) {
			x = x.toLowerCase();
			System.out.println(x);
		}
		
	}
}
