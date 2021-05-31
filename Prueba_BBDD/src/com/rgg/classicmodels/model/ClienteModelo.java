package com.rgg.classicmodels.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rgg.classicmodels.utils.DBUtils;
import com.rgg.dto.ClienteDTO;

public class ClienteModelo {
	
	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ClienteDTO> recuperaNombreTelefonoTodosClientes() throws ClassNotFoundException, SQLException{
		Connection conexionBD = DBUtils.conexionBBDD();
		
		Statement statement = conexionBD.createStatement();
		ResultSet clientesRS = statement.executeQuery("SELECT * FROM customers");
		
		List<ClienteDTO> listaClientes = new ArrayList<>();
		
		while(clientesRS.next()) {
			ClienteDTO cliente = new ClienteDTO(clientesRS.getString("customerName"), clientesRS.getString("phone"));
			listaClientes.add(cliente);
		}
		conexionBD.close();
		
		return listaClientes;
	}
}
