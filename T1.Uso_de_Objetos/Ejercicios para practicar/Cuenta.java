/**
* @author Rubén García García
* Ejercicio para practicar de java
*/

import java.util.Scanner; // Clase para leer datos de varios tipos

public class Cuenta{

	// Atributos
	String nombreCliente;
	String numCuenta;
	double tipoInteres;
	double saldo;

	// Contructor por defecto
	public Cuenta(){

	}

	// Constructor con todos los parámetros
	public Cuenta(String nombreCliente, String numCuenta, double tipoInteres, double saldo){
		this.nombreCliente = nombreCliente;
		this.numCuenta = numCuenta;
		this.tipoInteres = tipoInteres;
		this.saldo = saldo;
	}

	// Constructor copia
	public Cuenta(final Cuenta c){
		nombreCliente = c.nombreCliente;
		numCuenta = c.numCuenta;
		tipoInteres = c.tipoInteres;
		saldo = c.saldo;
	}

	// Métodos set
	public void setNombre(String nombreCliente){
		this.nombreCliente = nombreCliente;
	}

	public void setNum(String numCuenta){
		this.numCuenta = numCuenta;
	}

	public void setInteres(double tipoInteres){
		this.tipoInteres = tipoInteres;
	}

	public void setSaldo(double saldo){
		this.saldo = saldo;
	}

	// Métodos get
	public String getNombre(){
		return nombreCliente;
	}

	public String getNum(){
		return numCuenta;
	}

	public double getInteres(){
		return tipoInteres;
	}

	public double getSaldo(){
		return saldo;
	}

	// Creando variables de la clase
	double n;
	boolean bandera = true;

	// Método ingreso
	public void ingreso(double n){

		while(bandera){

			if(n < 0){
				System.out.println("Se ha introducido un número negativo, vuelva a intentarlo");
			}
			else{
				saldo += n;
				System.out.println("La operación se ha realizado correctamente");
				bandera = false;
			}
		}
	}

	// Método reintegro
	public void reintegro(double n){

		while(bandera){

			if(n < saldo){
				saldo -= n;
				System.out.println("La operación se ha realizado correctamente");
				bandera = false;
			}
			else if(n < 0){
				System.out.println("La cantidad a introducir no puede ser negativa");
			}
			else{
				System.out.println("No dispone de esa cantidad, vuelva a intentarlo");
			}
		}
	}

	// Método transferencia
	public void tranferencia(Cuenta c, double n){
		
		if(n < 0){
			bandera = false;
		}
		else if(saldo >= n){
			reintegro(n);
			c.ingreso(n);
		}
		else{
			bandera = false;
		}
	}

	// Método main
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
 		String nombre, numero;
 		double tipo, importe;

 		//se crea objeto cuenta1 sin parámetros
 		//se ejecuta el constructor por defecto
 		Cuenta cuenta1 = new Cuenta();

 		System.out.print("Nombre : ");
 		nombre = sc.nextLine();
 		System.out.print("Número de cuenta : ");
 		numero = sc.nextLine();
 		System.out.print("Tipo de interes : ");
 		tipo = sc.nextDouble();
 		System.out.print("Saldo: ");
 		importe = sc.nextDouble();

 		cuenta1.setNombre(nombre);
 		cuenta1.setNum(numero);
 		cuenta1.setInteres(tipo);
 		cuenta1.setSaldo(importe);

 		//se crea el objeto cuenta2 con los valores leidos por teclado
 		//se ejecuta el constructor con parámetros
 		Cuenta cuenta2 = new Cuenta("Juan Ferrández Rubio", "12345678901234567890", 1.75, 300);                       

 		//se crea cuenta3 como copia de cuenta1
 		//se ejecuta el constructor copia
 		Cuenta cuenta3 = new Cuenta(cuenta1);

 		//mostrar los datos de cuenta1
 		System.out.println("Datos de la cuenta 1");
 		System.out.println("Nombre del titular: " + cuenta1.getNombre());
 		System.out.println("Número de cuenta: " + cuenta1.getNum());
 		System.out.println("Tipo de interés: " + cuenta1.getInteres());
 		System.out.println("Saldo: " + cuenta1.getSaldo());
 		System.out.println();
       
 		//se realiza un ingreso en cuenta1
 		cuenta1.ingreso(4000);
     
 		//mostrar el saldo de cuenta1 después del ingreso
 		System.out.println("Saldo: " + cuenta1.getSaldo());
     
 		//mostrar los datos de cuenta2
 		System.out.println("Datos de la cuenta 2");
 		System.out.println("Nombre del titular: " + cuenta2.getNombre());
 		System.out.println("Número de cuenta: " + cuenta2.getNum());
 		System.out.println("Tipo de interés: " + cuenta2.getInteres());
 		System.out.println("Saldo: " + cuenta2.getSaldo());
 		System.out.println();
     
 		//mostrar los datos de cuenta3
 		System.out.println("Datos de la cuenta 3");
 		System.out.println("Nombre del titular: " + cuenta3.getNombre());
 		System.out.println("Número de cuenta: " + cuenta3.getNum());                                         
 		System.out.println("Tipo de interés: " + cuenta3.getInteres());
 		System.out.println("Saldo: " + cuenta3.getSaldo());
 		System.out.println();
     
 		//realizar una transferencia de 10€ desde cuenta3 a cuenta2
 		//cuenta3.transferencia(cuenta2, 10);
     
 		//mostrar el saldo de cuenta2
 		System.out.println("Saldo de la cuenta 2");
 		System.out.println("Saldo: " + cuenta2.getSaldo());
 		System.out.println();
     
 		//mostrar el saldo de cuenta3
 		System.out.println("Saldo de la cuenta 3");
 		System.out.println("Saldo: " + cuenta3.getSaldo());
 		System.out.println();
	}
}