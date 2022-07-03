package com.web.automotriz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.automotriz.dto.Cargo;
import com.web.automotriz.service.CargoService;

@RestController
@RequestMapping("/api/cargo/")
public class CargoController {

	@Autowired
	CargoService cargoService;
	
	@PostMapping("/guardarCargo")
	public ResponseEntity<?> registrarCargo(@RequestBody Cargo cargo){
		
		return new ResponseEntity(cargoService.insertCargo(cargo), HttpStatus.OK);
		
	}
	
}
