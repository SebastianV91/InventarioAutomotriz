package com.web.automotriz.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {

	private static final long serialVersionUID = 3514047894891029401L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcargo;
	
	private String nombre;

	public Long getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(Long idcargo) {
		this.idcargo = idcargo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

		
}
