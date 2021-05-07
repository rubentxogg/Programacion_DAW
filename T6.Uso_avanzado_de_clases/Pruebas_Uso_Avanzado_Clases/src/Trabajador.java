
public class Trabajador {
	
	private String nombre;
	private int id;
	private double salario;
	private double impuestos;
	
	/**
	 * @param nombre
	 * @param id
	 * @param salario
	 * @param impuestos
	 */
	public Trabajador(String nombre, int id, double salario, double impuestos) {
		this.nombre = nombre;
		this.id = id;
		this.salario = salario;
		this.impuestos = impuestos;
	}
	
	/**
	 * @param nombre2
	 * @param id2
	 */
	public Trabajador(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the salario
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * @return the impuestos
	 */
	public double getImpuestos() {
		return impuestos;
	}

	/**
	 * @param impuestos the impuestos to set
	 */
	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}

	/**
	 * @return
	 */
	public double calculoSalario() {
		return getSalario() - getImpuestos();
	}
	
	/**
	 * 
	 */
	public void guardar() {
		System.out.println("Guardando empleado: "+getNombre());
	}
	
	/**
	 * 
	 */
	public void actualizar() {
		System.out.println("Actualizando empleado: "+getNombre());
	}
	
	/**
	 * 
	 */
	public void borrar() {
		System.out.println("Borrando empleado: "+getNombre());
	}
	
	/**
	 * 
	 */
	public void leer() {
		System.out.println("Leyendo empleado: "+getNombre());
	}
}
