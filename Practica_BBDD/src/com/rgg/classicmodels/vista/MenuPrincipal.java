package com.rgg.classicmodels.vista;

import java.sql.SQLException;
import java.util.Scanner;

import com.rgg.classicmodels.utils.MiScanner;

public class MenuPrincipal {
	
	public void menuPrincipal() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do {
	    System.out.println("\n       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TIENDA CLASSIC MODELS");
	    System.out.println("===============================================");
	    System.out.println("1. Gestión de inventario");
	    System.out.println("2. Gestión de lineas productos");
	    System.out.println("3. Gestión de clientes");
	    System.out.println("4. Gestión de empleados ");
	    System.out.println("5. Gestión de oficinas");
	    System.out.println("6. Gestión de Pedidos");
	    System.out.println("7. Salir de la aplicación");
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
        	default: System.out.print("Elección invalida, inténtalo otra vez...");
            		break;
        }

	    } while(n!=7);
	}
}
