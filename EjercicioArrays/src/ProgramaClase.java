
/**
 * @author Rubentxo
 * Programa que cuando lo ejecutamos elige un compañero de clase al azar
 */
public class ProgramaClase {
	
	public static void main(String[] args) {
		
		String[] compis = {"Klabitos", "Pablet", "Javi", "Diego", "Fernando", "Héctor", "Rubén"};
		
		int select = (int) (Math.random() * compis.length);
		
		System.out.println("El compañero seleccionado es: "+compis[select]);
		
	}
}
