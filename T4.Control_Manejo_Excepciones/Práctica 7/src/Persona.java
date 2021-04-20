import java.io.IOException;
import java.util.Scanner;

public class Persona {
	int edad;
	int mana;
	
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
	
	public void pedirManaPersona() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el nivel de maná de la persona: ");
		mana = sc.nextInt();
		sc.close();
	}
	
	public void dividirManaPersona(int numero) {
		System.out.println("El resultado de la división de "+this.mana+" entre "+numero+" es: "+this.mana/numero);
	}
}
