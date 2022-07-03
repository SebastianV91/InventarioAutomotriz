package com.web.automotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.automotriz.dto.Usuario;
import com.web.automotriz.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario/")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/guardarUsuario")
	public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario){
		
		return new ResponseEntity(usuarioService.insertUsuario(usuario), HttpStatus.OK);
		
	}
	
}
