
/**
 * @author Rubentxo
 * Programa que cuando lo ejecutamos elige un compa�ero de clase al azar
 */
public class ProgramaClase {
	
	public static void main(String[] args) {
		
		String[] compis = {"Klabitos", "Pablet", "Javi", "Diego", "Fernando", "H�ctor", "Rub�n"};
		
		int select = (int) (Math.random() * compis.length);
		
		System.out.println("El compa�ero seleccionado es: "+compis[select]);
		
	}
}
