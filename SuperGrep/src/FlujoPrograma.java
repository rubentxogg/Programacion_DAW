import java.io.IOException;

/**
 * @author Rubentxo
 * Clase que marca el flujo del programa.
 */
public class FlujoPrograma {
	
	/**
	 * Contructor de la clase.
	 */
	public FlujoPrograma() {
		OperacionesArchivos oa = new OperacionesArchivos();
		DatosUsuario pedir = new DatosUsuario();
		
		oa.seleccionarDirectorio(pedir.rutaDirectorio());
		oa.seleccionarFecha(pedir.fecha());
		oa.seleccionarPalabra(pedir.palabraABuscar());
		System.out.println();
		
		try {
			oa.vaciarDirectorio(Constantes.DIRECTORIO_DESTINO);
			oa.recorrerDirectorio(Constantes.LOG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pedir.cerrarScanner(pedir.sc);
	}
}
