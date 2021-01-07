/**
 * Práctica 9.1 de programación
 * @author Rubentxo
 */
public class BuscadorNotas {
	
	public static void main(String[] args) {
		int nota = Integer.parseInt(args[1]);
		String resultado = "sin calificar";
		
		if(args.length == 2) {
			// Sigue
		}
		else if(args.length == 0) {
			System.out.println("ERROR, no se han introducido argumentos");
			return;
		}
		else if(args.length == 1) {
			System.out.println("ERROR, argumentos insuficientes");
			return;
		}
		else {
			System.out.println("ERROR, demasiados argumentos");
			return;
		}
		
		if(nota > 10 || nota < 1) {
			System.out.println("ERROR, la nota debe estar en el rango 1-10");
			return;
		}
		
		System.out.println("Bienvenido/a "+args[0]);
		
		switch(nota) {
				case 5: resultado = "aprobado";
						break;
				
				case 6: resultado = "bien";
						break;
				
				case 7: resultado = "notable";
						break;
						
				case 8: resultado = "notable";
						break;
				
				case 9: resultado = "sobresaliente";
						break;
						
				case 10: resultado = "sobresaliente";
						break;
						
				default: resultado = "insuficiente";
				 		 break;
		}
		
		System.out.println("Calificación de la nota: "+resultado);
		
	}
}