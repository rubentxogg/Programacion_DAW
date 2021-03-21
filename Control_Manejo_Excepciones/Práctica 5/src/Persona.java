
public class Persona extends P5 {
	int edad;
	
	public Persona(){
		
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setEdad(int edad) {
		
		if(edad <= 0) {
			throw new IllegalArgumentException("La edad no puede ser 0 o negativa.");
		}
		else {
			this.edad = edad;
		}
		
	}

}
