package com.aerolinea.bebold.service;

import java.util.Date;

import com.aerolinea.bebold.entity.Tiquete;

public interface TiqueteService {

	public Tiquete crearTiquete(Tiquete tiquete);
	public int calcularDescuentos(int idPasajero, Date fechaInicio, Date fechaFin);
}
