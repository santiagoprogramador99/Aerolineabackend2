package com.aerolinea.bebold.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aerolinea.bebold.entity.Pasajero;
import com.aerolinea.bebold.entity.Tiquete;
import com.aerolinea.bebold.repository.PasajeroRepository;
import com.aerolinea.bebold.repository.TiqueteRepository;

@Service
public class TiqueteServiceImpl implements TiqueteService{

	private TiqueteRepository tiqueteRepository;
	private PasajeroRepository pasajeroRepository;
	
	public TiqueteServiceImpl(TiqueteRepository tiqueteRepository, PasajeroRepository pasajeroRepository) {
		super();
		this.tiqueteRepository = tiqueteRepository;
		this.pasajeroRepository = pasajeroRepository;
		
	}

	@Override
	public Tiquete crearTiquete(Tiquete tiquete) {
		tiquete.getPasajero().setCantidadViajes();
		if(tiquete.getReserva().getTipoVuelo().equals("RT")) {
			tiquete.getPasajero().setMillasViajadas(tiquete.getReserva().getVueloIda().getRuta().getMillas()
					+tiquete.getReserva().getVueloVuelta().getRuta().getMillas());
			tiquete.getPasajero().setCantidadViajes();
			tiquete.getReserva().getVueloIda().setSillasDisponibles();
			tiquete.getReserva().getVueloVuelta().setSillasDisponibles();
		}
		else {
			tiquete.getPasajero().setMillasViajadas(tiquete.getReserva().getVueloIda().getRuta().getMillas());
			tiquete.getPasajero().setCantidadViajes();
			tiquete.getReserva().getVueloIda().setSillasDisponibles();
		}
		
		
		return tiqueteRepository.save(tiquete);
	}

	@Override
	public int calcularDescuentos(int idPasajero, Date fechaInicio, Date fechaFin) {
		int cantidadTotalVuelos = 0;
		int porcentageDescuento = 0;
		List<Integer> cantidadVuelos = tiqueteRepository.contarVuelos(idPasajero, fechaInicio, fechaFin);
		Pasajero pasajero =  pasajeroRepository.findById(idPasajero).get();
		if(cantidadVuelos != null) {
			try {
				cantidadTotalVuelos=cantidadVuelos.get(0)+cantidadVuelos.get(0);
				if(cantidadTotalVuelos > 10) {
					porcentageDescuento = 10;
				}
				else {
					porcentageDescuento = 5;
				}
				
			} catch (Exception e) {
				System.out.println(" Error de casteo de numero");
			}	
		}
		else { 
			porcentageDescuento = 5;
		}
		if(pasajero.getEdad() > 65) {
			porcentageDescuento +=3;
		}
		if(pasajero.getTipoViajero().equals("Infantes")) {
			porcentageDescuento+=90;
		}
		
		return porcentageDescuento;
	}

}
