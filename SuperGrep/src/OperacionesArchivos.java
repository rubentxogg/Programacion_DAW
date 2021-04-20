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
	private String destinoLog;
	private int contArchivoRepetido = 1;
	
	
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
	
	/**
	 * Analiza el directorio recursivamente en busca de ficheros que contengan la palabra deseada y copia esos ficheros en la carpeta de
	 * destino de SuperGrep.
	 * 
	 * @throws IOException
	 */
	public void analizarDirectorio() throws IOException {
		Path p = Paths.get(directorio);
		List<Path> directorios = listarDirectorios(p);
		List<Path> archivos;
		int numArchivosAnalizados = 0;

		for (int j = 0; j < directorios.size(); j++) {
			archivos = seleccionListaArchivosSegunContenidoFecha(directorios, j);
			anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Analizando directorio "+directorios.get(j));
			
			for (int i = 0; i < archivos.size(); i++) {
				anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Analizando archivo: "+archivos.get(i)+"...");
				numArchivosAnalizados++;
				
				if (buscarPalabra(archivos.get(i), palabra)) {
					anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Palabra: "+'"'+palabra +'"'+" encontrada. [!]");
					anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Copiando fichero: "+archivos.get(i)+" a "+Constantes.DIRECTORIO_DESTINO);
					seleccionTipoCopiaArchivos(archivos, i);
				}
			}
		}
		anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Número total de archivos analizados: "+numArchivosAnalizados+".");
		anadirLog(destinoLog, fechaActual(Constantes.FORMATO_FECHA_Y_HORA_ACTUAL)+" - Número total de directorios analizados: "+directorios.size()+".");
	}
	
	/**
	 * Devuelve true si ha encontrado la palabra en el archivo, en caso contrario, devuelve false.
	 * 
	 * @param archivo
	 * @param palabra
	 * @return
	 * @throws IOException
	 */
	public boolean buscarPalabra(Path archivo, String palabra) throws IOException {
		try(Scanner sc = new Scanner(archivo);){
			while(sc.hasNext()) {
				if(sc.next().equalsIgnoreCase(palabra)) {
					System.out.println("Palabra encontrada en el fichero: "+archivo);
					return true;
				}
			}
			return false;
		}	
	}

	/**
	 * Si el nombre del archivo a copiar es igual que el nombre del archivo que hay en el destino, se copiará añadiendo un número al nombre
	 * para evitar conflictos.
	 * 
	 * @param archivos
	 * @param i
	 * @throws IOException
	 */
	private void seleccionTipoCopiaArchivos(List<Path> archivos, int i) throws IOException {
		if(!comprobarNombreArchivoRepetido(archivos, i)) {
			Files.copy(archivos.get(i), Paths.get(Constantes.DIRECTORIO_DESTINO+"\\"+archivos.get(i).getFileName().toString()));
		}
		else {
			Files.copy(archivos.get(i), Paths.get(borrarExtensionArchivo(Constantes.DIRECTORIO_DESTINO+"\\"+archivos.get(i).getFileName().toString())+" ("+contArchivoRepetido+")"+Constantes.EXTENSION_TXT));
			contArchivoRepetido++;
		}
	}

	/**
	 * Devuelve una lista u otra dependiendo si la fecha está en blanco o no;
	 * 
	 * @param directorios
	 * @param j
	 * @return
	 * @throws IOException
	 */
	private List<Path> seleccionListaArchivosSegunContenidoFecha(List<Path> directorios, int j) throws IOException {
		List<Path> archivos;
		
		if(fecha.isEmpty()) {
			archivos = listarArchivosPorExtension(directorios.get(j), Constantes.EXTENSION_TXT);
		}
		else {
			archivos = listarArchivosPorExtensionFecha(directorios.get(j), Constantes.EXTENSION_TXT, fecha);
		}
		return archivos;
	}
	
	/**
	 * Asigna el destino donde se creará el Log a la variable global destinoLog.
	 * 
	 * @param destinoLog
	 */
	public void seleccionarDestinoLog(String destinoLog) {
		this.destinoLog = destinoLog;
	}

	/**
	 * Devuelve true si el nombre del archivo path de la lista de path pasada por parámetro ya existe en el directorio destino y false en caso contrario.
	 * 
	 * @param archivos
	 * @param i
	 * @return
	 * @throws IOException
	 */
	private boolean comprobarNombreArchivoRepetido(List<Path> archivos, int i) {
		Path pathDestino = Paths.get(Constantes.DIRECTORIO_DESTINO+"\\"+archivos.get(i).getFileName().toString());
		return(Files.exists(pathDestino));
	}
	
	/**
	 * Borra todos los archivos que se encuentran en el directorio pasado por parámetro.
	 * 
	 * @throws IOException
	 */
	public void vaciarDirectorio(String directorio) throws IOException {
		Path p = Paths.get(directorio);
		List<Path> archivos = listarArchivosPorExtension(p, Constantes.CUALQUIER_EXTENSION);
		
		for(int i=0; i<archivos.size();i++) {
			Files.delete(Paths.get(directorio+"\\"+archivos.get(i).getFileName().toString()));
		}
	}
	
	/**
	 * Devuelve una lista de Path de los archivos encontrados en la ruta pasada por parámetro con la extensión especificada.
	 * 
	 * @param archivo
	 * @param extension
	 * @return
	 * @throws IOException
	 */
	private List<Path> listarArchivosPorExtension(Path archivo, String extension) throws IOException {
		List<Path> listaArchivos;

		try (Stream<Path> st = Files.walk(archivo, 1);) {
			listaArchivos = st.filter(Files::isRegularFile)
					.filter(p -> p.getFileName().toString().endsWith(extension))
					.collect(Collectors.toList());
			return listaArchivos;
		}
	}

	/**
	 * Devuelve una lista de Path de los archivos encontrados en la ruta pasada por parámetro a partir de la fecha y extensión especificadas.
	 * 
	 * @param archivo
	 * @param extension
	 * @param fecha
	 * @return
	 * @throws IOException
	 */
	private List<Path> listarArchivosPorExtensionFecha(Path archivo, String extension, String fecha) throws IOException {
		List<Path> listaArchivos;
		
		try (Stream<Path> st = Files.walk(archivo, 1);) {
			listaArchivos = st.filter(Files::isRegularFile)
					.filter(p -> convertirStringDate(fechaCreacionArchivo(p), Constantes.FORMATO_FECHA).after(convertirStringDate(fecha, Constantes.FORMATO_FECHA)) ||
								convertirStringDate(fechaCreacionArchivo(p), Constantes.FORMATO_FECHA).equals(convertirStringDate(fecha, Constantes.FORMATO_FECHA)))
					.filter(p -> p.getFileName().toString().endsWith(extension)).collect(Collectors.toList());
			return listaArchivos;
		}
	}
	
	
    /**
     * Devuelve una lista de Path de los directorios y subdirectorios encontrados a partir de la ruta pasada por parámetro.
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
			System.err.println("[Ha ocurrido un error inesperado, no se ha podido extraer la fecha de creación del archivo especificado.]");
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
			System.err.println("[No se ha podido convertir a Date, compruebe que el formato de la fecha introducido es válido.]");
		}
		return fechaDate;
	}
	
	/**
	 * Añade un fichero.log en la ruta indicada y añade el texto pasado por parámetro o en caso de que ya esté creado añade directamente el texto.
	 * 
	 * @param destino
	 * @param anadirTexto
	 * @throws IOException
	 */
	private void anadirLog(String destino, String anadirTexto) throws IOException {
		Path p = Paths.get(destino);
		
		if (!Files.exists(p)) {
			try (BufferedWriter writer = Files.newBufferedWriter(p, StandardCharsets.UTF_8)) {
				writer.write(anadirTexto);
			}
		} else {
			try (BufferedWriter writer = Files.newBufferedWriter(p, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
				writer.write("\n"+anadirTexto);
			}
		}
	}
	
	/**
	 * Elimina la extensión del archivo que se le pasa por parámetro
	 * 
	 * @param archivo
	 * @return
	 */
	private String borrarExtensionArchivo(String archivo) {
		String patronExtension = "(?<!^)[.].*";
	    return archivo.replaceAll(patronExtension, "");
	}
}
