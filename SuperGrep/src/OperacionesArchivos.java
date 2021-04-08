import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase que contiene métodos relacionados con ficheros.
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
			System.err.println("\n[El directorio no existe, asegúrese de escribir la ruta correctamente.]\n");
			seleccionarDirectorio(new datosUsuario().rutaDirectorio());
		}
		else {
			directorio = rutaDirectorio;
		}
	}
	
	/**
	 * Asigna una fecha pasada por parámetro a la variable global String fecha.
	 * 
	 * @param fecha
	 */
	public void seleccionarFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Asigna una palabra pasada por parámetro a la variable global String palabra.
	 * 
	 * @param palabra
	 */
	public void seleccionarPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	public void recorrerDirectorio() throws IOException {
		Path p = Paths.get(directorio);
		List<Path> archivos = buscarArchivoPorExtension(p, Constantes.EXTENSION);
		
		for(int i=0; i<archivos.size();i++) {
			try(Scanner sc = new Scanner(archivos.get(i), StandardCharsets.UTF_8);){
				while(sc.hasNext()) {
					System.out.println("Analizando archivo: "+archivos.get(i)+"...");
					if(sc.next().toUpperCase().contains(palabra.toUpperCase())) {
						System.out.println("Palabra: "+'"'+palabra+'"'+" encontrada.*");
						System.out.println("Copiando fichero: "+archivos.get(i)+" a "+Constantes.DIRECTORIO_DESTINO);
						Files.copy(archivos.get(i), Paths.get(Constantes.DIRECTORIO_DESTINO+"\\"+archivos.get(i).getFileName().toString())); // Copiar archivos
						Files.delete(Paths.get(Constantes.DIRECTORIO_DESTINO+"\\"+archivos.get(i).getFileName().toString())); // Borrar archivos
					}
				}
			}
		}
		System.out.println("Número total de archivos analizados: "+archivos.size()+".");
	}
	
	/**
	 * Crea una lista de Path de los archivos encontrados con la extensión que se le pasa por parámetro y la devuelve.
	 * @param archivo
	 * @param extension
	 * @return
	 * @throws IOException
	 */
	private List<Path> buscarArchivoPorExtension(Path archivo, String extension) throws IOException{
		List<Path> listaArchivos;
		
		try(Stream<Path> st = Files.walk(archivo);) {
			listaArchivos = st
					.filter(Files::isRegularFile)
					.filter(p -> p.getFileName().toString().endsWith(extension))
					.collect(Collectors.toList());
		}
		
		return listaArchivos;
	}
	
}
