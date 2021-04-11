import java.io.IOException;

/**
 * Clase que marca el flujo del programa.
 * 
 * @author Rubentxo
 */
public class FlujoPrograma {
	OperacionesArchivos oa = new OperacionesArchivos();
	DatosUsuario pedir = new DatosUsuario();
	
	/**
	 * Contructor de la clase.
	 */
	public FlujoPrograma() {
		oa.seleccionarDirectorio(pedir.rutaDirectorio());
		oa.seleccionarFecha(pedir.fecha());
		oa.seleccionarPalabra(pedir.palabraABuscar());
		System.out.println();
		
		try {
			oa.vaciarDirectorio(Constantes.DIRECTORIO_DESTINO);
			oa.seleccionarDestinoLog(Constantes.DESTINO_LOG);
			oa.analizarDirectorio();
		} catch (IOException e) {
			System.err.println("[Error, el directorio destino no existe, debe crear o seleccionar otro.]");
		}
		
		pedir.cerrarScanner(pedir.sc);
	}
}
