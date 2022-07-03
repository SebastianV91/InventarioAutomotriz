package com.web.automotriz.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.web.automotriz.dto.Mercancia;

@Component
public class MercanciaRepository {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;

	public int insertMercanciaRepository(Mercancia mercancia) {
		
		Map<String, Object> respuesta = new HashMap<>();
		
		String sql = "INSERT INTO INVENTARIOAUTOMOTRIZ.MERCANCIA "
				+ " (NOMBRE_PRODUCTO, CANTIDAD, FECHA_INGRESO, USUARIOID) "
				+ "VALUES (?, ?, ?, ?) ";
		
		int rows = jdbcTemplate.update(sql, mercancia.getNombre_producto(), mercancia.getCantidad(), mercancia.getFecha_ingreso(), mercancia.getUsuarioid());

		return rows;
		
	}
	
	public int updateMercanciaRepository(Mercancia mercancia) {
		
		Map<String, Object> respuesta = new HashMap<>();
	
		String sql = " UPDATE INVENTARIOAUTOMOTRIZ.MERCANCIA "
				+ " SET NOMBRE_PRODUCTO=?, CANTIDAD=?, USUARIOIDMODIFICACION=?, FECHA_MODIFICACION=CURRENT_DATE   "
				+ "WHERE IDMERCANCIA = ? ";
		
		int rows = jdbcTemplate.update(sql, mercancia.getNombre_producto(), mercancia.getCantidad(),  mercancia.getUsuarioidmodificacion(), mercancia.getIdmercancia());
		
		return rows;		
				
	}																							
	
}
