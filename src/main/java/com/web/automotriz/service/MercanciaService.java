package com.web.automotriz.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.web.automotriz.dto.Mercancia;
import com.web.automotriz.repository.MercanciaRepository;

@Service
public class MercanciaService extends MercanciaRepository{
	
	public Map<String, Object> insertMercancia(Mercancia mercancia){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(insertMercanciaRepository(mercancia) == 1) {
			response.put("mensaje", "Mercancia registrada");
		}
		
		return response;
		
	}
	
	public Map<String, Object> updateMercancia(Mercancia mercancia){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(updateMercanciaRepository(mercancia) == 1) {
			response.put("message", "Mercancia actualizada");
		}else {
			response.put("message", "Mercancia no actualizada");
		}
		
		return response;
		
	}
	
	public Map<String, Object> deleteMercancia(Mercancia mercancia){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(deleteMercanciaRepository(mercancia) == 1) {
			response.put("message", "Mercancia eliminada");
		}else {
			response.put("message", "Esta mercancia no se puede eliminar porque no coincide con el usuario que la registro");
		}
		
		return response;
		
	}
	
}
