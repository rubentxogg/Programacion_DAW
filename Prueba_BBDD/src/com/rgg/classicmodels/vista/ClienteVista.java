package com.rgg.classicmodels.vista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.rgg.classicmodels.controlador.ClientesControlador;
import com.rgg.classicmodels.utils.MiScanner;
import com.rgg.dto.ClienteDTO;

public class ClienteVista {
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void menuRecuperaNombreTelefono() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca el nombre del empleado: ");
		
		String nombreEmpleado = sc.nextLine();
		
		ClientesControlador controladorClientes = new ClientesControlador();
		List <ClienteDTO> listaClientes = controladorClientes.recuperaNombreTelefono(nombreEmpleado);
		
		for(ClienteDTO cliente : listaClientes) {
			System.out.println(cliente.getNombre()+ " "+ cliente.getTelefono());
		}
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void menuRecuperaNombreTelefonoFiltraporNombreTfnoPais() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el nombre del empleado: ");
		String nombreEmpleado = sc.nextLine();
		
		System.out.println("Introduzca el teléfono del empleado: ");
		String tfnoEmpleado = sc.nextLine();
		
		System.out.println("Introduzca el país del empleado: ");
		String paisEmpleado = sc.nextLine();
		
		ClientesControlador controladorClientes = new ClientesControlador();
		List <ClienteDTO> listaClientes = controladorClientes.recuperaNombreTelefonoFiltraporNombreTfnoPais(nombreEmpleado, tfnoEmpleado, paisEmpleado);
		
		for(ClienteDTO cliente : listaClientes) {
			System.out.println(cliente.getNombre()+ " "+ cliente.getTelefono());
		}
	}
}
