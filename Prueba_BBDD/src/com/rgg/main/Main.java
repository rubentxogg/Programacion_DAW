package com.rgg.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgg.classicmodels.model.PedidosModelo;
import com.rgg.classicmodels.vista.ClienteVista;
import com.rgg.classicmodels.vista.MenuPrincipal;
import com.rgg.dto.CantidadPedidaProducto;


public class Main {
	
	// Método main
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		PedidosModelo pm = new PedidosModelo();
//		List<CantidadPedidaProducto> lista = new ArrayList<>();
//		lista.add(new CantidadPedidaProducto("S10_1678", 3));
//		lista.add(new CantidadPedidaProducto("S10_1949", 1));
//		
//		pm.crearPedido("2021-05-1", "2021-05-06", "En proceso", "", 103, lista);
		
		MenuPrincipal mp = new MenuPrincipal();
		mp.menuPrincipal();
	}
}
