package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import pruebas.PruebaFileVisitor;

public class Main {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("C:\\Users\\20207\\Desktop\\RGG");
		
		PruebaFileVisitor visitador = new PruebaFileVisitor();
		Files.walkFileTree(p, visitador);
	}
}
