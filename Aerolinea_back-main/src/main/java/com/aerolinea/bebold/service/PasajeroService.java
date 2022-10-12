package com.aerolinea.bebold.service;


import com.aerolinea.bebold.entity.Pasajero;

public interface PasajeroService {
	
	public Pasajero crearPasajero(Pasajero pasajero);
	public Pasajero buscarPasajero(Integer idpasajero);
	public String verificarPasajeroFrecuente(int idPasajero, double millas);

}
