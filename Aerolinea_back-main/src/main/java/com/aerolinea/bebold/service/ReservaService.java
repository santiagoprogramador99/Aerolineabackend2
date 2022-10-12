package com.aerolinea.bebold.service;

import java.util.List;

import com.aerolinea.bebold.entity.Reserva;

public interface ReservaService {
	
	public List<Reserva> listarReservas();
	public Reserva crearRegistro(Reserva reserva);
	public List<List<String>> listarRegistrosDatos();

}
