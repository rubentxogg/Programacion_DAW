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
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void menuInsertarCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el número del cliente: ");
		int numeroCliente = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombreCliente = sc.nextLine();
		System.out.println("Introduzca por favor el apellido del contacto: ");
		String apellidoContacto = sc.nextLine();
		System.out.println("Introduzca por favor el nombre del contacto: ");
		String nombreContacto = sc.nextLine();
		System.out.println("Introduzca por favor el teléfono del cliente: ");
		String telefono = sc.nextLine();
		System.out.println("Introduzca por favor la dirección del cliente: ");
		String direccion1 = sc.nextLine();
		System.out.println("Introduzca por favor la direccion 2 del cliente: ");
		String direccion2 = sc.nextLine();
		System.out.println("Introduzca por favor la ciudad del cliente: ");
		String ciudad = sc.nextLine();
		System.out.println("Introduzca por favor el estado del cliente: ");
		String estado = sc.nextLine();
		System.out.println("Introduzca por favor el código postal del cliente: ");
		String codigoPostal = sc.nextLine();
		System.out.println("Introduzca por favor el pais: ");
		String pais = sc.nextLine();
		System.out.println("Introduzca por favor el id del representante: ");
		int representante = 0;
		
		try {
			representante = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el número de representante de ventas");
		}
		
		System.out.println("Introduzca por favor crédito (número con decimales): ");
		Double credito = 0.0;
		
		try {
			credito = Double.parseDouble(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("No se ha introducido crédito");
		}
		
		ClientesControlador controladorClientes = new ClientesControlador();
		int resultado = controladorClientes.insertarCliente(numeroCliente, 
				nombreCliente, 
				apellidoContacto, 
				nombreContacto,
				telefono,
				direccion1,
				direccion2,
				ciudad, 
				estado,
				codigoPostal,
				pais,
				representante,
				credito);
		
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void menuActualizarCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el número del cliente: ");
		int numeroCliente = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombreCliente = sc.nextLine();
		System.out.println("Introduzca por favor el apellido del contacto: ");
		String apellidoContacto = sc.nextLine();
		System.out.println("Introduzca por favor el nombre del contacto: ");
		String nombreContacto = sc.nextLine();
		System.out.println("Introduzca por favor el teléfono del cliente: ");
		String telefono = sc.nextLine();
		System.out.println("Introduzca por favor la dirección del cliente: ");
		String direccion1 = sc.nextLine();
		System.out.println("Introduzca por favor la direccion 2 del cliente: ");
		String direccion2 = sc.nextLine();
		System.out.println("Introduzca por favor la ciudad del cliente: ");
		String ciudad = sc.nextLine();
		System.out.println("Introduzca por favor el estado del cliente: ");
		String estado = sc.nextLine();
		System.out.println("Introduzca por favor el código postal del cliente: ");
		String codigoPostal = sc.nextLine();
		System.out.println("Introduzca por favor el pais: ");
		String pais = sc.nextLine();
		System.out.println("Introduzca por favor el id del representante: ");
		int representante = 0;
		
		try {
			representante = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el número de representante de ventas");
		}
		
		System.out.println("Introduzca por favor crédito (número con decimales): ");
		Double credito = 0.0;
		
		try {
			credito = Double.parseDouble(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("No se ha introducido crédito");
		}
		
		ClientesControlador controladorClientes = new ClientesControlador();
		int resultado = controladorClientes.actualizarCliente(numeroCliente, 
				nombreCliente, 
				apellidoContacto, 
				nombreContacto,
				telefono,
				direccion1,
				direccion2,
				ciudad, 
				estado,
				codigoPostal,
				pais,
				representante,
				credito);
		
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
}
