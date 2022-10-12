package com.aerolinea.bebold.service;

import java.util.Date;
import java.util.List;

import com.aerolinea.bebold.entity.Vuelo;

public interface VueloService {

	public List<Object[]> buscarVuelos(String origen,String destino,Date fecha,int cantidad);
	public Vuelo buscarVuelo(int idvuelo);

}
