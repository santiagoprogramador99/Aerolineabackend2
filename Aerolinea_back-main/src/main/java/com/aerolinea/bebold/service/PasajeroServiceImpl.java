package com.aerolinea.bebold.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aerolinea.bebold.entity.Pasajero;
import com.aerolinea.bebold.repository.PasajeroRepository;

@Service
public class PasajeroServiceImpl implements PasajeroService{
	
	private PasajeroRepository pasajeroRepository;
	

	public PasajeroServiceImpl(PasajeroRepository pasajeroRepository) {
		super();
		this.pasajeroRepository = pasajeroRepository;
	}

	@Override
	public Pasajero crearPasajero(Pasajero pasajero) {
		return pasajeroRepository.save(pasajero);
	}

	@Override
	public Pasajero buscarPasajero(Integer idpasajero) {
		return pasajeroRepository.findById(idpasajero).get();
	}

	@Override
	public String verificarPasajeroFrecuente(int idPasajero, double millas) {
		Optional<Pasajero> pasajero = pasajeroRepository.findById(idPasajero);
		Pasajero pasajeroEncontrado= pasajero.get();
		String mensaje="";
		double millasViajadas = 0;
		if(pasajeroEncontrado != null){
			if(pasajeroEncontrado.isFrecuente() == true) {
				millasViajadas = pasajeroEncontrado.getMillasViajadas();
				mensaje="Usted a viajado "+ millasViajadas + 
						" Millas y con este vuelo llegaria a un total de  "+millasViajadas+millas + " millas";
				return mensaje;
			}
			else {
				return "";
			}
		}
		return "";
	}

	
}
