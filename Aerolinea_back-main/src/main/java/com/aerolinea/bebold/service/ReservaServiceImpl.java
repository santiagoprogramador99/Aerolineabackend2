package com.aerolinea.bebold.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aerolinea.bebold.entity.Reserva;
import com.aerolinea.bebold.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService{

	private ReservaRepository reservaRepository;
	
	

	public ReservaServiceImpl(ReservaRepository reservaRepository) {
		super();
		this.reservaRepository = reservaRepository;
	}

	@Override
	public List<Reserva> listarReservas() {
		//Deberia de sacar solo los datos que piden???
//		List<Reserva> reservas = reservaRepository.findAll();
//		for (int i = 0; i < reservas.size(); i++) {
//			String infoReserva = reservas.get(i).ge;
//			
//		}
		
		return reservaRepository.findAll();
	}
	

	@Override
	public Reserva crearRegistro(Reserva reserva) {
		return reservaRepository.save(reserva);
	}

	@Override
	public List<List<String>> listarRegistrosDatos() {
		return reservaRepository.listarReservas();
	}

	
}
