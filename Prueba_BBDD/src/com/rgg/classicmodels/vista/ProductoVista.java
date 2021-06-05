package com.rgg.classicmodels.vista;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.rgg.classicmodels.controlador.ProductoControlador;
import com.rgg.classicmodels.utils.MiScanner;
import com.rgg.dto.ProductoDTO;

public class ProductoVista {

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuBuscarbuscarProductoFiltraCodigoNombreLineaDescripcion() throws ClassNotFoundException, SQLException{
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el código del producto:");
		String codigoProducto = sc.nextLine();
		System.out.println("Introduzca el nombre del producto:");
		String nombreProducto = sc.nextLine();
		System.out.println("Introduzca la línea de producto:");
		String lineaProducto = sc.nextLine();
		System.out.println("Introduzca la descripción del producto:");
		String descripcionProducto = sc.nextLine();
		
		ProductoControlador controladorProducto = new ProductoControlador();
		List<ProductoDTO> listaProductos = controladorProducto.buscarProductoFiltraLineaProductoyDescripcion(codigoProducto, nombreProducto, lineaProducto, descripcionProducto);
		
		for(ProductoDTO producto : listaProductos) {
			System.out.println("[Código "+producto.getCodigoProducto()+"] "+producto.getNombreProducto()+" [Línea "+producto.getLineaProducto()+"] [Cantidad "+producto.getCantidadEnStock()+"]");
		}
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuInsertarProducto() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el código del producto:");
		String codigoProducto = sc.nextLine();
		System.out.println("Introduzca el nombre del producto:");
		String nombreProducto = sc.nextLine();
		System.out.println("Introduzca la línea de producto:");
		String lineaProducto = sc.nextLine();
		System.out.println("Introduzca la escala del producto:");
		String escalaProducto = sc.nextLine();
		System.out.println("Introduzca el vendedor del producto:");
		String vendedorProducto = sc.nextLine();
		System.out.println("Introduzca la descripción del producto:");
		String descripcionProducto = sc.nextLine();
		
		System.out.println("Introduzca la cantidad en stock:");
		int cantidadEnStock = 0;
		try{
			cantidadEnStock = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido la cantidad en stock");
		}
		
		System.out.println("Introduzca el precio de compra:");
		double precioCompra = 0;
		try{
			precioCompra = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el precio de compra");
		}
		
		System.out.println("Introduzca el MSRP:");
		double msrp = 0;
		try{
			msrp = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el msrp");
		}
		
		ProductoControlador controladorProducto = new ProductoControlador();
		
		String resultado = (controladorProducto.insertarProducto(codigoProducto,
				nombreProducto,
				lineaProducto,
				escalaProducto,
				vendedorProducto,
				descripcionProducto,
				cantidadEnStock, 
				precioCompra,
				msrp).equals(1)?"Producto introducido con éxito\n":"Se ha producido un error al introducir el producto\n");
		System.out.println(resultado);
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuActualizarProducto() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el código de producto a actualizar:");
		String codigoProducto = sc.nextLine();
		System.out.println("Introduzca el nombre del producto:");
		String nombreProducto = sc.nextLine();
		System.out.println("Introduzca la linea del producto:");
		String lineaProducto = sc.nextLine();
		System.out.println("Introduzca la escala del producto:");
		String escalaProducto = sc.nextLine();
		System.out.println("Introduzca el vendedor del producto:");
		String vendedorProducto = sc.nextLine();
		System.out.println("Introduzca la descripcion del producto:");
		String descripcionProducto = sc.nextLine();
		
		System.out.println("Introduzca la cantidad en stock:");
		int cantidadEnStock = 0;
		try{
			cantidadEnStock = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido la cantidad en stock");
		}
		
		System.out.println("Introduzca el precio de compra:");
		double precioCompra = 0;
		try{
			precioCompra = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el precio de compra");
		}
		
		System.out.println("Introduzca el MSRP:");
		double msrp = 0;
		try{
			msrp = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("No se ha introducido el msrp");
		}
		
		ProductoControlador controladorProducto = new ProductoControlador();
		
		String resultado = (controladorProducto.actualizarProducto(codigoProducto, 
				nombreProducto,
				lineaProducto,
				escalaProducto,
				vendedorProducto,
				descripcionProducto,
				cantidadEnStock, 
				precioCompra,
				msrp).equals(1)?"El producto ha sido actualizado con éxito\n":"Se ha producido un error en la actualización del producto\n");
		System.out.println(resultado);
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void menuGeneralProducto() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do{
			System.out.println("Introduzca la operación que desee realizar: ");
			
		    System.out.println("\n       MENÚ PRINCIPAL PARA LA GESTIÓN DE INVENTARIO");
		    System.out.println("===============================================");
		    System.out.println("1. Buscar producto por código, nombre, línea y descripción:");
		    System.out.println("2. Insertar producto");
		    System.out.println("3. Actualizar producto");
		    System.out.println("4. Volver al menú principal");
		    System.out.println("===============================================");
		    
		    n = Integer.parseInt(sc.nextLine());
            
            switch(n) {
            	case 1: menuBuscarbuscarProductoFiltraCodigoNombreLineaDescripcion();
            			break;
            	case 2: menuInsertarProducto();
            			break;
            	case 3: menuActualizarProducto();
            			break;
            	case 4: return;
            	default: System.out.print("Elección invalida, inténtalo otra vez...");
                		break;
            }
	    	
	    } while(n!=4);
	}
}
