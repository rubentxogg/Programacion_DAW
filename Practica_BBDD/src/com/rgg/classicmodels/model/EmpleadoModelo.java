package com.rgg.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgg.classicmodels.utils.DBUtils;
import com.rgg.dto.EmpleadoDTO;

/**
 * @author Rubentxo
 *
 */
public class EmpleadoModelo {
	
	/**
	 * @param numEmpleado
	 * @param apellido
	 * @param nombre
	 * @param extension
	 * @param puesto
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<EmpleadoDTO> buscarEmpleadoNumeroApellidoNombreExtensionPuesto(int numEmpleado, String apellido, String nombre, String extension, String puesto) throws SQLException, ClassNotFoundException{
		String query = "SELECT * FROM  employees WHERE employeeNumber LIKE ? AND lastName LIKE ? AND firstName LIKE ? AND extension LIKE ? AND jobTitle LIKE ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, "%"+numEmpleado+"%");
			ps.setString(2, "%"+apellido+"%");
			ps.setString(3, "%"+nombre+"%");
			ps.setString(4, "%"+extension+"%");
			ps.setString(5, "%"+puesto+"%");
			
			ResultSet empleadosRS = ps.executeQuery();
			List<EmpleadoDTO> listaEmpleados = new ArrayList<>();
			
			while(empleadosRS.next()) {
				EmpleadoDTO empleado = new EmpleadoDTO(empleadosRS.getInt("employeeNumber"), empleadosRS.getString("lastName"), empleadosRS.getString("firstName"), empleadosRS.getString("extension"), empleadosRS.getString("jobTitle"));
				listaEmpleados.add(empleado);
			}
			return listaEmpleados;
		}
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
	public Integer insertarEmpleado(int numEmpleado, String apellido, String nombre, String extension, String email, String codigoOficina, int numReporte, String puesto ) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO employees (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setInt(1, numEmpleado);
			ps.setString(2, apellido);
			ps.setString(3, nombre);
			ps.setString(4, extension);
			ps.setString(5, email);
			ps.setString(6, codigoOficina);
			ps.setInt(7, numReporte);
			ps.setString(8, puesto);
			
			return ps.executeUpdate();
		}
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
		String query = "UPDATE employees SET lastName = CASE WHEN ? = '' THEN lastName ELSE ? END,"
				+ "firstName = CASE WHEN ? = '' THEN firstName ELSE ? END,"
				+ "extension = CASE WHEN ? = '' THEN extension ELSE ? END,"
				+ "email = CASE WHEN ? = '' THEN email ELSE ? END,"
				+ "officeCode = CASE WHEN ? = '' THEN officeCode ELSE ? END,"
				+ "reportsTo = CASE WHEN ? = '' THEN reportsTo ELSE ? END,"
				+ "jobTitle = CASE WHEN ? = '' THEN jobTitle ELSE ? END "
				+ "WHERE employeeNumber = ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, apellido);
			ps.setString(2, apellido);
			
			ps.setString(3, nombre);
			ps.setString(4, nombre);
			
			ps.setString(5, extension);
			ps.setString(6, extension);
		
			ps.setString(7, email);
			ps.setString(8, email);
			
			ps.setString(9, codigoOficina);
			ps.setString(10, codigoOficina);
			
			ps.setInt(11, numReporte);
			ps.setInt(12, numReporte);
			
			ps.setString(13, puesto);
			ps.setString(14, puesto);
			
			ps.setInt(15, numEmpleado);
			
			return ps.executeUpdate();
		}
	}
}
