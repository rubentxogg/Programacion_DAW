
/**
 * Práctica 8 de programación
 */

import javax.swing.JOptionPane;

/**
 * @author Rubentxo
 *
 */
public class Libro {

	// Atributos
	private String titulo;
	private String autor;
	private int ejemplares;
	private int ejemplaresPrestados;

	/**
	 * Método constructor por defecto
	 */
	public Libro() {

	}

	/**
	 * @param titulo              Título del libro
	 * @param autor               Autor del libro
	 * @param ejemplares          Número de ejemplares
	 * @param ejemplaresPrestados Número de ejemplares prestados
	 */
	public Libro(String titulo, String autor, int ejemplares, int ejemplaresPrestados) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;

		if (ejemplares < ejemplaresPrestados) {
			JOptionPane.showMessageDialog(null, "No se pueden prestar más libros de los que hay");
		} else {
			this.ejemplaresPrestados = ejemplaresPrestados;
		}

	}

	/**
	 * @return Devuelve el título del libro
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo Guarda el título del libro
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return Devuelve el autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor Guarda el autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return Devuelve el número de ejemplares
	 */
	public int getEjemplares() {
		return ejemplares;
	}

	/**
	 * @param ejemplares Guarda el número de ejemplares
	 */
	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	/**
	 * @return Devuelve el número de ejemplares prestados
	 */
	public int getEjemplaresPrestados() {
		return ejemplaresPrestados;
	}

	/**
	 * @param ejemplaresPrestados Guarda el número de ejemplares prestados
	 */
	public void setEjemplaresPrestados(int ejemplaresPrestados) {
		this.ejemplaresPrestados = ejemplaresPrestados;
	}

	// Método préstamo
	public boolean prestamo() {
		if (ejemplares < ejemplaresPrestados) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el préstamo del libro");
			return false;
		} else {
			ejemplaresPrestados++;
			return true;
		}
	}

	/**
	 * Método devolución
	 * 
	 * @return Devuelve "true" si se realiza la devolución y devuelve "false" en
	 *         caso contrario
	 */
	public boolean devolucion() {
		if (ejemplaresPrestados <= 0) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar la devolucion");
			return false;
		} else {
			ejemplaresPrestados--;
			return true;
		}
	}

	// Método toString
	public String toString() {
		return "**Datos del libro**" + "\nTítulo: " + titulo + "\nAutor: " + autor + "\nNúmero de libros: " + ejemplares
				+ "\nNúmero de libros prestados: " + ejemplaresPrestados;
	}

	// Método main
	public static void main(String[] args) {
		String valor1 = JOptionPane.showInputDialog(null, "Introduce el titulo del libro:"); // Pidiendo al usuario el título del libro
		String valor2 = JOptionPane.showInputDialog(null, "Introduce el autor del libro:"); // Pidiendo al usuario el autor del libro
		int valor3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el numero de libros:"));
		int valor4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el numero de prestados"));

		Libro libro1 = new Libro(valor1, valor2, valor3, valor4); // Creando el objeto libro1 y añadiendole los valores introducidos por el usuario

		System.out.println(libro1.toString()); // Mostrando los datos del libro 1

		Libro libro2 = new Libro();

		libro2.setTitulo(JOptionPane.showInputDialog(null, "Introduce el titulo del libro"));
		libro2.setAutor(JOptionPane.showInputDialog(null, "Introduce el autor del libro:"));
		libro2.setEjemplares(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el numero de libros:")));
		libro2.setEjemplaresPrestados(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el numero de prestados:")));

		System.out.println("\n" + libro2.toString()); // Mostrando los datos del libro 2

	}

}
