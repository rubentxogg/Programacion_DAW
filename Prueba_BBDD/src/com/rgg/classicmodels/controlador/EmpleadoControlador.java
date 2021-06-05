package com.rgg.classicmodels.controlador;

import java.sql.SQLException;
import java.util.List;

import com.rgg.classicmodels.model.EmpleadoModelo;
import com.rgg.dto.EmpleadoDTO;

/**
 * @author Rubentxo
 *
 */
public class EmpleadoControlador {
	
	/**
	 * @param numEmpleado
	 * @param apellido
	 * @param nombre
	 * @param extension
	 * @param puesto
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<EmpleadoDTO> buscarEmpleadoNumeroApellidoNombreExtensionPuesto(int numEmpleado, String apellido, String nombre, String extension, String puesto) throws ClassNotFoundException, SQLException{
		EmpleadoModelo em = new EmpleadoModelo();
		return em.buscarEmpleadoNumeroApellidoNombreExtensionPuesto(numEmpleado, apellido, nombre, extension, puesto);
	}
	
	/**
	 * @param numEmpleado
	 * @param apellido
	 * @param nombre
	 * @param extension
	 * @param email
	 * @param codigoOficina
	 * @param numReporte
	 * @param puesto
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer insertarEmpleado(int numEmpleado, String apellido, String nombre, String extension, String email, String codigoOficina, int numReporte, String puesto) throws ClassNotFoundException, SQLException {
		EmpleadoModelo em = new EmpleadoModelo();
		return em.insertarEmpleado(numEmpleado, apellido, nombre, extension, email, codigoOficina, numReporte, puesto);
	}
	
	/**
	 * @param numEmpleado
	 * @param apellido
	 * @param nombre
	 * @param extension
	 * @param email
	 * @param codigoOficina
	 * @param numReporte
	 * @param puesto
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer actualizarEmpleado(int numEmpleado, String apellido, String nombre, String extension, String email, String codigoOficina, int numReporte, String puesto) throws ClassNotFoundException, SQLException {
		EmpleadoModelo em = new EmpleadoModelo();
		return em.actualizarEmpleado(numEmpleado, apellido, nombre, extension, email, codigoOficina, numReporte, puesto);
	}
}
