
public class ImperativoFuncional {
	
	public static void main(String[] args) {
		String[] arrayString = {"Santiago", "Paco", "Ruperto", "Sara", "Rubén", "Diego", "Amparo", "Rudy", "Soraya"}; 
		int[] arrayNumeros = {150, 225, 396, 587, 905, 1050};
		
		// Manera Imperativo
		new ImperativeWay().filtraOrdenaImprime(arrayString, "Ru");
		System.out.println();
		new ImperativeWay().calculaCuadradoyMedia(arrayNumeros);
		System.out.println();
		new ImperativeWay().convierteAMinusculasFiltra(arrayString, "Sa");
		
		// Manera Funcional
		System.out.println();
		new FunctionalWay().filtraOrdenaImprime(arrayString, "Sa");
		
		System.out.println();
		new FunctionalWay().calculaCuadradoyMedia(arrayNumeros);
		
		System.out.println();
		new FunctionalWay().convierteAMinusculasFiltra(arrayString, "Ru");
	}
}
