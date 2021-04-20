/**
 * Práctica 11 de programación
 * @author Rubentxo
 */
public class BuscadorNotasMejorado {
	
	// Método main
	public static void main(String[] args) {
		
		if(args.length %2 == 0) { // Comprueba que el número de argumentos introducido es par
			
			for(int i=0;i<args.length;i+=2) { // Cada vez que se ejecute la expresión de este bucle i se suma 2
				System.out.print("Nombre: "+args[i]+" --> "); // Imprime el argumento par(Nombre)
				System.out.print("Nota: "+args[i+1]+" = "); // Imprime seguidamente el argumento impar(Nota)
				
				int nota = Integer.parseInt(args[i+1]); // Se pasa el argumento impar(Nota) a int
				
				if(nota > 10 || nota < 1) { // Si la nota no está en el rango 1-10 se produce un error y se termina el programa
					System.out.println("ERROR, la nota debe estar en el rango 1-10");
					return;
				}
				
				String resultado; // Creamos una string donde guardaremos el resultado de la nota
				
				switch(nota) { // Dependiendo de la nota que hayamos sacado se imprimirá un resultado u otro
						case 5: resultado = "Aprobado";
								break;
				
							case 6: resultado = "Bien";
								break;
				
							case 7: resultado = "Notable";
								break;
						
							case 8: resultado = "Notable";
								break;
				
							case 9: resultado = "Sobresaliente";
								break;
						
							case 10: resultado = "Sobresaliente";
								break;
						
							default: resultado = "Insuficiente";
								break;
				}
				System.out.print(resultado+"\n"); // Se imprime el resultado
			}
			
		}
		else {
			System.out.println("ERROR, los argumentos introducidos son impares");
			return;
		}
	}
		
}