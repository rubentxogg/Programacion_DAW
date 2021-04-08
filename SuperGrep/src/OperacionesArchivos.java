import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	public void recorrerDirectorio() throws IOException {
		Path p = Paths.get(directorio);
		List<Path> archivos = buscarArchivosPorExtension(p, Constantes.EXTENSION);
		
		for(int i=0; i<archivos.size();i++) {
			System.out.println(fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Analizando archivo: "+archivos.get(i)+"...");
			try(Scanner sc = new Scanner(archivos.get(i), StandardCharsets.UTF_8);){
				while(sc.hasNext()) {
					if(sc.next().toUpperCase().contains(palabra.toUpperCase())) {
						System.out.println(fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Palabra: "+'"'+palabra+'"'+" encontrada.*");
						System.out.println(fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Copiando fichero: "+archivos.get(i)+" a "+Constantes.DIRECTORIO_DESTINO);
						Files.copy(archivos.get(i), Paths.get(Constantes.DIRECTORIO_DESTINO+"\\"+archivos.get(i).getFileName().toString()));
						break;
					}
				}
			}
		}
		System.out.println(fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - N�mero total de archivos analizados: "+archivos.size()+".");
	}
	
	/**
	 * Borra todos los archivos que se encuentran en el directorio pasado por par�metro.
	 * 
	 * @throws IOException
	 */
	public void vaciarDirectorio(String directorio) throws IOException {
		Path p = Paths.get(directorio);
		List<Path> archivos = buscarArchivosPorExtension(p, Constantes.CUALQUIER_EXTENSION);
		
		for(int i=0; i<archivos.size();i++) {
			Files.delete(Paths.get(directorio+"\\"+archivos.get(i).getFileName().toString()));
		}
	}
	
	/**
	 * Crea una lista de Path de los archivos encontrados con la extensi�n que se le pasa por par�metro y la devuelve.
	 * @param archivo
	 * @param extension
	 * @return
	 * @throws IOException
	 */
	private List<Path> buscarArchivosPorExtension(Path archivo, String extension) throws IOException{
		List<Path> listaArchivos;
		
		try(Stream<Path> st = Files.walk(archivo);) {
			listaArchivos = st
					.filter(Files::isRegularFile)
					.filter(p -> p.getFileName().toString().endsWith(extension))
					.collect(Collectors.toList());
		}
		
		return listaArchivos;
	}
	
	/**
	 * M�todo que devuelve una fecha con el tipo de formato pasado por par�metro.
	 * 
	 * @param formatoFecha
	 * @return
	 */
	public String fechaActual(String formatoFecha) {
		Date date = new Date();
		SimpleDateFormat fechaActual = new SimpleDateFormat(formatoFecha);
		return fechaActual.format(date);
	}
}