package com.aerolinea.bebold.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.bebold.entity.Reserva;
import com.aerolinea.bebold.service.ReservaService;

@RestController
@RequestMapping("/Api/Reserva")
@CrossOrigin({"*"})
public class ReservaController  {

	public ReservaService reservaService;
	
	public ReservaController(ReservaService reservaService) {
		super();
		this.reservaService = reservaService;
	}

	/**
	 * Metodo que lista las reservas que existen 
	 * @return retorna la todas las reservas
	 */
	@GetMapping("/Listar")
	public ResponseEntity<List<Reserva>> listarReservas(){
		List<Reserva> reservas = reservaService.listarReservas();
		if(reservas.isEmpty()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(reservas);
	}
	
	/**
	 * Metodo que lista algunos atributos de las reservas
	 * @return retorna una lista con los datos de cada reserva 
	 */
	@GetMapping("/ListarD")
	public ResponseEntity<List<List<String>>> listarReservasDatos(){
		List<List<String>> reservas = reservaService.listarRegistrosDatos();
		if(reservas.isEmpty()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(reservas);
	}
	
	/**
	 * Metodo que crea una reserva 
	 * @param reserva reserva que es retornada al ser creada
	 * @return
	 */
	@PostMapping("/Crear")
	public ResponseEntity<?> crearReserva(@RequestBody Reserva reserva)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.crearRegistro(reserva));
	}
	
}

