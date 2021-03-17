import java.util.Scanner;

public class Numbers {
	Scanner sc = new Scanner(System.in);
	int num1;
	int num2;
	boolean num2Correcto;
	
	public void DividirNumeros() {
		while(!num2Correcto) {
			
			System.out.print("Introduce un número:");
			num1 = sc.nextInt();
			System.out.print("Introduce otro número:");
			num2 = sc.nextInt();
	
			try {
				System.out.println("El resultado de la división entre "+num1+" y "+num2+" es: "+num1/num2);
				num2Correcto = true;
			} catch (ArithmeticException ae) {
				System.out.println("Por favor, introduzca un número diferente a 0.");
			} catch (Throwable t) {
				System.out.println("Por favor, introduzca un número entero.");
			} 
		}
		
	}
	
}
