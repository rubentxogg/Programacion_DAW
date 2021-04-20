import java.util.Arrays;

public class ImperativeWay {
	
	/**
	 * Método que lo que hará es recibir por parámetro un array de String y un string.
	 * El método devolverá void y lo que hará es filtrar todos los elementos que del array que empiecen por el string que le hemos pasado por parámetro, 
	 * luego los ordenará y luego los imprimirá. 
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
	 * El método recibirá un array de int, calculará los cuadrados de cada uno de los elementos y 
	 * posteriormente calculará la media de esos números. 
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
	 * Convierte a todos los strings del array a minúsculas, filtra los que empiecen con el String s que le pasamos por parámetro y los imprime. 
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
		
		arrayAux = new String[cont]; // Creo el array auxiliar con un máximo de elementos cont
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
