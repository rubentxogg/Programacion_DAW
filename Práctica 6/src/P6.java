
public class P6 {
	
	public static void main(String[] args) {
		Persona p = new Persona();
		
		try {
			p.setEdad(-5);
		} catch(EdadIllegalException eie) {
			System.out.println("Error esquivado.");
		}
		
		System.out.println("La edad es: "+p.getEdad());
	}
}
