
/**
 * @author Rubentxo
 * Clase que solo contiene constantes
 */
public class Constantes {
	
	/**
	 * Contructor de clase privado, ya que es una clase de utilidad y así evitamos que el
	 * constructor sin parámetros predeterminado se use en otra parte del código.
	 */
	private Constantes() {
		throw new IllegalStateException("Clase de utilidad");
	}
	
	public static final String INFORME_FINAL = "C:\\Users\\Rubentxo\\Desktop\\InformeQuijote.pdf";
	public static final String FICHERO_TEXTO_QUIJOTE = "C:\\Users\\Rubentxo\\Desktop\\ElQuijote.txt";
	public static final String FICHERO_PALABRAS_A_BUSCAR = "C:\\Users\\Rubentxo\\Desktop\\palabras.txt";
	
	// Constantes relativas al texto de la tabla generada en pdf
	public static final String TEXTO_CABECERA_DE_TABLA = "Palabras aparecidas en el Quijote";
	public static final String TEXTO_CABECERA_TABLA_PALABRAS = "Palabra";
	public static final String TEXTO_CABECERA_TABLA_NUMERO_APARICIONES = "Número apariciones";
}
