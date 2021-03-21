
public class Persona {
	
	int edad;
	
	public Persona(){
		
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setEdad(int edad) throws EdadIllegalException {
		
		if(edad <= 0) {
			throw new EdadIllegalException("La edad no puede ser 0 o negativa.");
		}
		else {
			this.edad = edad;
		}
		
	}
}
