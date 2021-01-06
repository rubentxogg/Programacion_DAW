/**
 * Práctica 8.1 de programación
 * @author Rubentxo
 */
public class Numbers {
	
	// Método main
	public static void main(String[] args) {
		
		int num = (int) ((Math.random() * 99) + 1);
		
		System.out.println("Num: "+num);
		
		System.out.println("Imprimiendo números pares desde el "+num+" hasta el 0");
		for(int i=num;i>=0;i--) {
		
			if(i %2 == 0) {
				System.out.println(i);
			}

		}
	}
}

	
	
		
