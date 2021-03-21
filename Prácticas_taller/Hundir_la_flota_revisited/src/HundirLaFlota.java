
/**
 * @author Rubentxo
 * Solamente contiene el m�todo main donde llamaremos a un m�todo de la clase juego.
 * 
 * { PARA INICIAR EL MODO DEPURACI�N, INTRODUCIR EL ARGUMENTO: -debug }
 */
public class HundirLaFlota {
	
	// M�todo main
	public static void main(String[] args) {
		if(args.length > 0 && args[0].equals("-debug")){
			System.out.println("\t\t##################################################"
				            +  "\n\t\t################## {MODO DEBUG} ##################"
							+  "\n\t\t##################################################\n");
			Tablero.debug = true;
		}
		new Juego(Tablero.debug); // Si debug es true, se iniciar� el juego en modo depuraci�n
	}
}
