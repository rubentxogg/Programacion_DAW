package com.rgg.main;

import java.util.Scanner;
import java.util.TreeSet;

import com.rgg.dto.Persona;

public class Main {

	public static void main(String[] args) {
		
		TreeSet<Persona> personaTreeSet = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		String opc;
		
		menuPersonas(personaTreeSet, sc);
		imprimirPersonas(personaTreeSet);
	}

	/**
	 * @param personaTreeSet
	 */
	private static void imprimirPersonas(TreeSet<Persona> personaTreeSet) {
		System.out.println();
		for(Persona persona : personaTreeSet) {
			System.out.println(persona);
		}
	}

	/**
	 * @param personaTreeSet
	 * @param sc
	 */
	private static void menuPersonas(TreeSet<Persona> personaTreeSet, Scanner sc) {
		String opc;
		do {
			Persona persona = new Persona();
			System.out.print("Introduzca el nombre de la persona: ");
			persona.setNombre(sc.nextLine());
			
			System.out.print("Introduzca la edad de la persona: ");
			persona.setEdad(sc.nextInt());
			sc.nextLine();
			
			System.out.print("¿Desea introducir otra persona? S/N: ");
			opc = sc.nextLine();
			
			personaTreeSet.add(persona);
		}while(opc.equalsIgnoreCase("s"));
	}

}
