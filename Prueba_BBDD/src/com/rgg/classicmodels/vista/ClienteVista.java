package com.rgg.classicmodels.vista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.rgg.classicmodels.controlador.ClientesControlador;
import com.rgg.classicmodels.utils.MiScanner;
import com.rgg.dto.ClienteDTO;

public class ClienteVista {
	
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
}
