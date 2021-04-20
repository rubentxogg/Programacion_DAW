
/**
 * @author Rubentxo
 * Clase relacionada con los argumentos
 */
public class Argumentos {
	
	/**
	 * Lee los argumentos que le pasas y te salta error al intentar leer un argumento más
	 * @param args
	 */
	public void leeArgumentos(String[] args) {
		
		try {
			for(int i=0;i<args.length+1;i++) {
				System.out.println(args[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			
		} finally {
			System.out.println("¡Error esquivado!");
		}
	}
}
