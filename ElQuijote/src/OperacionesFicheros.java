import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Rubentxo
 * Contiene m�todos relacionados con ficheros.
 */
public class OperacionesFicheros {
	private Scanner scReader;
	private int cont;
	
	/**
	 * M�todo que busca las palabras de un fichero en otro y cuenta el n�mero de veces que aparecen,
	 * independientemente de que la palabra se pueda encontrar dentro de otra.
	 * @param ficheroPalabras Fichero con las palabras a buscar.
	 * @param ficheroTexto Fichero donde queremos buscar las palabras.
	 * @throws IOException
	 */
	public void buscarPalabras(String ficheroPalabras, String ficheroTexto) throws IOException {
		Path p1 = Paths.get(ficheroPalabras);
		Path p2 = Paths.get(ficheroTexto);
		String palabra;
		String texto;
		
		try(Scanner sc = new Scanner(p1,StandardCharsets.UTF_8);) {
			crearScanner(p2);
			while(sc.hasNext()) {
				palabra = sc.next();
				while(scReader.hasNext()) {
					texto = scReader.next();
					incrementarContador(palabra, texto);
				}
				crearScanner(p2);
				mostrarNumOcurrencias(palabra, cont);
				cont = 0;
			}
			
		}
	}
	
	/**
	 * Este m�todo crea un objeto Scanner a partir del fichero que se le pasa por par�metro
	 * @param p Objeto Path
	 * @throws IOException
	 */
	private void crearScanner(Path p) throws IOException {
		scReader = new Scanner(p, StandardCharsets.UTF_8);
	}
	
	
	/**
	 * M�todo que muestra el n�mero de veces que aparece la palabra indicada en el mismo.
	 * @param palabra Palabra a contar.
	 * @param cont N�mero de ocurrencias de la palabra.
	 */
	private void mostrarNumOcurrencias(String palabra, int cont) {
		System.out.println(palabra+": "+cont);
	}

	
	/**
	 * Si la palabra proporcionada se encuentra en el texto, se incrementar� el contador.
	 * @param palabra
	 * @param texto
	 */
	private void incrementarContador(String palabra, String texto) {
		if(texto.toLowerCase().contains(palabra.toLowerCase())){
			cont++;
		}
	}
	
}
