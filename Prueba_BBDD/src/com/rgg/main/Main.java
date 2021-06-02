package com.rgg.main;

import java.sql.SQLException;

import com.rgg.classicmodels.model.ClienteModelo;
import com.rgg.classicmodels.vista.ClienteVista;
import com.rgg.dto.ClienteDTO;

public class Main {
	
	// Método main
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ClienteVista vc = new ClienteVista();
		vc.menuActualizarCliente();
	}
}
