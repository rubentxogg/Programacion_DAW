package com.rgg.classicmodels.controlador;

import java.sql.SQLException;
import java.util.List;

import com.rgg.classicmodels.model.OficinaModelo;
import com.rgg.dto.OficinaDTO;

/**
 * @author Rubentxo
 *
 */
public class OficinaControlador {

	/**
	 * @param codigoOficina
	 * @param ciudad
	 * @param estado
	 * @param pais
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<OficinaDTO> buscarOficinaFiltraCodigoCiudadEstadoPais(String codigoOficina, String ciudad, String estado, String pais) throws ClassNotFoundException, SQLException{
		OficinaModelo om = new OficinaModelo();
		return om.buscarOficinaFiltraCodigoCiudadEstadoPais(codigoOficina, ciudad, estado, pais);
	}
	
	/**
	 * @param codigoOficina
	 * @param ciudad
	 * @param telefono
	 * @param direccion1
	 * @param direccion2
	 * @param estado
	 * @param pais
	 * @param codigoPostal
	 * @param territorio
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer insertarOficina(String codigoOficina, String ciudad, String telefono, String direccion1, String direccion2, String estado, String pais, String codigoPostal, String territorio) throws ClassNotFoundException, SQLException {
		OficinaModelo om = new OficinaModelo();
		return om.insertarOficina(codigoOficina, ciudad, telefono, direccion1, direccion2, estado, pais, codigoPostal, territorio);
	}
	
	/**
	 * @param codigoOficina
	 * @param ciudad
	 * @param telefono
	 * @param direccion1
	 * @param direccion2
	 * @param estado
	 * @param pais
	 * @param codigoPostal
	 * @param territorio
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer actualizarOficina(String codigoOficina, String ciudad, String telefono, String direccion1, String direccion2, String estado, String pais, String codigoPostal, String territorio) throws ClassNotFoundException, SQLException {
		OficinaModelo om = new OficinaModelo();
		return om.actualizarOficina(codigoOficina, ciudad, telefono, direccion1, direccion2, estado, pais, codigoPostal, territorio);
	}
}
