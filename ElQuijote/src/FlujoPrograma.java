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
			of.buscarPalabras(Constantes.FICHERO_PALABRAS_A_BUSCAR, Constantes.FICHERO_TEXTO_QUIJOTE);
		} catch (IOException e) {
			System.err.println("No se ha podido leer el fichero, por favor, aseg�rese de escribir correctamente la ruta.");
		}
		
		try {
			new OperacionesPDF().generarPDF(Constantes.INFORME_FINAL);
		} catch (IOException e) {
			System.err.println("\n[Ha ocurrido un error inesperado, no se ha podido generar el PDF.]");
		}
	}
}
