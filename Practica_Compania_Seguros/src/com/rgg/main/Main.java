package com.rgg.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.rgg.comparators.CompararColor;
import com.rgg.comparators.CompararEdad;
import com.rgg.comparators.CompararKMS;
import com.rgg.dto.Coche;
import com.rgg.dto.Persona;
import com.rgg.enums.Colores;

public class Main {

	static List<Persona> listaPersonas = new ArrayList<>();
	
	public static void main(String[] args) {
		Persona p1 = new Persona(1, 35);
		Persona p2 = new Persona(2, 23);
		Persona p3 = new Persona(3, 26);
		
		Coche c1 = new Coche("Opel", Colores.AMARILLO, 32312);
		Coche c2 = new Coche("Seat", Colores.ROJO, 25636);
		Coche c3 = new Coche("Audi", Colores.GRIS, 40000);
		
		p1.setCoche(c2);
		p2.setCoche(c3);
		p3.setCoche(c1);
		
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("¿Cómo desea ordenar la lista?"
				+"\n1.Por edad"
				+"\n2.Por KMS"
				+"\n3.Por color"
				+ "\nOpción: ");
		int opc = sc.nextInt();
		
		switch(opc) {
			case 1: Collections.sort(listaPersonas, new CompararEdad());
					break;
			case 2: Collections.sort(listaPersonas, new CompararKMS());
					break;
			case 3: Collections.sort(listaPersonas, new CompararColor());
					break;
			default: System.err.println("Ha seleccionado una opción inválida, programa finalizado.");
		}
		
		Iterator<Persona> i = listaPersonas.iterator();
		
		while(i.hasNext()) {
			Persona persona = i.next();
			System.out.println("ID: "+persona.getId()+", Edad: "+persona.getEdad()+", Coche: "+persona.getCoche().getMarca()+", Color del coche: "+persona.getCoche().getColor()+", KMS: "+persona.getCoche().getKilometros());
		}
	}

}
