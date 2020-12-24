/**
 * Práctica 8 de programación
 * 
 * @author Rubén García García
 */
public class P8 {
	
	// Método main
	public static void main(String[] args) {
		
		int num = (int) (Math.random() * 100) + 1; // Guardamos en la variable num el número aleatorio
		System.out.print("Generando un número aleatorio... \nEl número es: "+num+"\n");
		
		System.out.println("\nDecrementando el número generado...");
		
		// Creamos un bucle que vaya decrementando el número generado hasta 0
		while(num > 1) { 
			num--;
			
			// Comprobamos que el número sea par y lo mostramos por pantalla
			if(num %2 == 0) {
				System.out.println("El número "+num+" es par\n");
			}

		}
		
		
	}
}
