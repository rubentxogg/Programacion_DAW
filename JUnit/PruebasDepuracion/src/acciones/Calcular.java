package acciones;

public class Calcular {

	public Calcular() {
		super();
		// TODO Ap�ndice de constructor generado autom�ticamente
	}

	public String queHago(String tiempo) {

		String resultado ="andando";
		if (tiempo.equalsIgnoreCase("1") && tiempo.equalsIgnoreCase("3") ) {
			resultado = "en coche";
		} else if (tiempo.equalsIgnoreCase("2")){
			resultado="en bicicleta";
		}
		
		return resultado;
	}

}
