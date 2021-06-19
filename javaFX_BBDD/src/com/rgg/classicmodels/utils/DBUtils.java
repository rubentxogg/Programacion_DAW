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
		
		// Con esta primera l�nea forzamos que cargue el driver de MySQL
		// En Java una clase no se carga a menos que sea necesario
		// Dado que el c�digo JDBC nunca referencia la driver este nunca se cargar�a
		Class.forName("com.mysql.cj.jdbc.Driver");
		String servidor = "jdbc:mysql://localhost:3306/classicmodels"; // url de conexi�n
		String username = "1234"; // Usuario
		String password = "1234"; // La contrase�a de la BBDD
		Connection conexionBD = DriverManager.getConnection(servidor, username, password);
		return conexionBD;
	}
}
