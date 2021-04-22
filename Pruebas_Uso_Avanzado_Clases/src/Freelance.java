
public class Freelance extends Trabajador{
	private double horasTrabajadas;
	private double tarifa;
	
	/**
	 * @param nombre
	 * @param id
	 * @param salario
	 * @param impuestos
	 */
	public Freelance(String nombre, int id, double horasTrabajadas, double tarifa) {
		super(nombre, id);
		this.horasTrabajadas = horasTrabajadas;
		this.tarifa = tarifa;
		this.setSalario(calculoSalario());
	}
	
	/**
	 *
	 */
	@Override
	public double calculoSalario() {
		return getHorasTrabajadas() * getTarifa();
	}
	
	
	public void reservarEspacio() {
		System.out.println("Reservando espacio para el trabajador con id: "+getId());
	}

	/**
	 * @return the horasTrabajadas
	 */
	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}

	/**
	 * @param horasTrabajadas the horasTrabajadas to set
	 */
	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	/**
	 * @return the tarifa
	 */
	public double getTarifa() {
		return tarifa;
	}

	/**
	 * @param tarifa the tarifa to set
	 */
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
}
