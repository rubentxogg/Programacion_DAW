package com.rgg.classicmodels.vista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.rgg.classicmodels.controlador.EmpleadoControlador;
import com.rgg.classicmodels.utils.MiScanner;
import com.rgg.dto.EmpleadoDTO;

/**
 * @author Rubentxo
 *
 */
public class EmpleadoVista {

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuBuscarEmpleadoNumeroApellidoNombreExtensionPuesto() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el n�mero del empleado:");
		int numEmpleado = 0;
		try {
			numEmpleado = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el n�mero del empleado\n");
			return;
		}
		
		System.out.println("Introduzca el apellido:");
		String apellido = sc.nextLine();
		System.out.println("Introduzca el nombre:");
		String nombre = sc.nextLine();
		System.out.println("Introduzca la extension:");
		String extension = sc.nextLine();
		System.out.println("Introduzca su puesto:");
		String puesto = sc.nextLine();
		
		EmpleadoControlador controladorEmpleado = new EmpleadoControlador();
		List<EmpleadoDTO> listaEmpleados = controladorEmpleado.buscarEmpleadoNumeroApellidoNombreExtensionPuesto(numEmpleado, apellido, nombre, extension, puesto);
		
		for(EmpleadoDTO empleado : listaEmpleados) {
			System.out.println("[N�mero: "+empleado.getNumeroEmpleado()+"] "+empleado.getApellido()+" "+empleado.getNombre()+" "+empleado.getExtension()+" "+empleado.getPuesto());
		}
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuInsertarEmpleado() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el n�mero de empleado:");
		int numEmpleado = 0;
		try {
			numEmpleado = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido ning�n n�mero\n");
			return;
		}
		
		System.out.println("Introduzca el apellido del empleado:");
		String apellido = sc.nextLine();
		System.out.println("Introduzca el nombre del empleado:");
		String nombre = sc.nextLine();
		System.out.println("Introduzca la extensi�n del empleado:");
		String extension = sc.nextLine();
		System.out.println("Introduzca el email del empleado:");
		String email = sc.nextLine();
		System.out.println("Introduzca el c�digo de oficina:");
		String codigoOficina = sc.nextLine();
		
		System.out.println("Introduzca el n�mero de reporte:");
		int numReporte = 0;
		try {
			numReporte = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido ning�n n�mero\n");
		}
		
		System.out.println("Introduzca el puesto:");
		String puesto = sc.nextLine();
		
		EmpleadoControlador controladorEmpleado = new EmpleadoControlador();
		
		String resultado = (controladorEmpleado.insertarEmpleado(numEmpleado,
				apellido,
				nombre,
				extension,
				email,
				codigoOficina,
				numReporte,
				puesto).equals(1)?"Empleado introducido con �xito\n":"No se ha podido introducir al empleado\n");
		System.out.println(resultado);
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuActualizarEmpleado() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el n�mero del empleado a actualizar:");
		int numEmpleado = 0;
		try{
			numEmpleado = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el n�mero del empleado");
			return;
		}
		
		System.out.println("Introduzca el apellido:");
		String apellido = sc.nextLine();
		System.out.println("Introduzca el nombre:");
		String nombre = sc.nextLine();
		System.out.println("Introduzca la extensi�n:");
		String extension = sc.nextLine();
		System.out.println("Introduzca el email:");
		String email = sc.nextLine();
		System.out.println("Introduzca el c�digo de oficina:");
		String codigoOficina = sc.nextLine();
		
		System.out.println("Introduzca el n�mero de reporte:");
		int numReporte = 0;
		try{
			numReporte = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el n�mero de reporte");
		}
		
		System.out.println("Introduzca el puesto:");
		String puesto = sc.nextLine();
		
		EmpleadoControlador controladorEmpleado = new EmpleadoControlador();
		
		String resultado = (controladorEmpleado.actualizarEmpleado(numEmpleado,
				apellido,
				nombre,
				extension, 
				email,
				codigoOficina,
				numReporte, 
				puesto).equals(1)?"Empleado actualizado con �xito\n":"No se ha podido actualizar al empleado\n");
		System.out.println(resultado);
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void menuGeneralEmpleado() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do{
			System.out.println("Introduzca la operaci�n que desee realizar: ");
			
		    System.out.println("\n       MEN� PRINCIPAL PARA LA GESTI�N DE EMPLEADOS");
		    System.out.println("===============================================");
		    System.out.println("1. Buscar empleado por n�mero, apellido, nombre, extensi�n y puesto:");
		    System.out.println("2. Insertar empleado");
		    System.out.println("3. Actualizar empleado");
		    System.out.println("4. Volver al men� principal");
		    System.out.println("===============================================");
		    
		    n = Integer.parseInt(sc.nextLine());
            
            switch(n) {
            	case 1: menuBuscarEmpleadoNumeroApellidoNombreExtensionPuesto();
            			break;
            	case 2: menuInsertarEmpleado();
            			break;
            	case 3: menuActualizarEmpleado();
            			break;
            	case 4: return;
            	default: System.out.print("Elecci�n invalida, int�ntalo otra vez...");
                		break;
            }
	    	
	    } while(n!=4);
	}
}
