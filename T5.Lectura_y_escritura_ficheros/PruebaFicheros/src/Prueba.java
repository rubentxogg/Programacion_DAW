import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
		
//		try (FileReader fr = new FileReader("C:\\Users\\20207\\Desktop\\documento.txt", StandardCharsets.UTF_8);
//			BufferedReader br = new BufferedReader(fr);
//			FileWriter fw = new FileWriter("C:\\Users\\20207\\Desktop\\documento.txt", StandardCharsets.UTF_8)){
//			String linea;
//			fw.write("Hooolaaa, \nQué tal");
//			fw.flush(); // Para forzar la escritura
//			while((linea = br.readLine()) != null) {
//				System.out.println(linea);
//			}
//		}
		
//		File miArchivo = new File("C:\\Users\\20207\\Desktop\\pruebaDirectorio\\prueba.txt");
//		File miDirectorio = new File("C:\\Users\\20207\\Desktop\\pruebaDirectorio");
//		
//		miDirectorio.mkdir();
//		miArchivo.createNewFile();
//		
//		System.out.println(miArchivo.exists());
//		System.out.println(miDirectorio.exists());
//		System.out.println(miArchivo.isFile());
//		System.out.println(miDirectorio.isDirectory());
//		System.out.println(miDirectorio.lastModified());
//		
//		long longtime = miDirectorio.lastModified();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
//		Date date = new Date(longtime);
//		
//		System.out.println(dateFormat.format(date));
//		
//		try(FileReader fr = new FileReader("C:\\Users\\20207\\Desktop\\pruebaDirectorio\\prueba.txt", StandardCharsets.UTF_8); 
//			BufferedReader br = new BufferedReader(fr);
//			FileWriter fw = new FileWriter("C:\\Users\\20207\\Desktop\\pruebaDirectorio\\prueba.txt", StandardCharsets.UTF_8, true)){
//			fw.write("Hola Fadón,\n¿Cómo estás?");
//			fw.flush();
//			String linea;
//			
//			while((linea = br.readLine()) != null) {
//				System.out.println(linea);
//			}
//		}
		
		File miDirectorio = new File("C:\\Users\\20207\\Desktop");
		
		String[] listadoDirectorio = miDirectorio.list();
		
		for(String elemento : listadoDirectorio) {
			System.out.println(elemento);
		}
		
		File[] listadoFicheros = miDirectorio.listFiles();
		
		for (File elemento : listadoFicheros) {
			System.out.println(elemento.getName());
		}
	}
}