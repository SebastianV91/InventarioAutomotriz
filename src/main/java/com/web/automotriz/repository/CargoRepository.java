package com.web.automotriz.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.web.automotriz.dto.Cargo;

@Component
public class CargoRepository {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;

	public int insertCargoRepository(Cargo cargo) {
		
		Map<String, Object> respuesta = new HashMap<>();
		
		String sql = "INSERT INTO INVENTARIOAUTOMOTRIZ.CARGO "
				+ " (NOMBRE)  "
				+ "VALUES (?) ";
		
		int rows = jdbcTemplate.update(sql, cargo.getNombre());
		
		return rows;
		
	}
	
}
