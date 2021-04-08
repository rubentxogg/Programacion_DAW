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
		datosUsuario pedir = new datosUsuario();
		
		oa.seleccionarDirectorio(pedir.rutaDirectorio());
		oa.seleccionarFecha(pedir.fecha());
		oa.seleccionarPalabra(pedir.palabraABuscar());
		System.out.println();
		
		try {
			oa.vaciarDirectorio(Constantes.DIRECTORIO_DESTINO);
			oa.recorrerDirectorio();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
