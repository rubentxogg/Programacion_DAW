import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase Menu
public class Menu {
	
	// Atributos
	private int opcElegida;
	

	// Este método pedirá al usuario que pulse enter para continuar, creará un objeto tipo Scanner y pedirá una string cualquiera
	public void pulsaEnter(){
		Scanner sc = new Scanner(System.in);
		System.out.println("La opción no es correcta, pulse enter para volver al menú");
		   
		sc.nextLine();
		}
	
	/* Método imprimirMenu que imprimirá un menú y pedira una opción al usuario, dependiendo de la opción introducida, se creará un objeto de la clase
	 * de la que se va a hacer uso de su método para poder acceder a el
	 */
	public void imprimirMenu() {
		Scanner sc = new Scanner(System.in); //Creando un objeto de la clase Scanner para poder usar sus métodos
		
		do {
			// Mostrando el menú
			System.out.print("**************MENU**************"
							+ "\n1.-Imprimir los primeros números naturales"
							+ "\n2.-Imprimir un triángulo rectángulo con números"
							+ "\n3.-Imprimir un triángulo rectángulo invertido con números"
							+ "\n4.-Suma acumulada"
							+ "\n5.-Imprimir tabla de multiplicar"
							+ "\n6.-Números pares"
							+ "\n7.-Números primos"
							+ "\n8.-Jugar a piedra, papel o tijera"
							+ "\n9.-Salir"
							+ "\n********************************"
							+ "\nSeleccione una opción del menú: ");
			
			opcElegida = sc.nextInt(); // Pidiendo el número al usuario y guardándolo en la variable menuElegido
			
			System.out.println(); // Salto de línea
			
			// En el condicional switch, en cada caso creamos una objeto de la clase y llamamos a su método correspondiente
			switch(opcElegida) {
				case 1: Number number = new Number();
						number.imprNum();
						break;
						
				case 2: Triangle triangle = new Triangle();
						triangle.imprTriangulo();
						break;
				
				case 3: Triangle triangle2 = new Triangle();
						triangle2.imprTrianguloInv();
						break;
				
				case 4: Suma suma = new Suma();
						suma.sumaAc();
						break;
						
				case 5: Tmultiplicar tmultiplicar = new Tmultiplicar();
						tmultiplicar.tablaMult();
						break;
						
				case 6: SpecialNumbers specialnum = new SpecialNumbers();
						specialnum.numPares();
						break;
						
				case 7: SpecialNumbers specialnum2 = new SpecialNumbers();
						specialnum2.numPrimos();
						break;
						
				case 8: JuegoPPT juegoppt = new JuegoPPT();
						juegoppt.piedraPapelTijera();
						break;
						
				case 9: break;
				
				default: Menu enter = new Menu();
						 enter.pulsaEnter();
				
			}
			
		}while(opcElegida != 9); // Si el número elegido es diferente al 9 el bucle sigue, si es 9 termina
		
		System.out.println("*******Programa finalizado******* \n¡Gracias por utilizar mi programa!");
		
		sc.close(); //Cerramos el scanner
	}
		
}
