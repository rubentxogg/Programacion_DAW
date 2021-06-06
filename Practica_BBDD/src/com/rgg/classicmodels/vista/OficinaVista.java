package com.rgg.classicmodels.vista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.rgg.classicmodels.controlador.OficinaControlador;
import com.rgg.classicmodels.utils.MiScanner;
import com.rgg.dto.OficinaDTO;

/**
 * @author Rubentxo
 *
 */
public class OficinaVista {

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuBuscarOficinaFiltraCodigoCiudadEstadoPais() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el código de oficina:");
		String codigoOficina = sc.nextLine();
		System.out.println("Introduzca la ciudad de la oficina:");
		String ciudad = sc.nextLine();
		System.out.println("Introduzca el estado de la oficina:");
		String estado = sc.nextLine();
		System.out.println("Introduzca el país de la oficina:");
		String pais = sc.nextLine();
		
		OficinaControlador controladorOficina = new OficinaControlador();
		List<OficinaDTO> listaOficinas = controladorOficina.buscarOficinaFiltraCodigoCiudadEstadoPais(codigoOficina, ciudad, estado, pais);
		
		for(OficinaDTO oficina : listaOficinas) {
			System.out.println(oficina.getCodigoOficina()+" "+oficina.getCiudad()+" "+oficina.getEstado()+" "+oficina.getPais());
		}
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuInsertarOficina() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el código de oficina:");
		String codigoOficina = sc.nextLine();
		System.out.println("Introduzca la ciudad de la oficina:");
		String ciudad = sc.nextLine();
		System.out.println("Introduzca el telefono de la oficina:");
		String telefono = sc.nextLine();
		System.out.println("Introduzca la direccion 1 de la oficina:");
		String direccion1 = sc.nextLine();
		System.out.println("Introduzca la direccion 2 de la oficina:");
		String direccion2 = sc.nextLine();
		System.out.println("Introduzca el estado de la oficina:");
		String estado = sc.nextLine();
		System.out.println("Introduzca el país de la oficina:");
		String pais = sc.nextLine();
		System.out.println("Introduzca el código postal de la oficina:");
		String codigoPostal = sc.nextLine();
		System.out.println("Introduzca el territorio de la oficina:");
		String territorio = sc.nextLine();
		
		OficinaControlador controladorOficina = new OficinaControlador();
		
		String resultado = (controladorOficina.insertarOficina(codigoOficina,
				ciudad,
				telefono,
				direccion1,
				direccion2,
				estado,
				pais,
				codigoPostal,
				territorio).equals(1)?"Oficina insertada con éxito\n":"No se ha podido insertar la oficina\n");
		System.out.println(resultado);
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuActualizarOficina() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el código de oficina a actualizar:");
		String codigoOficina = sc.nextLine();
		System.out.println("Introduzca la ciudad de la oficina:");
		String ciudad = sc.nextLine();
		System.out.println("Introduzca el telefono de la oficina:");
		String telefono = sc.nextLine();
		System.out.println("Introduzca la direccion 1 de la oficina:");
		String direccion1 = sc.nextLine();
		System.out.println("Introduzca la direccion 2 de la oficina:");
		String direccion2 = sc.nextLine();
		System.out.println("Introduzca el estado de la oficina:");
		String estado = sc.nextLine();
		System.out.println("Introduzca el país de la oficina:");
		String pais = sc.nextLine();
		System.out.println("Introduzca el código postal de la oficina:");
		String codigoPostal = sc.nextLine();
		System.out.println("Introduzca el territorio de la oficina:");
		String territorio = sc.nextLine();
		
		OficinaControlador controladorOficina = new OficinaControlador();
		
		String resultado = (controladorOficina.actualizarOficina(codigoOficina,
				ciudad,
				telefono,
				direccion1,
				direccion2,
				estado,
				pais,
				codigoPostal,
				territorio).equals(1)?"Oficina actualizada con éxito\n":"No se ha podido actualizar la oficina\n");
		System.out.println(resultado);
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void menuGeneralOficina() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do{
			System.out.println("Introduzca la operación que desee realizar: ");
			
		    System.out.println("\n       MENÚ PRINCIPAL PARA LA GESTIÓN DE OFICINAS");
		    System.out.println("===============================================");
		    System.out.println("1. Buscar oficina por código, ciudad, estado y país");
		    System.out.println("2. Insertar oficina");
		    System.out.println("3. Actualizar oficina");
		    System.out.println("4. Volver al menú principal");
		    System.out.println("===============================================");
		    
		    n = Integer.parseInt(sc.nextLine());
            
            switch(n) {
            	case 1: menuBuscarOficinaFiltraCodigoCiudadEstadoPais();
            			break;
            	case 2: menuInsertarOficina();
            			break;
            	case 3: menuActualizarOficina();
            			break;
            	case 4: return;
            	default: System.out.print("Elección invalida, inténtalo otra vez...");
                		break;
            }
	    	
	    } while(n!=4);
	}
}
