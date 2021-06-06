package com.rgg.classicmodels.vista;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.rgg.classicmodels.controlador.LineaProductoControlador;
import com.rgg.classicmodels.utils.MiScanner;
import com.rgg.dto.LineaProductoDTO;

/**
 * @author Rubentxo
 *
 */
public class LineaProductoVista {

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuBuscarLineaProductoFiltraNombreyDescripcion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el nombre de la l�nea de producto:");
		String nombre = sc.nextLine();
		System.out.println("Introduzca la descripci�n de la l�nea de producto:");
		String descripcion = sc.nextLine();
		
		LineaProductoControlador controladorLineaProducto = new LineaProductoControlador();
		List<LineaProductoDTO> listaLineasProductos = controladorLineaProducto.buscarLineaProductoFiltraNombreyDescripcion(nombre, descripcion);
		
		for(LineaProductoDTO lineaProducto : listaLineasProductos) {
			System.out.println(lineaProducto.getNombre()+" [Descripci�n: "+lineaProducto.getDescripcion()+"]");
		}
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuInsertarLineaProducto() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el nombre de la l�nea de producto a insertar:");
		String nombre = sc.nextLine();
		System.out.println("Introduzca la descripci�n:");
		String descripcion = sc.nextLine();
		System.out.println("Introduzca la descripci�n HTML:");
		String descripcionHTML = sc.nextLine();
		System.out.println("Introduzca la URI de la imagen:");
		String imagenUri = sc.nextLine();
		File imagen = new File(imagenUri);
		
		LineaProductoControlador controladorLineaProducto = new LineaProductoControlador();
		
		String resultado = (controladorLineaProducto.insertarLineaProducto(nombre, descripcion, descripcionHTML, imagen).equals(1)?"Se ha introducido el producto con �xito\n":"Se ha producido un error al introducir el producto\n");
		System.out.println(resultado);
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuActualizarLineaProducto() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el nombre de la l�nea de producto a actualizar:");
		String nombre = sc.nextLine();
		System.out.println("Introduzca la descripci�n:");
		String descripcion = sc.nextLine();
		System.out.println("Introduzca la descripci�n HTML:");
		String descripcionHTML = sc.nextLine();
		System.out.println("Introduzca la URI de la imagen:");
		String imagenUri = sc.nextLine();
		File imagen = new File(imagenUri);
		
		LineaProductoControlador controladorLineaProducto = new LineaProductoControlador();
		
		String resultado = (controladorLineaProducto.actualizarLineaProducto(nombre, descripcion, descripcionHTML, imagen).equals(1)?"El producto ha sido actualizado con �xito\n":"Se ha producido un error al intentar actualizar el producto\n");
		System.out.println(resultado);
		
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void menuGeneralLineaProducto() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do{
			System.out.println("Introduzca la operaci�n que desee realizar: ");
			
		    System.out.println("\n       MEN� PRINCIPAL PARA LA GESTI�N DE L�NEAS DE PRODUCTOS ");
		    System.out.println("===============================================");
		    System.out.println("1. Buscar l�neas de productos por nombre y descripci�n");
		    System.out.println("2. Insertar l�nea de producto");
		    System.out.println("3. Actualizar l�nea de producto");
		    System.out.println("4. Volver al men� principal");
		    System.out.println("===============================================");
		    
		    n = Integer.parseInt(sc.nextLine());
            
            switch(n) {
            	case 1: menuBuscarLineaProductoFiltraNombreyDescripcion();
            			break;
            	case 2: menuInsertarLineaProducto();
            			break;
            	case 3: menuActualizarLineaProducto();
            			break;
            	case 4: return;
            	default: System.out.print("Elecci�n invalida, int�ntalo otra vez...");
                		break;
            }
	    	
	    } while(n!=4);
	}
}
