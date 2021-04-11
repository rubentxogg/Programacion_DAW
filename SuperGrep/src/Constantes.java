
/**
 * Clase de constantes.
 * 
 * @author Rubentxo
 */
public class Constantes {
	
	/**
	 * Método contructor privado para proteger la clase.
	 */
	private Constantes() {
		throw new IllegalStateException("Clase de utilidad");
	}
	
	// Directorios
	public static final String DIRECTORIO_DESTINO = "C:\\Users\\Rubentxo\\Desktop\\SuperGrep"; 
	
	// Extensiones
	public static final String EXTENSION_TXT = ".txt";
	public static final String CUALQUIER_EXTENSION = "";
	
	// Formatos de fecha
	public static final String FORMATO_FECHA = "dd/MM/yyyy";
	public static final String FORMATO_FECHA_Y_HORA_ACTUAL = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_FECHA_LOG = "ddMMYY";
	
	// Log
	public static final String DESTINO_LOG = "C:\\Users\\Rubentxo\\Desktop\\superGrep_"+OperacionesArchivos.fechaActual(FORMATO_FECHA_LOG)+".log";
}
