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
	private void menuRecuperaNombreTelefono() throws ClassNotFoundException, SQLException {
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
	private void menuRecuperaNombreTelefonoFiltraporNombreTfnoPais() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el nombre del empleado: ");
		String nombreEmpleado = sc.nextLine();
		
		System.out.println("Introduzca el tel�fono del empleado: ");
		String tfnoEmpleado = sc.nextLine();
		
		System.out.println("Introduzca el pa�s del empleado: ");
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
	private void menuInsertarCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el n�mero del cliente: ");
		int numeroCliente = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombreCliente = sc.nextLine();
		System.out.println("Introduzca por favor el apellido del contacto: ");
		String apellidoContacto = sc.nextLine();
		System.out.println("Introduzca por favor el nombre del contacto: ");
		String nombreContacto = sc.nextLine();
		System.out.println("Introduzca por favor el tel�fono del cliente: ");
		String telefono = sc.nextLine();
		System.out.println("Introduzca por favor la direcci�n del cliente: ");
		String direccion1 = sc.nextLine();
		System.out.println("Introduzca por favor la direccion 2 del cliente: ");
		String direccion2 = sc.nextLine();
		System.out.println("Introduzca por favor la ciudad del cliente: ");
		String ciudad = sc.nextLine();
		System.out.println("Introduzca por favor el estado del cliente: ");
		String estado = sc.nextLine();
		System.out.println("Introduzca por favor el c�digo postal del cliente: ");
		String codigoPostal = sc.nextLine();
		System.out.println("Introduzca por favor el pais: ");
		String pais = sc.nextLine();
		System.out.println("Introduzca por favor el id del representante: ");
		int representante = 0;
		
		try {
			representante = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el n�mero de representante de ventas");
		}
		
		System.out.println("Introduzca por favor cr�dito (n�mero con decimales): ");
		Double credito = 0.0;
		
		try {
			credito = Double.parseDouble(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("No se ha introducido cr�dito");
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
			System.out.println("Se ha introducido el registro con �xito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuActualizarCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el n�mero del cliente: ");
		int numeroCliente = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca por favor el nombre del cliente: ");
		String nombreCliente = sc.nextLine();
		System.out.println("Introduzca por favor el apellido del contacto: ");
		String apellidoContacto = sc.nextLine();
		System.out.println("Introduzca por favor el nombre del contacto: ");
		String nombreContacto = sc.nextLine();
		System.out.println("Introduzca por favor el tel�fono del cliente: ");
		String telefono = sc.nextLine();
		System.out.println("Introduzca por favor la direcci�n del cliente: ");
		String direccion1 = sc.nextLine();
		System.out.println("Introduzca por favor la direccion 2 del cliente: ");
		String direccion2 = sc.nextLine();
		System.out.println("Introduzca por favor la ciudad del cliente: ");
		String ciudad = sc.nextLine();
		System.out.println("Introduzca por favor el estado del cliente: ");
		String estado = sc.nextLine();
		System.out.println("Introduzca por favor el c�digo postal del cliente: ");
		String codigoPostal = sc.nextLine();
		System.out.println("Introduzca por favor el pais: ");
		String pais = sc.nextLine();
		System.out.println("Introduzca por favor el id del representante: ");
		int representante = 0;
		
		try {
			representante = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el n�mero de representante de ventas");
		}
		
		System.out.println("Introduzca por favor cr�dito (n�mero con decimales): ");
		Double credito = 0.0;
		
		try {
			credito = Double.parseDouble(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("No se ha introducido cr�dito");
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
			System.out.println("Se ha introducido el registro con �xito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuBorrarCliente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.print("Introduzca el n�mero del cliente a borrar: ");
		int numCliente = 0;
		
		try {
			numCliente = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el n�mero del cliente");
		}
		
		ClientesControlador controladorClientes = new ClientesControlador();
		String resultado = (controladorClientes.borrarCliente(numCliente).equals(1))?"Cliente borrado con �xito.":"No se ha encontrado ning�n cliente con ese n�mero.";
		System.out.println(resultado);
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void menuGeneralCliente() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do{
			System.out.println("Introduzca la operaci�n que desee realizar: ");
			
		    System.out.println("       MEN� PRINCIPAL PARA LA GESTI�N DE CLIENTES");
		    System.out.println("===============================================");
		    System.out.println("1. Buscar cliente por nombre");
		    System.out.println("2. Buscar cliente por nombre, tel�fono o pa�s");
		    System.out.println("3. Insertar cliente ");
		    System.out.println("4. Actualizar cliente ");
		    System.out.println("5. Borrar cliente");
		    System.out.println("6. Volver al men� principal");
		    System.out.println("===============================================");
		    
		    n = Integer.parseInt(sc.nextLine());
            
            switch(n) {
            	case 1: menuRecuperaNombreTelefono();
            			break;
            	case 2: menuRecuperaNombreTelefonoFiltraporNombreTfnoPais();
            			break;
            	case 3: menuInsertarCliente();
            			break;
            	case 4: menuActualizarCliente();
            			break;
            	case 5: menuBorrarCliente();
            			break;
            	case 6: return;
            	default: System.out.print("Elecci�n invalida, int�ntalo otra vez...");
                		break;
            }
	    	
	    } while(n!=6);
	}
}
