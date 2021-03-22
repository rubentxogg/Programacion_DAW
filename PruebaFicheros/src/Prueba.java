import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Prueba {
	public static void main(String[] args) throws IOException {
//		FileReader fr = null;
//		BufferedReader br;
//		try {
//			fr = new FileReader("C:\\Users\\20207\\Desktop\\documento.txt", StandardCharsets.UTF_8);
//			br = new BufferedReader(fr);
//			// Lectura del fichero
//			String linea;
//			while((linea = br.readLine()) != null) {
//				System.out.println(linea);
//			}	
//		} catch(FileNotFoundException fnfe) {
//			fnfe.printStackTrace();
//		} finally {
//			if(fr != null) {
//				fr.close();
//			}
//		}
		
		try (FileReader fr = new FileReader("C:\\Users\\20207\\Desktop\\documento.txt", StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("C:\\Users\\20207\\Desktop\\documento.txt", StandardCharsets.UTF_8)){
			String linea;
			fw.write("Hooolaaa, \nQué tal");
			fw.flush(); // Para forzar la escritura
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		}
	}
}