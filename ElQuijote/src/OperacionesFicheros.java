import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Rubentxo
 * Contiene métodos relacionados con ficheros.
 */
public class OperacionesFicheros {
	BufferedReader br;
	
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
		
		try(BufferedReader br1 = Files.newBufferedReader(p1,StandardCharsets.UTF_8);) {
			crearBufferReader(p2);
			while((palabra = br1.readLine()) != null) {
				while((texto = br.readLine()) != null) {
					if(texto.toLowerCase().contains(palabra.toLowerCase())){
						switch(palabra.toLowerCase()) {
							case "quijote": contQuijote++;
								break;
							case "sancho": contSancho++;
								break;
							case "respondió": contRespondio++;
								break;
							case "dios": contDios++;
								break;
							case "don": contDon++;
								break;
							case "merced": contMerced++;
								break;
							case "caballero": contCaballero++;
								break;
							case "señora": contSenora++;
								break;
							case "verdad": contVerdad++;
								break;
							case "mundo": contMundo++;
								break;
						}
					}
				}
				crearBufferReader(p2);
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
	 * Este método crea un objeto bufferedReader a partir del fichero que se le pasa por parámetro
	 * @param p Objeto Path
	 * @throws IOException
	 */
	private void crearBufferReader(Path p) throws IOException {
		br = Files.newBufferedReader(p, StandardCharsets.UTF_8);
	}
}
