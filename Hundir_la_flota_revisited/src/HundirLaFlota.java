
/**
 * @author Rubentxo
 * Solamente contiene el método main donde llamaremos a un método de la clase juego.
 * 
 * { PARA INICIAR EL MODO DEPURACIÓN, INTRODUCIR EL ARGUMENTO: -debug }
 */
public class HundirLaFlota {
	
	// Método main
	public static void main(String[] args) {
		if(args.length > 0 && args[0].equals("-debug")){
			System.out.println("\t\t##################################################"
				            +  "\n\t\t################## {MODO DEBUG} ##################"
							+  "\n\t\t##################################################\n");
			Tablero.debug = true;
		}
		new Juego(Tablero.debug); // Si debug es true, se iniciará el juego en modo depuración
	}
}
