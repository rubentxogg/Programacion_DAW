
/**
 * Pr�ctica 8 de programaci�n
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
	 * M�todo constructor por defecto
	 */
	public Libro() {

	}

	/**
	 * @param titulo              T�tulo del libro
	 * @param autor               Autor del libro
	 * @param ejemplares          N�mero de ejemplares
	 * @param ejemplaresPrestados N�mero de ejemplares prestados
	 */
	public Libro(String titulo, String autor, int ejemplares, int ejemplaresPrestados) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;

		if (ejemplares < ejemplaresPrestados) {
			JOptionPane.showMessageDialog(null, "No se pueden prestar m�s libros de los que hay");
		} else {
			this.ejemplaresPrestados = ejemplaresPrestados;
		}

	}

	/**
	 * @return Devuelve el t�tulo del libro
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo Guarda el t�tulo del libro
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
	 * @return Devuelve el n�mero de ejemplares
	 */
	public int getEjemplares() {
		return ejemplares;
	}

	/**
	 * @param ejemplares Guarda el n�mero de ejemplares
	 */
	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	/**
	 * @return Devuelve el n�mero de ejemplares prestados
	 */
	public int getEjemplaresPrestados() {
		return ejemplaresPrestados;
	}

	/**
	 * @param ejemplaresPrestados Guarda el n�mero de ejemplares prestados
	 */
	public void setEjemplaresPrestados(int ejemplaresPrestados) {
		this.ejemplaresPrestados = ejemplaresPrestados;
	}

	// M�todo pr�stamo
	public boolean prestamo() {
		if (ejemplares < ejemplaresPrestados) {
			JOptionPane.showMessageDialog(null, "No se ha podido realizar el pr�stamo del libro");
			return false;
		} else {
			ejemplaresPrestados++;
			return true;
		}
	}

	/**
	 * M�todo devoluci�n
	 * 
	 * @return Devuelve "true" si se realiza la devoluci�n y devuelve "false" en
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

	// M�todo toString
	public String toString() {
		return "**Datos del libro**" + "\nT�tulo: " + titulo + "\nAutor: " + autor + "\nN�mero de libros: " + ejemplares
				+ "\nN�mero de libros prestados: " + ejemplaresPrestados;
	}

	// M�todo main
	public static void main(String[] args) {
		String valor1 = JOptionPane.showInputDialog(null, "Introduce el titulo del libro:"); // Pidiendo al usuario el t�tulo del libro
		String valor2 = JOptionPane.showInputDialog(null, "Introduce el autor del libro:"); // Pidiendo al usuario el autor del libro
		int valor3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el numero de libros:"));
		int valor4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el numero de prestados"));

		Libro libro1 = new Libro(valor1, valor2, valor3, valor4); // Creando el objeto libro1 y a�adiendole los valores introducidos por el usuario

		System.out.println(libro1.toString()); // Mostrando los datos del libro 1

		Libro libro2 = new Libro();

		libro2.setTitulo(JOptionPane.showInputDialog(null, "Introduce el titulo del libro"));
		libro2.setAutor(JOptionPane.showInputDialog(null, "Introduce el autor del libro:"));
		libro2.setEjemplares(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el numero de libros:")));
		libro2.setEjemplaresPrestados(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el numero de prestados:")));

		System.out.println("\n" + libro2.toString()); // Mostrando los datos del libro 2

	}

}
