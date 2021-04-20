import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * @author Rubentxo
 * Práctica 9 de programación
 */
public class P9 {


	public static void main(String[] args) {
		
		
		String cadena = " Esta es la cadena de la práctica 9       ";
		//También se podría declarar: String cadena = new String (" Esta es la cadena de la práctica 9       ");

        //Imprime la longitud de caracteres de la cadena
		System.out.println(cadena.length());
		
		//Guarda en la variable la cadena sin los caracteres blancos del inicio y fin 
		System.out.println(cadena.trim());
		
		//Indica el carácter que está en la posición 6
		System.out.println(cadena.charAt(6));
		
		//Muestra la cadena desde la posicion 6 hasta el final del String
		System.out.println(cadena.substring(6));
		
		String mola = " Me gusta la clase String, nos ofrece muchos métodos de apoyo";
		
		//Contatena las variables cadena y mola. Lo puedes realizar con el operador + o con concat
		System.out.println(cadena.concat(mola));
		// System.out.println(cadena+mola);
		
		//Indica el índice donde se encuentra la palabra métodos en la variable cadena
		System.out.println(cadena.indexOf("métodos")); // Imprime -1 porque no encuentra "métodos" en la variable cadena
		
		String nombre = "DAW";
		
		//Indica si la cadena de nombre es igual a la palabra daw --> con equals
		System.out.println(nombre.equals("daw"));
		
		//Indica si la cadena de nombre es igual a la palabra DAW --> con equals
		System.out.println(nombre.equals("DAW"));
		
		//Indica si la cadena de nombre es igual a la palabra DaW --> con equalsIgnoreCase
		System.out.println(nombre.equalsIgnoreCase("DaW"));
		
		//Indica si la cadena de nombre es igual a la palabra DAW --> con compareTo
		System.out.println(nombre.compareTo("DAW")); // Devuelve 0 porque el parámetro pasado es lexicográficamente equivalente
		
		//Solicita al usuario que introduzca una cadena.
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un String: ");
		String str = sc.nextLine();
		
		//Imprime la cadena en mayúsculas.
		System.out.println(str.toUpperCase());
		
		//Imprime la cadena en minúsculas
		System.out.println(str.toLowerCase());

		//Reemplaza de la variable cadena todos los espacios por * Imprime el resultado
		System.out.println(cadena.replace(" ", "*"));
		
		//Crea un array dividiendo la variable cadena en los caracteres *. Imprime el String utilizando la clase Arrays
		String[] strArray;
		strArray = cadena.split("\\*");
		System.out.println(Arrays.toString(strArray));
		
		//Utiliza la clase StringTokenizer para manipular la variable "cadena"
		StringTokenizer tokens1 = new StringTokenizer(cadena);
		
		//Divide la "cadena" cuando encuentres un espacio en blanco
		StringTokenizer tokens2 = new StringTokenizer(cadena," ");
		
		//Imprime uno a uno todos los elementos que hay en el objeto StringTokenizer
		while(tokens2.hasMoreTokens()) {
			System.out.println(tokens2.nextToken());
		}

	}

}
