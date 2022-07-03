package com.web.automotriz.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.automotriz.dto.Usuario;
import com.web.automotriz.repository.UsuarioRepository;

@Service
public class UsuarioService extends UsuarioRepository{

	public Map<String, Object> insertUsuario(Usuario usuario){
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		if(insertUsuarioRepository(usuario) == 1) {
			response.put("mensaje", "Usuario registrado exitosamente");
		}
		
		return response;
		
	}

}
