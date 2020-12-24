/**
* @author Rubén García García
* Ejercicio para practicar programación
*/

import java.util.Random;

public class Persona{
	// Atributos
	private String nombre = "noname";
	private int edad = 19;
	private String dni;
	private char sexo = 'h';
	private double peso = 80.5;
	private double altura = 1.80;

	// Constructor por defecto
	public Persona(){

	}

	// Constructor con nombre, edad y sexo
	public Persona(String nombre, int edad, char sexo){
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}

	// Constructor con todos los atributos
	public Persona(String nombre, int edad, String dni, char sexo, double peso, double altura){
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	// Método calcular índice de masa corporal
	public double calcularIMC(){
		double imc;

		imc = peso*(altura*altura);

		if(imc < 20){
			return -1;
		}
		else if(imc < 20 && imc > 25){
			return 0;
		}
		else if(imc > 25){
			return 1;
		}

		return imc;
	}

	// Método mayor de edad
	public boolean esMayorDeEdad(){
		boolean mayorDeEdad = true;

		if(edad > 18){
			mayorDeEdad = true;
		}
		else{
			mayorDeEdad = false;
		}

		return mayorDeEdad;
	}


	// Método comprobar sexo
	public char comprobarSexo(char sexo){

		if(sexo != this.sexo){
			return this.sexo;
		}

		return sexo;
	}


	// Método toString()
	public String toString(){
		return "Nombre: "+nombre+"\nEdad: "+edad+"\nDNI: "+dni+"\nSexo: "+sexo+"\nPeso: "+peso+"\nAltura: "+altura;
	}

	// Método generaDNI
	/*public String generaDNI(String dni){

	}*/	

	public static void main(String[] args){
		Random r = new Random();

		int valorRandom = r.nextInt(6)+3;

		System.out.println(valorRandom);

		int numero = (int)(Math.random()*13);

		System.out.println(numero);

		Persona ruben = new Persona();

		System.out.println(ruben.calcularIMC());
		
		System.out.println(ruben.esMayorDeEdad());
	}
}