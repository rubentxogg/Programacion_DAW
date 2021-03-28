import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Rubentxo
 * Contiene métodos relacionados con ficheros.
 */
public class OperacionesFicheros {
	Scanner scr;
	
	// Contadores
	private int contQuijote;
	private int contSancho;
	private int contRespondio;
	private int contDios;
	private int contDon;
	private int contMerced;
	private int contCaballero;
	private int contSenora;
	private int contVerdad;
	private int contMundo;
	
	/**
	 * Método que busca las palabras de un fichero en otro y cuenta el número de veces que aparecen,
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
				while(scr.hasNext()) {
					texto = scr.next();
					if(texto.toLowerCase().contains(palabra.toLowerCase())){
						incrementarContador(palabra);
					}
				}
				crearScanner(p2);
			}
			System.out.println("Quijote: "+contQuijote);
			System.out.println("Sancho: "+contSancho);
			System.out.println("Respondió: "+contRespondio);
			System.out.println("Dios: "+contDios);
			System.out.println("Don: "+contDon);
			System.out.println("Merced: "+contMerced);
			System.out.println("Caballero: "+contCaballero);
			System.out.println("Señora: "+contSenora);
			System.out.println("Verdad: "+contVerdad);
			System.out.println("Mundo: "+contMundo);
		}
	}

	/**
	 * Si la palabra se encuentra indicada dentro del condicional, se incrementará su contador específico.
	 * @param palabra Palabra a comprobar.
	 */
	private void incrementarContador(String palabra) {
		switch(palabra.toLowerCase()) {
			case "quijote": 
				contQuijote++;
				break;
			case "sancho": 
				contSancho++;
				break;
			case "respondió": 
				contRespondio++;
				break;
			case "dios": 
				contDios++;
				break;
			case "don": 
				contDon++;
				break;
			case "merced": 
				contMerced++;
				break;
			case "caballero":
				contCaballero++;
				break;
			case "señora": 
				contSenora++;
				break;
			case "verdad":
				contVerdad++;
				break;
			case "mundo": 
				contMundo++;
				break;
			default: 
				System.err.println("No se ha incrementado el contador de la palabra indicada.");
		}
	}
	
	/**
	 * Este método crea un objeto Scanner a partir del fichero que se le pasa por parámetro
	 * @param p Objeto Path
	 * @throws IOException
	 */
	private void crearScanner(Path p) throws IOException {
		scr = new Scanner(p, StandardCharsets.UTF_8);
	}
}
