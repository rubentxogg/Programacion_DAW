import java.io.IOException;

/**
 * @author Rubentxo
 * Esta clase marcará el flujo del programa.
 */
public class FlujoPrograma {
	
	// Constructor de la clase
	public FlujoPrograma() {
		OperacionesFicheros of = new OperacionesFicheros();
		
		try {
			of.buscarPalabras(Constantes.FICHERO_PALABRAS_A_BUSCAR, Constantes.FICHERO_TEXTO_QUIJOTE);
		} catch (IOException e) {
			System.err.println("No se ha podido leer el fichero, por favor, asegúrese de escribir correctamente la ruta.");
		}
	}
}
