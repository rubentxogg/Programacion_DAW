/**
 * Pr�ctica 8 de programaci�n
 * 
 * @author Rub�n Garc�a Garc�a
 */
public class P8 {
	
	// M�todo main
	public static void main(String[] args) {
		
		int num = (int) (Math.random() * 100) + 1; // Guardamos en la variable num el n�mero aleatorio
		System.out.print("Generando un n�mero aleatorio... \nEl n�mero es: "+num+"\n");
		
		System.out.println("\nDecrementando el n�mero generado...");
		
		// Creamos un bucle que vaya decrementando el n�mero generado hasta 0
		while(num > 1) { 
			num--;
			
			// Comprobamos que el n�mero sea par y lo mostramos por pantalla
			if(num %2 == 0) {
				System.out.println("El n�mero "+num+" es par\n");
			}

		}
		
		
	}
}
