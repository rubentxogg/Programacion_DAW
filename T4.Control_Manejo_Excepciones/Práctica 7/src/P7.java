public class P7 {
	
	public static void main(String[] args) {
		Persona p = new Persona();

		try {
			p.setEdad(-5);	
		} catch(EdadIllegalException eie) {
			eie.printStackTrace();
		}
		
		try {
			p.pedirManaPersona();
			p.dividirManaPersona(5);
		} catch(Throwable t) {
			t.printStackTrace();
		} finally {
			System.out.println("La edad es: "+p.getEdad());
		}
		
	}
}
