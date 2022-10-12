package com.aerolinea.bebold.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aerolinea.bebold.entity.Vuelo;
import com.aerolinea.bebold.repository.VueloRepository;

@Service
public class VueloServiceImpl implements VueloService{

	private VueloRepository vueloRepository;
	
	public VueloServiceImpl(VueloRepository vueloRepository) {
		super();
		this.vueloRepository = vueloRepository;
	}

	@Override
	public List<Object[]> buscarVuelos(String origen, String destino, Date fecha, int cantidad) {
		return vueloRepository.listarVuelos(origen, destino, fecha, cantidad);
	}

	@Override
	public Vuelo buscarVuelo(int idvuelo){
		return vueloRepository.findById(idvuelo).get();
	}


}
