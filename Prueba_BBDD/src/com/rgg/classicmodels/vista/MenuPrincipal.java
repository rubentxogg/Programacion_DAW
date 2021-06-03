package com.rgg.classicmodels.vista;

import java.sql.SQLException;
import java.util.Scanner;

import com.rgg.classicmodels.utils.MiScanner;

public class MenuPrincipal {
	
	public void menuPrincipal() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do {
	    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TIENDA CLASSIC MODELS");
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
	   
	    	
            if (n>7||n<1){
                System.out.print("Elección invalida, inténtalo otra vez...");
                continue;
            }
            if ( n == 2) {
            	System.out.println("ahora ejecutaría la gestión de productos");
            	continue;
            }
            
            if ( n == 3) {
            	ClienteVista vc = new ClienteVista();
            	vc.menuGeneralCliente();
            	continue;
            }

	    } while(n!=7);
	}
}
