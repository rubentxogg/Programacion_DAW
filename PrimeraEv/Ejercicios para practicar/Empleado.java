/**
 * Ejercicio de programación para practicar
 */


/**
 * @author Rubentxo
 *
 */
public class Empleado {

	// Atributos
	private int NIF;
	private String nombre;
	private double sueldoBase;
	private double horasExtra;
	private boolean casado;
	private int numHijos;
	private static double importeHoraExtra;
	
	
	/**
	 * @author Rubentxo
	 * @param NIF Le pasamos el NIF
	 */
	public Empleado(int NIF) {
		this.NIF = NIF;
	}
	
	// Constructor por defecto
	public Empleado() {
		
	}

	/**
	 * @return the nIF
	 */
	public int getNIF() {
		return NIF;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the sueldoBase
	 */
	public double getSueldoBase() {
		return sueldoBase;
	}

	/**
	 * @return the horasExtra
	 */
	public double getHorasExtra() {
		return horasExtra;
	}

	/**
	 * @return the casado
	 */
	public boolean isCasado() {
		return casado;
	}

	/**
	 * @return the numHijos
	 */
	public int getNumHijos() {
		return numHijos;
	}

	/**
	 * @return the importeHoraExtra
	 */
	public static double getImporteHoraExtra() {
		return importeHoraExtra;
	}

	/**
	 * @param nIF the nIF to set
	 */
	public void setNIF(int nIF) {
		NIF = nIF;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param sueldoBase the sueldoBase to set
	 */
	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	/**
	 * @param horasExtra the horasExtra to set
	 */
	public void setHorasExtra(double horasExtra) {
		this.horasExtra = horasExtra;
	}

	/**
	 * @param casado the casado to set
	 */
	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	/**
	 * @param numHijos the numHijos to set
	 */
	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	/**
	 * @param importeHoraExtra the importeHoraExtra to set
	 */
	public static void setImporteHoraExtra(double importeHoraExtra) {
		Empleado.importeHoraExtra = importeHoraExtra;
	}
	
	// Método para calcular las horas extras realizadas
	public double calcularHorasExtra() {

		double importeTotal;
		
		importeTotal = horasExtra * importeHoraExtra;
		
		return importeTotal;
	}
	
	// Método para calcular el sueldo bruto
	public double calcularSueldoBruto() {
		
		double SueldoBruto;
		
		SueldoBruto = sueldoBase + calcularHorasExtra();
		
		return SueldoBruto;
	}
	
	@Override
	public String toString() {
		return "Empleado [NIF=" + NIF + ", nombre=" + nombre + ", sueldoBase=" + sueldoBase + ", horasExtra="
				+ horasExtra + ", casado=" + casado + ", numHijos=" + numHijos + "]";
	}
	
	// Método main
	public static void main(String[] args) {
		Empleado ruben = new Empleado(44565933);

		ruben.setHorasExtra(10);
		ruben.setImporteHoraExtra(5);
		ruben.calcularHorasExtra();
		ruben.setSueldoBase(900);
		
		System.out.println("El complemento de las horas extras es: "+ruben.calcularHorasExtra()+"€");
		System.out.println("El sueldo bruto es: "+ruben.calcularSueldoBruto()+"€");
		
		System.out.println(ruben.toString());
	}

}
