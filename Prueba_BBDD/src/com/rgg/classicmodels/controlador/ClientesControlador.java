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
	
	/**
	 * @param numerocliente
	 * @param nombreCliente
	 * @param apellidoContacto
	 * @param nombreContacto
	 * @param telefono
	 * @param direccion1
	 * @param direccion2
	 * @param ciudad
	 * @param estado
	 * @param codigoPostal
	 * @param pais
	 * @param representante
	 * @param credito
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer insertarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) throws ClassNotFoundException, SQLException {
		ClienteModelo cm = new ClienteModelo();
		return cm.insertarCliente(numerocliente, nombreCliente, apellidoContacto, nombreContacto, telefono, direccion1, direccion2, ciudad, estado, codigoPostal, pais, representante, credito);
	}
	
	/**
	 * @param numerocliente
	 * @param nombreCliente
	 * @param apellidoContacto
	 * @param nombreContacto
	 * @param telefono
	 * @param direccion1
	 * @param direccion2
	 * @param ciudad
	 * @param estado
	 * @param codigoPostal
	 * @param pais
	 * @param representante
	 * @param credito
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer actualizarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) throws ClassNotFoundException, SQLException {
		ClienteModelo cm = new ClienteModelo();
		return cm.actualizarCliente(numerocliente, nombreCliente, apellidoContacto, nombreContacto, telefono, direccion1, direccion2, ciudad, estado, codigoPostal, pais, representante, credito);
	}
	
	/**
	 * @param customerNumber
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer borrarCliente(int customerNumber) throws ClassNotFoundException, SQLException {
		ClienteModelo cm = new ClienteModelo();
		return cm.borrarCliente(customerNumber);
	}
}
