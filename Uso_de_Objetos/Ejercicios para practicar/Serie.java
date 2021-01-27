/**
* Ejercicio de programación para practicar
* @author Rubén García García
*/

import java.util.Scanner; // Importamos el paquete Scanner para obtener sus métodos

class Serie{

	// Atributos
	String titulo;
	int numTemporadas = 3;
	boolean entregado = false;
	String genero;
	String creador;

	// Constructor por defecto
	Serie(){

	}

	/**
	* Constructor con el título y creador
	* @param titulo Guarda el título de la serie
	* @param creador Guarda el creador de la serie
	*/
	Serie(String titulo, String creador){
		this.titulo = titulo;
		this.creador = creador;
	}

	/**
	* Constructor con todos los atributos excepto el de entregado
	* @param titulo Guarda el título de la serie
	* @param numTemporadas Guarda el número de temporadas
	* @param genero Guarda el género de la serie
	* @param creador Guarda el nombre del creador
	*/
	Serie(String titulo, int numTemporadas, String genero, String creador){
		this.titulo = titulo;
		this.numTemporadas = numTemporadas;
		this.genero = genero;
		this.creador = creador;
	}

	// Métodos GET y SET
	String getTitulo(){
		return titulo;
	}

	void setTitulo(String titulo){
		this.titulo = titulo;
	}

	int getNumTemporadas(){
		return numTemporadas;
	}

	void setNumTemporadas(int numTemporadas){
		this.numTemporadas = numTemporadas;
	}

	String getGenero(){
		return genero;
	}

	void setGenero(String genero){
		this.genero = genero;
	}

	String getCreador(){
		return creador;
	}

	void setCreador(String creador){
		this.creador = creador;
	}

	// Método toString
	public String toString(){
		return "**DATOS DE LA SERIE**"+"\nTitulo: "+titulo+"\nNúmero de temporadas: "+numTemporadas+"\nGénero: "+genero+"Creador: "+creador;
	}

	// Método main
	public static void main(String[] args){
		String titulo1;

		Scanner sc = new Scanner(System.in);

		Serie s1 = new Serie();

		System.out.println("Introduzca el título de la serie: ");
		titulo1 = sc.nextLine();
		s1.setTitulo(titulo1);

		System.out.println(s1.toString());

	}

}

class Videojuego{

	// Atributos
	String titulo;
	int horasEstimadas = 10;
	boolean entregado = false;
	String compania;

	// Constructor por defecto
	Videojuego(){

	}

	/**
	* Constructor con el título y horas estimadas
	* @param titulo Guarda el título del videojuego
	* @param horasEstimadas Guarda las horas estimadas
	*/
	Videojuego(String titulo, int horasEstimadas){
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
	}

	/**
	* Constructor con todos los atributos excepto de entregado
	* @param titulo Guarda el título del videojuego
	* @param horasEstimadas Guarda las horas estimadas
	* @param compania Guarda el nombre de la compañía del videojuego
	*/
	Videojuego(String titulo, int horasEstimadas, String compania){
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.compania = compania;
	}

	// Métodos GET y SET
	String getTitulo(){
		return titulo;
	}

	void setTitulo(String getTitulo){
		this.titulo = titulo;
	}

	int getHorasEstimadas(){
		return horasEstimadas;
	}

	void setHorasEstimadas(int horasEstimadas){
		this.horasEstimadas = horasEstimadas;
	}

	String getCompania(){
		return compania;
	}

	void setCompania(String compania){
		this.compania = compania;
	}

	// Método toString
	public String toString(){
		return "**DATOS DEL VIDEOJUEGO**"+"\nTítulo: "+titulo+"\nHoras estimadas: "+horasEstimadas+"\nCompañía: "+compania;
	}


}