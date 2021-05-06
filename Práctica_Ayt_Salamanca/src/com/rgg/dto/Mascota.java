package com.rgg.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rubentxo
 * Clase con métodos que solicitan al usuario los datos de la mascota
 */
public class Mascota {

	private List<MascotaDTO> listaMascotas = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	private int cont = 1;
	
	/**
	 * Solicita al usuario los datos de la mascota y los guarda en una lista
	 */
	public void solicitarDatosMascota() {
		boolean continuar = true;
		String respuesta;
		MascotaDTO mascota = new MascotaDTO();
		
		while(continuar) {
			System.out.print("Introduzca el nombre de la mascota: ");
			mascota.setNombre(sc.nextLine());
			System.out.print("Introduzca la edad: ");
			mascota.setEdad(sc.nextInt());
			sc.nextLine();
			System.out.print("Introduzca la especie: ");
			mascota.setEspecie(sc.nextLine());
			
			listaMascotas.add(mascota);
			System.out.println("\nMascota añadida, ¿Desea continuar? s/n");
			respuesta = sc.next();
			sc.nextLine();
			continuar = (respuesta.equalsIgnoreCase("s"))?continuar:!continuar;
		}
	}

	/**
	 * @return the listaMascotas
	 */
	public List<MascotaDTO> getListaMascotas() {
		return listaMascotas;
	}
	
	/**
	 * Muestra los datos guardados en la lista de mascotas
	 */
	public void mostrarListaMascotas() {
		Iterator<MascotaDTO> i = listaMascotas.iterator();
		
		System.out.println("\n-=Lista de mascotas=-\n");
		while(i.hasNext()) {
			MascotaDTO m = i.next();
			System.out.println("#"+cont);
			System.out.println("Nombre: "+m.getNombre());
			System.out.println("Edad: "+m.getEdad());
			System.out.println("Especie: "+m.getEspecie()+"\n");
			cont++;
		}
	}
}
