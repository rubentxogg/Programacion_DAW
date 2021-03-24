import java.io.IOException;

/**
 * @author Rubentxo
 * Esta clase marcar� el flujo del programa.
 */
public class FlujoPrograma {
	
	// Constructor de la clase
	public FlujoPrograma() {
		OperacionesFicheros of = new OperacionesFicheros();
		
		try {
			of.leerFichero(Constantes.FICHERO_PALABRAS_A_BUSCAR);
			of.leerFichero(Constantes.FICHERO_TEXTO_QUIJOTE);
		} catch (IOException ioe) {
			System.err.println("No se ha podido leer el archivo, por favor, aseg�rese de introducir la ruta correctamente.");
		}
		
	}
}
