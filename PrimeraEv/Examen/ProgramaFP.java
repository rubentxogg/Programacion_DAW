/**
* Examen de programación 
*
* @author Rubén García García
*/

import javax.swing.JOptionPane; // Importamos la clase JoptionPane para poder pedir datos al usuario y leerlos

class Alumno{

	// Atributos
	private String nombre = "Sin nombre definido";
	private int edad;
	private static int contadorAlumnos;
	private int reciclado;
	private short nota;
	private short vecesVoluntario;
	private int vecesQueHaReciclado;

	// Método constructor vacío
	public Alumno(){
		contadorAlumnos++;
	}

	/**
	* Método constructor con parámetros
	*
	* @param nombre Guarda el nombre del alumno
	* @param edad Guarda la edad del alumno
	*/
	public Alumno(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;

		contadorAlumnos++;
	}

	public short getNota(){
		return nota;
	}

	/**
	* Método get
	*
	* @return Devuelve el número de alumnos
	*/
	public int getContadorAlumnos(){
		return contadorAlumnos;
	}

	/**
	* Método set
	* 
	* @param nombre Guarda el nombre el alumno
	*/
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	/**
	* Método get
	*
	* @return Devuelve el nombre del alumno
	*/
	public String getNombre(){
		return nombre;
	}

	/**
	* Método set
	*
	* @param edad Guarda la edad del alumno
	*/
	public void setEdad(int edad){
		this.edad = edad;
	}

	/**
	* Método get
	*
	* @return Devuelve la edad del alumno
	*/
	public int getEdad(){
		return edad;
	}

	/**
	* Método reciclar
	*
	* @return Devuelve true si el alumno ha reciclado 3 o más veces y false en caso contrario
	*/
	public boolean reciclar(){
		reciclado++;

		if(reciclado >= 3){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	* Método reciclar 
	* 
	* @param valor Guarda el valor que vamos a sumar a las veces que ha reciclado el alumno
	* @return Devuelve true si el alumno ha reciclado 3 o más veces y false en caso contrario
	*/
	public boolean reciclar(short valor){
		vecesQueHaReciclado += valor;

		if(vecesQueHaReciclado >= 3){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	* Método salir de voluntario, cada vez que el alumno sale se incrementa la nota en una unidad
	*
	* @return Devuelve la nota del voluntariado del alumno
	*/
	public int salirDeVoluntario(){
		nota++;
		return nota;
	}

	public String toString(){
		return "\n**DATOS DEL ALUMNO**"+"\nNombre: "+nombre+"\nEdad: "+edad+"\nReciclado: "+reciclado+"\nNota: "+nota;
	}
}

// Clase principal del programa
public class ProgramaFP{

	// Método main
	public static void main(String[] args){
		Alumno alumno1 = new Alumno("Ruben",25);
		Alumno alumno2 = new Alumno();

		alumno2.setNombre(JOptionPane.showInputDialog(null, "Introduzca el nombre del segundo alumno"));
		alumno2.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la edad")));

		while(true){
			int opc = Integer.parseInt(JOptionPane.showInputDialog(null,"**MENU**"+"\n1.Mostrar numero de objetos Alumno creados"+
																				   "\n2.Incrementar reciclado del alumno 1"+
																				   "\n3.Salir de voluntario del alumno 1"+
																				   "\n4.Imprimir por pantalla"));

			if(opc == 1){
				JOptionPane.showMessageDialog(null, "Numero actual de alumnos: " + alumno1.getContadorAlumnos());
			}
			else if(opc == 2){
				alumno1.reciclar();
				JOptionPane.showMessageDialog(null, "Reciclado del alumno 1 incrementado con exito");
			}
			else if(opc == 3){
				alumno1.salirDeVoluntario();
				JOptionPane.showMessageDialog(null, "Nota del voluntariado del alumno: " +alumno1.getNota());
			}
			else if(opc == 4){
				JOptionPane.showMessageDialog(null, alumno1.toString());
			}
			else if(opc == 5){
				break;
			}
			else{
				JOptionPane.showMessageDialog(null, "Ha introducido un digito invalido");
			}

		}

	}

}