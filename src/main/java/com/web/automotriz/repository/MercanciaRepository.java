package com.web.automotriz.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.web.automotriz.dto.Mercancia;
import com.web.automotriz.dto.Usuario;

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
	
	public int deleteMercanciaRepository(Mercancia mercancia) {
		
		Map<String, Object> respuesta = new HashMap<>();
	
		String sql = " DELETE FROM INVENTARIOAUTOMOTRIZ.MERCANCIA "
				+ "WHERE IDMERCANCIA = ? AND USUARIOID = ? ";
		
		int rows = jdbcTemplate.update(sql, mercancia.getIdmercancia(), mercancia.getUsuarioid());
		
		return rows;		
				
	}
	
	public boolean selectNombreMercanciaRepository(Mercancia mercancia) {
		
		Map<String, Object> respuesta = new HashMap<>();
		
		String sql = "SELECT  "
				+ " NOMBRE_PRODUCTO, CANTIDAD, FECHA_INGRESO "
				+ " FROM INVENTARIOAUTOMOTRIZ.MERCANCIA  "
				+ "WHERE NOMBRE_PRODUCTO = ? ";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, mercancia.getNombre_producto());
		
		if(rows != null) {
			
			if(rows.isEmpty()) {
				return false;
			}else {
				return true;
			}
		
		}else {
			return true;
		}
		
	}
	
}
