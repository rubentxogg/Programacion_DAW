import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author Rubentxo
 * 
 * Esta clase contiene métodos que preguntan al usuario y devuelven valores.
 */
public class datosUsuario {
	Scanner sc = new Scanner(System.in);

	/**
	 * Método que pregunta al usuario una ruta del directorio en el disco duro y la
	 * devuelve.
	 * 
	 * @return ruta del directorio del disco duro
	 */
	public String rutaDirectorio() {
		System.out.print("Introduzca la ruta de un directorio: ");
		return sc.nextLine();
	}

	/**
	 * Pregunta al usuario una fecha en formato DD/MM/AAAA, si se deja en blanco devuelve el String "vacío",
	 * si escribe la fecha con el formato correcto devolverá la fecha y si la escribe con el formato incorrecto 
	 * se le volverá al usuario.
	 * 
	 * @return fecha/""
	 */
	public String fecha() {
		System.out.print("Introduzca una fecha (dd/mm/aaaa): ");
		String fecha = sc.nextLine();
		
		if(fecha.equals("")) {
			return "";
		}
		else {
			if(comprobarFecha(fecha)) {
				return fecha;
			}
			else {
				System.err.println("\n[El formato introducido no es válido.]\n");
				return fecha();
			}
		}
	}
		
	/**
	 * Cierra el objeto Scanner indicado.
	 * 
	 * @param sc Objeto Scanner
	 */
	public void cerrarScanner(Scanner sc) {
		sc.close();
	}

	/**
	 * Comprueba el formato de la fecha y devuelve true en caso de que sea correcto o false en caso contrario.
	 * 
	 * @param fecha
	 * @return true/false
	 */
	private boolean comprobarFecha(String fecha) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			formatoFecha.setLenient(false);
			formatoFecha.parse(fecha);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Pregunta al usuario que palabra es la que quiere buscar y la devuelve.
	 * 
	 * @return nombre de la palabra
	 */
	public String palabraABuscar() {
		System.out.print("Introduzca la palabra a buscar: ");
		return sc.next();
	}
}
