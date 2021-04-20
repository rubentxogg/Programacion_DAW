import java.util.Scanner; // Importando la clase Scanner para pedir datos al usuario

// Clase Menu
public class Menu {
	
	// Atributos
	private int opcElegida;
	

	// Este m�todo pedir� al usuario que pulse enter para continuar, crear� un objeto tipo Scanner y pedir� una string cualquiera
	public void pulsaEnter(){
		Scanner sc = new Scanner(System.in);
		System.out.println("La opci�n no es correcta, pulse enter para volver al men�");
		   
		sc.nextLine();
		}
	
	/* M�todo imprimirMenu que imprimir� un men� y pedira una opci�n al usuario, dependiendo de la opci�n introducida, se crear� un objeto de la clase
	 * de la que se va a hacer uso de su m�todo para poder acceder a el
	 */
	public void imprimirMenu() {
		Scanner sc = new Scanner(System.in); //Creando un objeto de la clase Scanner para poder usar sus m�todos
		
		do {
			// Mostrando el men�
			System.out.print("**************MENU**************"
							+ "\n1.-Imprimir los primeros n�meros naturales"
							+ "\n2.-Imprimir un tri�ngulo rect�ngulo con n�meros"
							+ "\n3.-Imprimir un tri�ngulo rect�ngulo invertido con n�meros"
							+ "\n4.-Suma acumulada"
							+ "\n5.-Imprimir tabla de multiplicar"
							+ "\n6.-N�meros pares"
							+ "\n7.-N�meros primos"
							+ "\n8.-Jugar a piedra, papel o tijera"
							+ "\n9.-Salir"
							+ "\n********************************"
							+ "\nSeleccione una opci�n del men�: ");
			
			opcElegida = sc.nextInt(); // Pidiendo el n�mero al usuario y guard�ndolo en la variable menuElegido
			
			System.out.println(); // Salto de l�nea
			
			// En el condicional switch, en cada caso creamos una objeto de la clase y llamamos a su m�todo correspondiente
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
			
		}while(opcElegida != 9); // Si el n�mero elegido es diferente al 9 el bucle sigue, si es 9 termina
		
		System.out.println("*******Programa finalizado******* \n�Gracias por utilizar mi programa!");
		
		sc.close(); //Cerramos el scanner
	}
		
}
