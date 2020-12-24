// Importo un contenedor de clases para poder usar sus métodos
import javax.swing.JOptionPane;

/**
* Creando la clase para la práctica 6 de clase de programación
* @author Rubén García García
*/
public class CuadroDialogo2{

	public static void main(String[] args){

		// Inicializo las variables
		String datoEnTexto, datoEnTexto2;
		int valorPrincipal, valorSecun, valorTotal;
		boolean flag = true;

		
		datoEnTexto = JOptionPane.showInputDialog(null,"Introduzca un número"); // Muestro un mensaje en pantalla y el número que introduzca se guarda en la variable

		
		valorPrincipal = Integer.parseInt(datoEnTexto); // Cambio el dato de la variable de String a tipo int

		
		valorTotal = valorPrincipal; // Le pongo el mismo valor que el que he introducido anteriormente

		/*
		Inicio un bucle que acabará cuando la variable flag sea igual a false,
		me saltará un menú en pantalla que me permitirá elegir diferentes opciones
		*/
		while(flag){
			datoEnTexto2 = JOptionPane.showInputDialog(null, "1.Sumar \n2.Restar \n3.Salir \n4.Mostrar el resultado \n5.Volver a mostrar el menú");

			valorSecun = Integer.parseInt(datoEnTexto2);

			if(valorSecun == 3){ // Esta opción finalizará el programa
				flag = false;
			}
			else if(valorSecun == 1){ // Esta opción sumará a sí mismo el primer valor que introduje
				valorTotal += valorPrincipal;
			}
			else if(valorSecun == 2){ // Esta opción restará a sí mismo el primer valor que introduje
				valorTotal -= valorPrincipal;
			}
			else if(valorSecun == 4){ // Esta opción me mostrará el resultado total
				JOptionPane.showMessageDialog(null, "El resultado es: "+valorTotal);
			}
			else if(valorSecun == 5){ // Esta opción repetirá el menú
				flag = true;
			}
			else{
				JOptionPane.showMessageDialog(null, "Se ha introducido un número inválido"); // Si introduzco otro número diferente al que me dirá que he introducido un número inválido
			}
		}
		
	}
}