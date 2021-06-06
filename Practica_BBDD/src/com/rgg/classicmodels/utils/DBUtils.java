package com.rgg.classicmodels.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection conexionBBDD() throws ClassNotFoundException, SQLException {
		
		// Con esta primera línea forzamos que cargue el driver de MySQL
		// En Java una clase no se carga a menos que sea necesario
		// Dado que el código JDBC nunca referencia la driver este nunca se cargaría
		Class.forName("com.mysql.cj.jdbc.Driver");
		String servidor = "jdbc:mysql://localhost:3306/classicmodels"; // url de conexión
		String username = "root"; // Usuario
		String password = "PracticaRoot"; // La contraseña de la BBDD
		Connection conexionBD = DriverManager.getConnection(servidor, username, password);
		return conexionBD;
	}
}
