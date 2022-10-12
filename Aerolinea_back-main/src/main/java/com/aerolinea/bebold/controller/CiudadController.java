package com.aerolinea.bebold.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.bebold.service.CiudadService;

@RestController
@RequestMapping("/Api/Ciudad")
@CrossOrigin({"*"})
public class CiudadController {

	private CiudadService ciudadService;

	public CiudadController(CiudadService ciudadService) {
		super();
		this.ciudadService = ciudadService;
	}
	
	/**
	 * Metodo que busca si una ciudad requiere visa o no 
	 * @param nombre nombre de la ciudad 
	 * @return retorna true si necesita visa en caso contrario false 
	 */
	@GetMapping("/Visa/{nombre}")
	public ResponseEntity<Boolean> isVisa(@PathVariable(value ="nombre") String nombre){
		boolean isVisa= ciudadService.isVisa(nombre);
		return ResponseEntity.ok(isVisa);
	}
}
