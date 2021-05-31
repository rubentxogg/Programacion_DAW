package com.rgg.main;

import java.sql.SQLException;

import com.rgg.classicmodels.model.ClienteModelo;
import com.rgg.dto.ClienteDTO;

public class Main {
	
	// Método main
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		for(ClienteDTO cliente : new ClienteModelo().recuperaNombreTelefonoTodosClientes()) {
			System.out.println(cliente);
		}
	}
}
