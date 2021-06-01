package com.rgg.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				Statement statement = conexionBD.createStatement();){
			ResultSet clientesRS = statement.executeQuery("SELECT * FROM customers");
			
			List<ClienteDTO> listaClientes = new ArrayList<>();
			
			while(clientesRS.next()) {
				ClienteDTO cliente = new ClienteDTO(clientesRS.getString("customerName"), clientesRS.getString("phone"));
				listaClientes.add(cliente);
			}
			return listaClientes;
		}
	}
	
	/**
	 * @param nombre
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ClienteDTO> recuperaNombreTelefonoFiltraporNombre(String nombre) throws ClassNotFoundException, SQLException{
		String query = "SELECT * FROM customers where customerName LIKE ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, "%"+nombre+"%");
			ResultSet clientesRS = ps.executeQuery();
			List<ClienteDTO> listaClientes = new ArrayList<>();
			
			while(clientesRS.next()) {
				ClienteDTO cliente = new ClienteDTO(clientesRS.getString("customerName"), clientesRS.getString("phone"));
				listaClientes.add(cliente);
			}
			return listaClientes;
		}
	}
}
