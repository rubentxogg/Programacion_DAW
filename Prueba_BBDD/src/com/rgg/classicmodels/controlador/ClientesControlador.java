package com.rgg.classicmodels.controlador;

import java.sql.SQLException;
import java.util.List;

import com.rgg.classicmodels.model.ClienteModelo;
import com.rgg.dto.ClienteDTO;

public class ClientesControlador {

	/**
	 * @param nombre
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ClienteDTO> recuperaNombreTelefono(String nombre) throws ClassNotFoundException, SQLException{
		ClienteModelo cm = new ClienteModelo();
		return cm.recuperaNombreTelefonoFiltraporNombre(nombre);
	}
	
	/**
	 * @param nombre
	 * @param tfno
	 * @param pais
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ClienteDTO> recuperaNombreTelefonoFiltraporNombreTfnoPais(String nombre, String tfno, String pais) throws ClassNotFoundException, SQLException{
		ClienteModelo cm = new ClienteModelo();
		return cm.recuperaNombreTelefonoFiltraporNombreTfnoPais(nombre, tfno, pais);
	}
}
