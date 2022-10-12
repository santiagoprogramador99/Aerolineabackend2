package com.aerolinea.bebold.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.bebold.entity.Tiquete;
import com.aerolinea.bebold.service.TiqueteService;

@RestController
@RequestMapping("/Api/Tiquete")
@CrossOrigin({"*"})
public class TiqueteController {
	
	public TiqueteService tiqueteService;

	public TiqueteController(TiqueteService tiqueteService) {
		super();
		this.tiqueteService = tiqueteService;
	}

	/**
	 * Metodo que crea un tiquete 
	 * @param tiquete tiquete que se va a crear 
	 * @return retorna el tiquete creado
	 */
	@PostMapping("/Crear")
	public ResponseEntity<?> create(@RequestBody Tiquete tiquete)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(tiqueteService.crearTiquete(tiquete));
	}
	
	/**
	 * Metodo que calcula el porcentaje de descuentos a ser aplicados a un pasajero segun las reglas de negocio
	 * @param fechaInicio fecha de inicio del año 
	 * @param fechaFin fecha fin del año 
	 * @param idPasajero identificador del pasajero 
	 * @return retorna el valor en porcentaje del descuento que se le aplicara al pasajero
	 */
	@GetMapping("/Descuentos")
	public ResponseEntity<?> calcularDescuentos(
			@RequestParam(value="fechaInicio") @DateTimeFormat( pattern ="yyyy-MM-dd" ) Date fechaInicio,
			@RequestParam(value="fechaFin") @DateTimeFormat( pattern ="yyyy-MM-dd" ) Date fechaFin,
			@RequestParam(value="idPasajero", required = false) int idPasajero){
		System.out.println(fechaInicio +" fff "+ fechaFin + " eee "+idPasajero + "\n");
		int totalVuelos = tiqueteService.calcularDescuentos(idPasajero, fechaInicio, fechaFin);
		return ResponseEntity.ok(totalVuelos);
	}
}
