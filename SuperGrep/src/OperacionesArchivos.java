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
	
	public void recorrerDirectorio() throws IOException { //TODO
		Path p = Paths.get(directorio);
		List<Path> directorios = listarDirectorios(p);
		List<Path> archivos;
		int numArchivosAnalizados = 0;
		
		for(int j=0; j<directorios.size(); j++) {
			archivos = buscarArchivosPorExtension(directorios.get(j), Constantes.EXTENSION);
			System.out.println(fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Analizando directorio "+directorios.get(j));
			for(int i=0; i<archivos.size(); i++) {
				System.out.println(fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Analizando archivo: "+archivos.get(i)+"...");
				numArchivosAnalizados++;
				try(Scanner sc = new Scanner(archivos.get(i), StandardCharsets.UTF_8);){
					while(sc.hasNext()) {
						if(sc.next().toUpperCase().contains(palabra.toUpperCase())) {
							System.out.println(fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Palabra: "+'"'+palabra+'"'+" encontrada. [!]");
							System.out.println(fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Copiando fichero: "+archivos.get(i)+" a "+Constantes.DIRECTORIO_DESTINO);
							Files.copy(archivos.get(i), Paths.get(Constantes.DIRECTORIO_DESTINO+"\\"+archivos.get(i).getFileName().toString()));
							break;
						}
					}
				}
			}
		}
		System.out.println(fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Número total de archivos analizados: "+numArchivosAnalizados+".");
		System.out.println(fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Número total de directorios analizados: "+directorios.size()+".");
	}
	
	/**
	 * Borra todos los archivos que se encuentran en el directorio pasado por parámetro.
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
	 * Crea una lista de Path de los archivos encontrados en la ruta pasada por parámetro con la extensión especificada y la devuelve.
	 * 
	 * @param archivo
	 * @param extension
	 * @return
	 * @throws IOException
	 */
	private List<Path> buscarArchivosPorExtension(Path archivo, String extension) throws IOException{
		List<Path> listaArchivos;
		
		try(Stream<Path> st = Files.walk(archivo, 1);) {
			listaArchivos = st
					.filter(Files::isRegularFile)
					.filter(p -> p.getFileName().toString().endsWith(extension))
					.collect(Collectors.toList());
		}
		
		return listaArchivos;
	}
	
	
    /**
     * Crea una lista de Path de los directorios y subdirectorios encontrados a partir de la ruta pasada por parámetro y la devuelve.
     * 
     * @param path
     * @return
     * @throws IOException
     */
    private List<Path> listarDirectorios(Path path) throws IOException {
        List<Path> listaDirectorios;
        
        try (Stream<Path> st = Files.walk(path)) {
            listaDirectorios = st.filter(Files::isDirectory)
                    .collect(Collectors.toList());
        }
        return listaDirectorios;
    }
	
	/**
	 * Método que devuelve una fecha con el tipo de formato pasado por parámetro.
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
