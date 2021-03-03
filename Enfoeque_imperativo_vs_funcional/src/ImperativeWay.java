import java.util.Arrays;

public class ImperativeWay {
	
	public void filtraOrdenaImprime(String[] nombres, String c) {
		String[] arrayAux = null;
		int i = 0;
		
		for(String x : nombres) {
			
			if(x.startsWith(c)) {
				i++;
			}
		}
		
		arrayAux = new String[i];
		i = 0;
		
		for(String x : nombres) {
			
			if(x.startsWith(c)) {
				arrayAux[i] = x;
				i++;
			}
		}
		
		for(String x : arrayAux) {
			System.out.println(x);
		}
		
		Arrays.sort(arrayAux);
	}
}
