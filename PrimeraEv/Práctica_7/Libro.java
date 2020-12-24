/**
* @author Rubén García García
* Práctica 8 de programación
*/

public class Libro{
	private String titulo;
	private String autor;
	private int nEjemplares;
	private int nEjPrestados;

	// Constructor por defecto
	public Libro(){

	}

	// Constructor con parámetros
	public Libro(String titulo, String autor, int nEjemplares, int nEjPrestados){
		this.titulo = titulo;
		this.autor = autor;
		this.nEjemplares = nEjemplares;
		this.nEjPrestados = nEjPrestados;
	}

	// Métodos get
	public String getTitulo(){
		return titulo;
	}

	public String getAutor(){
		return autor;
	}

	public int getNEjemplares(){
		return nEjemplares;
	}

	public int getNEjPrestados(){
		return nEjPrestados;
	}

	// Métodos set
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public void setTitulo(String autor){
		this.autor = autor;
	}

	public void setTitulo(int nEjemplares){
		this.nEjemplares = nEjemplares;
	}

	public void setTitulo(int nEjPrestados){
		this.nEjPrestados = nEjPrestados;
	}

	// Método prestamo
	public void prestamo(){
		boolean prestado = true;

		if(nEjemplares < 0){
			System.out.println("No quedan ejemplares disponibles para prestar");
			prestado = false;
			return prestado;
		}
		else{
			System.out.println("Se ha prestado el libro");
			return prestado;
		}

	}

	// Método main
	public static void main(String[] args){

	}

}