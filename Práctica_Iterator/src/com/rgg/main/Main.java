package com.rgg.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.rgg.dto.Siniestro;

public class Main {
	static List<Siniestro> listaSiniestros = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opc;
		int cont = 0;
		
		System.out.println("[Bienvenido a seguros T-Timo, ¿Qué desea?]");
		do {
			System.out.println("\n1. Añadir un siniestro.");
			System.out.println("0. Salir.");
			opc = sc.nextInt();
			
			if(opc == 1) {
				Siniestro siniestro = new Siniestro();
				
				System.out.print("Introduzca el ID de cliente: ");
				siniestro.setIdCliente(sc.nextInt());
				System.out.print("Introduzca el nombre: ");
				siniestro.setNombre(sc.next());
				System.out.print("Introduzca la ciudad de residencia: ");
				siniestro.setCiudadResidencia(sc.next());
				System.out.print("Introduzca una descripción corta: ");
				siniestro.setDescripcion(sc.next());
				listaSiniestros.add(siniestro);
			}
			
		} while(opc != 0);
		
		Iterator<Siniestro> i = listaSiniestros.iterator();
		
		System.out.println("[Lista de siniestros]");
		while(i.hasNext()) {
			Siniestro s = i.next();
			System.out.println("Siniestro #"+cont);
			System.out.println(s.getIdCliente());
			System.out.println(s.getNombre());
			System.out.println(s.getCiudadResidencia());
			System.out.println(s.getDescripcion());
			System.out.println();
			cont++;
		}
	}
}
