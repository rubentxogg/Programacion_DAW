package com.rgg.classicmodels.vista;

import java.sql.SQLException;
import java.util.Scanner;

import com.rgg.classicmodels.utils.MiScanner;

public class MenuPrincipal {
	
	public void menuPrincipal() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do {
	    System.out.println("\n       MEN� PRINCIPAL PARA LA GESTI�N DE LA TIENDA CLASSIC MODELS");
	    System.out.println("===============================================");
	    System.out.println("1. Gesti�n de inventario");
	    System.out.println("2. Gesti�n de lineas productos");
	    System.out.println("3. Gesti�n de clientes");
	    System.out.println("4. Gesti�n de empleados ");
	    System.out.println("5. Gesti�n de oficinas");
	    System.out.println("6. Gesti�n de Pedidos");
	    System.out.println("7. Salir de la aplicaci�n");
	    System.out.println("===============================================");
	    
	  
	    n = Integer.parseInt(sc.nextLine());
            
	    switch(n) {
            case 1: ProductoVista vp = new ProductoVista();
            		vp.menuGeneralProducto();
            		break;
            case 2: LineaProductoVista vlp = new LineaProductoVista();
            		vlp.menuGeneralLineaProducto();
            		break;
        	case 3: ClienteVista vc = new ClienteVista();
        			vc.menuGeneralCliente();
        			break;
        	case 4: EmpleadoVista ve = new EmpleadoVista();
        			ve.menuGeneralEmpleado();
        			break;
        	case 5: OficinaVista vo = new OficinaVista();
        			vo.menuGeneralOficina();
        			break;
        	case 6: PedidoVista pv = new PedidoVista();
        			pv.menuGeneralPedido();
        			break;
        	case 7: return;
        	default: System.out.print("Elecci�n invalida, int�ntalo otra vez...");
            		break;
        }

	    } while(n!=7);
	}
}
