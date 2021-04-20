/**
* Prácticando el constructor de tipo copia
* @author Rubén García García
*/

class Coche{

	// Atributos
	String color;
	private String marca;
	int matricula;

	// Constructor por defecto
	Coche(){

	}

	/**
	* Constructor con todos los parámetros
	* @param color Color del coche
	* @param marca Marca del coche
	* @param matricula Matrícula del coche
	*/
	Coche(String color, String marca, int matricula){
		this.color = color;
		this.marca = marca;
		this.matricula = matricula;
	}

	/**
	* Constructor copia
	* @param clon 
	*/
	public Coche(Coche clon){
		this.color = clon.color;
		this.marca = clon.marca;
		this.matricula = clon.matricula;
	}

	// Método main
	public static void main(String[] args){
		Coche c1 = new Coche("Blanco","Nissan",123498765);

		Coche c2 = new Coche(c1);

		System.out.println(c2.color);
	}
}