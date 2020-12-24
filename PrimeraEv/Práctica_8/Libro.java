/**
* @author Rubén García García
* Práctica 8 de programación
*/

import java.util.Scanner; // Importando la clase Scanner y sus métodos

public class Libro{

	// Atributos
	private String titulo;
	private String autor;
	private int numEjemplares;
	private int numPrestados;

	// Constructor por defecto
	public Libro(){

	}

	// Constructor con parámetros
	public Libro(String titulo, String autor, int numEjemplares, int numPrestados){
		this.titulo = titulo;
		this.autor = autor;

		this.numEjemplares = numEjemplares;

		if(numEjemplares <= numPrestados){
			System.out.println("No se ha podido prestar ningún libro");
		}
		else{
			this.numPrestados = numPrestados;
		}
	}

	// Métodos set
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public void setAutor(String autor){
		this.autor = autor;
	}

	public void setNumEjemplares(int numEjemplares){
		this.numEjemplares = numEjemplares;
	}

	public void setNumPrestados(int numPrestados){
		this.numPrestados = numPrestados;
	}

	// Métodos get
	public String getTitulo(){
		return titulo;
	}

	public String getAutor(){
		return autor;
	}

	public int getNumEjemplares(){
		return numEjemplares;
	}

	public int getNumPrestados(){
		return numPrestados;
	}

	// Método préstamo
	public boolean prestamo(){

		if(numEjemplares > numPrestados){
			numPrestados++;
			System.out.println("Libro prestado con éxito");
			return true;
		}
		else{
			System.out.println("No se ha podido realizar el préstamo del libro");
			return false;
		}
		
	}

	// Método devolución
	public boolean devolucion(){
		
		if(numPrestados > 0){
			System.out.println("Libro devuelto con éxito");
			return true;
		}
		else{
			System.out.println("No se ha podido realizar la devolución");
			return false;
		}

	}

	// Método toString
	public String toString(){
		return "Título: "+titulo+"\nAutor: "+autor+"\numEjemplares: "+numEjemplares+"\numPrestados: "+numPrestados;
	}

	// Método main
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		Libro l1 = new Libro("El nombre del viento", "Patrick Rothfuss", 10, 6);
		Libro l2 = new Libro();

		// Cambiando los datos del primer libro
		System.out.println("**Cambiando los datos del libro 1**\n");
		System.out.print("Nuevo título: ");
		String dato1 = sc.nextLine();

		System.out.print("Nuevo autor: ");
		String dato2 = sc.nextLine();

		System.out.print("Ejemplares: ");
		int dato3 = sc.nextInt();

		System.out.print("Prestados: ");
		int dato4 = sc.nextInt();

		l1.setTitulo(dato1);
		l1.setAutor(dato2);
		l1.setNumEjemplares(dato3);
		l1.setNumPrestados(dato4);

		sc.close(); // Cerrando sc

		// Pidiendo los datos del segundo libro
		System.out.println("\n**Datos del libro 2**\n");
		System.out.print("Introduzca el título: ");
		l2.titulo = sc2.nextLine();

		System.out.print("Introduzca el autor: ");
		l2.autor = sc2.nextLine();

		System.out.print("Introduzca el número de libros: ");
		l2.numEjemplares = sc2.nextInt();

		System.out.print("Introduzca el número de libros prestados: ");
		l2.numPrestados = sc2.nextInt();

		sc2.close(); // Cerrando sc2

		System.out.print("\n**DATOS DEL LIBRO 1**\n");
		System.out.print(l1.toString());

		System.out.print("**DATOS DEL LIBRO 2**\n");
		System.out.print(l2.toString());
	}

}