import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rubentxo
 * Contiene métodos relacionados con ficheros.
 */
public class OperacionesFicheros {
	private Scanner scReader;
	private int cont = 0;
	private int posContador=0;
	static int[] contadores;
	
	/**
	 * Método que busca las palabras de un fichero en otro y cuenta el número de veces que aparecen,
	 * independientemente de que la palabra se pueda encontrar dentro de otra.
	 * @param ficheroPalabras Fichero con las palabras a buscar.
	 * @param ficheroTexto Fichero donde queremos buscar las palabras.
	 * @throws IOException
	 */
	public void buscarPalabras(String ficheroPalabras, String ficheroTexto) throws IOException {
		asigNumElementosArrayContadores(ficheroPalabras);
		Path p1 = Paths.get(ficheroPalabras);
		Path p2 = Paths.get(ficheroTexto);
		String palabra;
		String texto;
		
		try(Scanner sc = new Scanner(p1,StandardCharsets.UTF_8);) {
			while(sc.hasNext()) {
				palabra = sc.next();
				crearScanner(p2);
				while(scReader.hasNext()) {
					texto = scReader.next();
					incrementarContador(palabra, texto);
				}
				mostrarNumOcurrencias(palabra, cont);
				guardarContadores(cont);
				cont = 0;
			}
		}
	}
	
	/**
	 * Este método crea un objeto Scanner a partir del objeto path que se le pasa por parámetro
	 * @param p Objeto Path
	 * @throws IOException
	 */
	private void crearScanner(Path p) throws IOException {
		scReader = new Scanner(p, StandardCharsets.UTF_8);
	}
	
	
	/**
	 * Método que muestra el número de veces que aparece la palabra indicada en el mismo.
	 * @param palabra Palabra a contar.
	 * @param cont Número de ocurrencias de la palabra.
	 */
	private void mostrarNumOcurrencias(String palabra, int cont) {
		System.out.println(palabra+": "+cont);
	}

	
	/**
	 * Si la palabra proporcionada se encuentra en el texto, se incrementará el contador.
	 * @param palabra
	 * @param texto
	 */
	private void incrementarContador(String palabra, String texto) {
		if(texto.toLowerCase().contains(palabra.toLowerCase())){
			cont++;
		}
	}
	
	/**
	 * Método que guarda en un array las palabras que encuentra en el fichero y lo devuelve.
	 * @param ficheroPalabras 
	 * @return Devuelve un array de palabras.
	 * @throws IOException
	 */
	public String[] guardarPalabras(String ficheroPalabras) throws IOException {
		Path p = Paths.get(ficheroPalabras);
		String[] palabras;
		int i = 0;
		
		crearScanner(p);
		while(scReader.hasNext()) {
			scReader.next();
			i++;
		}
		palabras = new String[i];
		i = 0;
		crearScanner(p);
		while(scReader.hasNext()) {
			palabras[i] = scReader.next();
			i++;
		}
		return palabras;
	}
	
	/**
	 * Éste método guarda en un array estático de tipo int los contadores generados.
	 * @param cont El contador que se va a guardar en el array.
	 */
	private void guardarContadores(int cont) {
		OperacionesFicheros.contadores[posContador] = cont;
		posContador++;
	}
	
	/**
	 * Cuenta el número de palabras de un fichero y asigna el número de elementos del array de contadores.
	 * @param ficheroPalabras Fichero donde contar el número de palabras.
	 * @throws IOException
	 */
	private void asigNumElementosArrayContadores(String ficheroPalabras) throws IOException {
		int numPalabras = 0;
		Path p = Paths.get(ficheroPalabras);
		
		crearScanner(p);
		while(scReader.hasNext()) {
			scReader.next();
			numPalabras++;
		}
		OperacionesFicheros.contadores = new int[numPalabras];
	}
	
	/**
	 * Convierte un array de tipo Int a un array de tipo String y lo devuelve.
	 * @param arrayInt
	 * @return
	 */
	public String[] conversorArrayIntToArrayString() {
		return Arrays.toString(OperacionesFicheros.contadores).split("[\\[\\]]")[1].split(", ");
	}
}
