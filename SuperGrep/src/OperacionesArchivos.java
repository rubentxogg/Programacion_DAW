import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.text.ParseException;
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
			seleccionarDirectorio(new DatosUsuario().rutaDirectorio());
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
	
	public void recorrerDirectorio(String destinoLog) throws IOException { //TODO
		Path p = Paths.get(directorio);
		List<Path> directorios = listarDirectorios(p);
		List<Path> archivos;
		int numArchivosAnalizados = 0;
		int numArchivoRepetido = 2;
		
		for(int j=0; j<directorios.size(); j++) {
			archivos = buscarArchivosPorExtension(directorios.get(j), Constantes.EXTENSION);
			anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Analizando directorio "+directorios.get(j));
			for(int i=0; i<archivos.size(); i++) {
				anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Analizando archivo: "+archivos.get(i)+"...");
				numArchivosAnalizados++;
				try(Scanner sc = new Scanner(archivos.get(i), StandardCharsets.UTF_8);){
					while(sc.hasNext()) {
						if(sc.next().equalsIgnoreCase(palabra)) {
							System.out.println("Palabra encontrada en el fichero: "+archivos.get(i));
							anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Palabra: "+'"'+palabra+'"'+" encontrada. [!]");
							anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Copiando fichero: "+archivos.get(i)+" a "+Constantes.DIRECTORIO_DESTINO);
							
							Path pathDestino = Paths.get(Constantes.DIRECTORIO_DESTINO+"\\"+archivos.get(i).getFileName().toString());
							
							if(!Files.exists(pathDestino)) {
								Files.copy(archivos.get(i), Paths.get(Constantes.DIRECTORIO_DESTINO+"\\"+archivos.get(i).getFileName().toString()));
							}
							else {
								Files.copy(archivos.get(i), Paths.get(borrarExtensionArchivo(Constantes.DIRECTORIO_DESTINO+"\\"+archivos.get(i).getFileName().toString())+" ("+numArchivoRepetido+")"+Constantes.EXTENSION));
								numArchivoRepetido++;
							}
							break;
						}
					}
				}
			}
		}
		anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Número total de archivos analizados: "+numArchivosAnalizados+".");
		anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Número total de directorios analizados: "+directorios.size()+".");
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
			
			if(fecha.isEmpty()) {
				listaArchivos = st
						.filter(Files::isRegularFile)
						.filter(p -> p.getFileName().toString().endsWith(extension))
						.collect(Collectors.toList());
				return listaArchivos;
			}
			else {
				listaArchivos = st
						.filter(Files::isRegularFile)
						.filter(p -> convertirStringDate(fechaCreacionArchivo(p), Constantes.FORMATO_FECHA).after(convertirStringDate(fecha, Constantes.FORMATO_FECHA)) ||
									convertirStringDate(fechaCreacionArchivo(p), Constantes.FORMATO_FECHA).equals(convertirStringDate(fecha, Constantes.FORMATO_FECHA)))
						.filter(p -> p.getFileName().toString().endsWith(extension))
						.collect(Collectors.toList());
				return listaArchivos;
			}
		}
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
	public static String fechaActual(String formatoFecha) {
		Date date = new Date();
		SimpleDateFormat fechaActual = new SimpleDateFormat(formatoFecha);
		return fechaActual.format(date);
	}
	
	/**
	 * Devuelve la fecha de creación del archivo pasado por parámetro.
	 * 
	 * @param path
	 * @return fecha de creación del archivo
	 * @throws IOException
	 */
	private String fechaCreacionArchivo(Path path) {
		FileTime creationTime = null;
		try {
			creationTime = (FileTime) Files.getAttribute(path, "creationTime");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat spf = new SimpleDateFormat(Constantes.FORMATO_FECHA);
		return spf.format(new Date(creationTime.toMillis()));
	}
	
	/**
	 * Convierte un String pasado por parametro con la extensión especificada a un objeto Date y lo devuelve.
	 * 
	 * @param fecha
	 * @param formatoFecha
	 * @return
	 * @throws ParseException
	 */
	private Date convertirStringDate(String fecha, String formatoFecha) {
		SimpleDateFormat format = new SimpleDateFormat(formatoFecha);
		Date fechaDate = null;
		try {
			fechaDate = format.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fechaDate;
	}
	
	private boolean comprobarFicheroRepetido(Path fichero) {
		return false; // TODO
	}
	
	/**
	 * Añade un fichero.log en la ruta indicada y añade el texto pasado por parámetro o en caso de que ya esté creado añade directamente el texto.
	 * 
	 * @param destino
	 * @param añadirTexto
	 * @throws IOException
	 */
	private void anadirLog(String destino, String añadirTexto) throws IOException { // TODO
		Path p = Paths.get(destino);
		
		if (!Files.exists(p)) {
			try (BufferedWriter writer = Files.newBufferedWriter(p, StandardCharsets.UTF_8)) {
				writer.write(añadirTexto);
			}
		} else {
			try (BufferedWriter writer = Files.newBufferedWriter(p, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
				writer.write("\n"+añadirTexto);
			}
		}
	}
	
	/**
	 * Elimina la extensión del archivo que se le pasa por parámetro
	 * 
	 * @param archivo
	 * @return
	 */
	public String borrarExtensionArchivo(String archivo) {
		String patronExtension = "(?<!^)[.].*";
	    return archivo.replaceAll(patronExtension, "");
	}
}
