
/**
 * @author Rubentxo
 * Clase que marca el flujo del programa.
 */
public class FlujoPrograma {
	
	/**
	 * Contructor de la clase.
	 */
	public FlujoPrograma() {
		PreguntasUsuario pu = new PreguntasUsuario();
		System.out.println(pu.nombreDirectorioDiscoDuro());
		System.out.println(pu.fecha());
		System.out.println(pu.palabraABuscar());
	}
}
