import java.util.Arrays;

public class ProgramaPrueba {
	
	public static void main(String[] args) { 
		
		char[] caja = {'a', 'b', 'c'};
		
		for(char x: caja) {
			System.out.println(x);
		}
		System.out.println();
		
		for(int i=0; i<caja.length; i++) {
			System.out.println(caja[i]);
		}
		
		int[][] cajaIntegers = {{1, 2, 3}, {4, 5, 6}};
			
		for(int i=0; i<cajaIntegers.length; i++) {
			System.out.println();
			for(int j=0; j<cajaIntegers[i].length; j++) {
				System.out.print(cajaIntegers[i][j]);
					
			}
		}
	}
}
