package com.rgg.classicmodels.controlador;

import java.sql.SQLException;
import java.util.List;

import com.rgg.classicmodels.model.ClienteModelo;
import com.rgg.dto.ClienteDTO;

public class ClientesControlador {

	public List<ClienteDTO> recuperaNombreTelefono(String nombre) throws ClassNotFoundException, SQLException{
		ClienteModelo cm = new ClienteModelo();
		return cm.recuperaNombreTelefonoFiltraporNombre(nombre);
	}
}
