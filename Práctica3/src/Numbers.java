import java.util.Scanner;

public class Numbers {
	Scanner sc = new Scanner(System.in);
	int num1;
	int num2;
	
	public void solictarNumeros() {
		System.out.print("Introduce un n�mero:");
		num1 = sc.nextInt();
		System.out.print("Introduce otro n�mero:");
		num2 = sc.nextInt();
	}
	
	public void dividirNumeros() {
		System.out.println("El resultado de la divisi�n entre "+num1+" y "+num2+" es: "+num1/num2);
	}
}
