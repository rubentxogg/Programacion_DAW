package com.rgg.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgg.classicmodels.model.PedidosModelo;
import com.rgg.classicmodels.model.ProductoModelo;
import com.rgg.classicmodels.vista.ClienteVista;
import com.rgg.classicmodels.vista.MenuPrincipal;
import com.rgg.dto.CantidadPedidaProducto;


public class Main {
	
	// Método main
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MenuPrincipal mp = new MenuPrincipal();
		mp.menuPrincipal();
	}
}
