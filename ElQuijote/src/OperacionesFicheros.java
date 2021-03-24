import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Rubentxo
 * Contiene m�todos relacionados con ficheros.
 */
public class OperacionesFicheros {
	
	/**
	 * M�todo que lee el fichero que se le pasa por par�metro.
	 * @param url Ruta absoluta del fichero a leer.
	 * @throws IOException 
	 */
	public void leerFichero(String url) throws IOException {
		Path p = Paths.get(url);
		try (BufferedReader bReader = Files.newBufferedReader(p, StandardCharsets.UTF_8);) {
			
			String linea;
			while((linea = bReader.readLine()) != null) {
				System.out.println(linea);
			}
		}
	}
	
//	public void buscarPalabras(String palabra) {
//		try (BufferedReader bReader = new BufferedReader(new FileReader(url, StandardCharsets.UTF_8));) {
//			
//			String linea;
//			palabra = "caballer�as";
//			while((linea = bReader.readLine()) != null) {
//				System.out.println(linea);
//				
//				String[] palabras = linea.split(" ");
//				
//				for(int i=0;i<palabras.length;i++) {
//					if(palabras[i].equals(palabra)) {
//						cont++;
//					}
//				}
//			}
//		}
//	}
}
