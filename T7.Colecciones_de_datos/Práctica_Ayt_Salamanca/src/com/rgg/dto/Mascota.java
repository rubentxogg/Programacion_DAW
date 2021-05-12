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
	private List<MascotaDTO> listaPerros = new ArrayList<>();
	private List<MascotaDTO> listaGatos = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Solicita al usuario los datos de la mascota y los guarda en una lista
	 */
	public void solicitarDatosMascota() {
		boolean continuar = true;
		String respuesta;
		
		while(continuar) {
			MascotaDTO mascota = new MascotaDTO();
			System.out.print("\nIntroduzca el nombre de la mascota: ");
			mascota.setNombre(sc.nextLine());
			System.out.print("Introduzca la edad: ");
			mascota.setEdad(sc.nextInt());
			sc.nextLine();
			System.out.print("Introduzca la especie: ");
			mascota.setEspecie(sc.nextLine());
			
			listaMascotas.add(mascota);
			System.out.print("\nMascota añadida, ¿Desea añadir otra? s/n: ");
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
	 * Retira de la lista de mascotas a los perros y los gatos y los introduce en su lista correspondiente
	 */
	public void clasificarMascotas() {
		Iterator<MascotaDTO> iterator = listaMascotas.iterator();
		
		while(iterator.hasNext()) {
			MascotaDTO mascota = iterator.next();
			switch(mascota.getEspecie().toLowerCase()) {
				case "perro": listaPerros.add(mascota);
							  System.out.println("Perro añadido a su lista correspondiente.");
							  iterator.remove();
							  break;
				
				case "gato":  listaGatos.add(mascota);
							  System.out.println("Gato añadido a su lista correspondiente.");
							  iterator.remove();
							  break;
				
				default: System.out.println("Ningún animal añadido.");
						 break;
			}
		}
	}
	
	/**
	 * Muestra los datos guardados en la lista de mascotas
	 */
	public void mostrarListaMascotas() {
		Iterator<MascotaDTO> iterator = listaMascotas.iterator();
		int cont = 1;
		
		System.out.println("\n-=Lista de mascotas=-\n");
		while(iterator.hasNext()) { // Iterator
			MascotaDTO mascota = iterator.next();
			System.out.println("#"+cont);
			System.out.println("Nombre: "+mascota.getNombre());
			System.out.println("Edad: "+mascota.getEdad());
			System.out.println("Especie: "+mascota.getEspecie()+"\n");
			cont++;
		}
	}
	
	/**
	 * Muestra los datos guardados en la lista de perros
	 */
	public void mostrarListaPerros() {
		Iterator<MascotaDTO> iterator = listaPerros.iterator();
		int cont = 1;
		
		System.out.println("\n-=Lista de perros=-\n"); 
		for(MascotaDTO perro : listaPerros) { // For-each
			System.out.println("#"+cont);
			System.out.println("Nombre: "+perro.getNombre());
			System.out.println("Edad: "+perro.getEdad());
			System.out.println("Especie: "+perro.getEspecie()+"\n");
			cont++;
		}
	}
	
	/**
	 * Muestra los datos guardados en la lista de gatos
	 */
	public void mostrarListaGatos() {
		int cont = 1;
		Iterator<MascotaDTO> iterator = listaGatos.iterator();
		
		System.out.println("\n-=Lista de gatos=-\n");
		
		listaGatos.forEach(gato -> { // Lambda
			System.out.println("#"+cont);
			System.out.println("Nombre: "+gato.getNombre());
			System.out.println("Edad: "+gato.getEdad());
			System.out.println("Especie: "+gato.getEspecie()+"\n");
		});
	}
}
