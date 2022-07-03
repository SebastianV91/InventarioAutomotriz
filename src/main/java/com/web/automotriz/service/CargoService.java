package com.web.automotriz.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.automotriz.dto.Cargo;
import com.web.automotriz.repository.CargoRepository;

@Service
public class CargoService extends CargoRepository{

	public Map<String, Object> insertCargo(Cargo cargo){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(insertCargoRepository(cargo) == 1) {
			response.put("mensaje", "Cargo registrado exitosamente");
		}
		
		return response;
		
	}

}
