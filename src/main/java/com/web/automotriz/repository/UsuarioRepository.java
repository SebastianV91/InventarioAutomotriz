package com.web.automotriz.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.web.automotriz.dto.Usuario;

@Component
public class UsuarioRepository {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;

	public int insertUsuarioRepository(Usuario usuario) {
		
		Map<String, Object> respuesta = new HashMap<>();
		
		String sql = "INSERT INTO INVENTARIOAUTOMOTRIZ.USUARIO "
				+ " (NOMBRE, EDAD, FECHA_INGRESO, CARGOID)  "
				+ "VALUES (?, ?, ?, ?) ";
		
		int rows = jdbcTemplate.update(sql, usuario.getNombre(), usuario.getEdad(), usuario.getFecha_ingreso(), usuario.getCargoid());
		
		return rows;
		
	}
	
}
