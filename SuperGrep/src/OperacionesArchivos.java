import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase que contiene m�todos relacionados con ficheros.
 * 
 * @author Rubentxo
 */
public class OperacionesArchivos {
	private String directorio;
	private String fecha;
	private String palabra;
	
	/**
	 * Comprueba que la ruta proporcionada sea un directorio y la asigna a la variable global String directorio.
	 * 
	 * @param rutaDirectorio
	 */
	public void seleccionarDirectorio(String rutaDirectorio) {
		Path p = Paths.get(rutaDirectorio);
		
		if(!Files.isDirectory(p)) {
			System.err.println("\n[El directorio no existe, aseg�rese de escribir la ruta correctamente.]\n");
			seleccionarDirectorio(new datosUsuario().rutaDirectorio());
		}
		else {
			directorio = rutaDirectorio;
		}
	}
	
	/**
	 * Asigna una fecha pasada por par�metro a la variable global String fecha.
	 * 
	 * @param fecha
	 */
	public void seleccionarFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Asigna una palabra pasada por par�metro a la variable global String palabra.
	 * 
	 * @param palabra
	 */
	public void seleccionarPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	// TODO
	public void recorrerDirectorio() throws IOException {
		Files.walk(Paths.get(directorio))
        .filter(Files::isRegularFile)
        .forEach(System.out::println); 
		
	}
}
