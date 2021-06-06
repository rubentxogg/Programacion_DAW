package com.rgg.classicmodels.vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rgg.classicmodels.controlador.PedidoControlador;
import com.rgg.classicmodels.utils.MiScanner;
import com.rgg.dto.CantidadPedidaProducto;
import com.rgg.dto.PedidoDTO;

/**
 * @author Rubentxo
 *
 */
public class PedidoVista {

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuCrearPedido() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		List<CantidadPedidaProducto> lista = new ArrayList<>();
		
		System.out.println("Introduzca la fecha de realización del pedido:");
		String fechaRealizacion = sc.nextLine();
		System.out.println("Introduzca la fecha de entrega requerida del pedido:");
		String fechaRequerida = sc.nextLine();
		System.out.println("Introduzca el estado del pedido:");
		String estado = sc.nextLine();
		System.out.println("Introduzca un comentario para el pedido:");
		String comentario = sc.nextLine();
		System.out.println("Introduzca el número del cliente que ha realizado el pedido:");
		int numeroCliente;
		
		try {
			numeroCliente = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("No se ha introducido el número del cliente");
			return;
		}
		
		PedidoControlador controladorPedido = new PedidoControlador();
		
		String resultado = (controladorPedido.crearPedido(fechaRealizacion,
				fechaRequerida,
				estado, 
				comentario,
				numeroCliente,
				lista).equals(1)?"Pedido creado con éxito":"No se ha podido crear el pedido");
		System.out.println(resultado);
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void menuBuscarPedidoPorNumeroPedido() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el número del pedido a buscar:");
		int numeroPedido = 0;
		try {
			numeroPedido = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("No se ha introducido el número de pedido");
			return;
		}
		
		PedidoControlador controladorPedido = new PedidoControlador();
		List<PedidoDTO> listaPedidos = controladorPedido.buscarPedidoPorNumeroPedido(numeroPedido);
		
		for(PedidoDTO pedido : listaPedidos) {
			System.out.println("[nºPedido "+pedido.getNumeroPedido()+"] [Fecha pedido "+pedido.getFechaPedido()+"] [Fecha requerida "+pedido.getFechaRequerida()+"] [Fecha envío "+pedido.getFechaEnvio()+"] [Código producto "+pedido.getCodigoProducto()+"] [Cantidad pedida "+ pedido.getCantidadPedida()+"]");
		}
	}
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void menuGeneralPedido() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do{
			System.out.println("Introduzca la operación que desee realizar: ");
			
		    System.out.println("\n       MENÚ PRINCIPAL PARA LA GESTIÓN DE PEDIDOS");
		    System.out.println("===============================================");
		    System.out.println("1. Buscar pedido");
		    System.out.println("2. Crear pedido");
		    System.out.println("3. Volver al menú principal");
		    System.out.println("===============================================");
		    
		    n = Integer.parseInt(sc.nextLine());
            
            switch(n) {
            	case 1: menuBuscarPedidoPorNumeroPedido();
            			break;
            	case 2: menuCrearPedido();
            			break;
            	case 3: return;
            	default: System.out.print("Elección invalida, inténtalo otra vez...");
                		break;
            }
	    	
	    } while(n!=4);
	}
}
