package com.rgg.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rgg.dto.Persona;

public class Main {

	public static void main(String[] args) {
		
		List<Persona> listaPersonas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String opc;
		
		do {
			Persona p = new Persona();
			System.out.print("Introduzca el nombre de la persona: ");
			p.setNombre(sc.nextLine());
			
			System.out.print("Introduzca la edad de la persona: ");
			p.setEdad(sc.nextInt());
			sc.nextLine();
			
			System.out.print("¿Desea introducir otra persona? S/N: ");
			opc = sc.nextLine();
		}while(opc.equalsIgnoreCase("s"));
	}

}
