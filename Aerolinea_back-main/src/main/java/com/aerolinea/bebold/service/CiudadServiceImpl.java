package com.aerolinea.bebold.service;

import org.springframework.stereotype.Service;

import com.aerolinea.bebold.repository.CiudadRepositorio;

@Service
public class CiudadServiceImpl  implements CiudadService{

	private CiudadRepositorio ciudadRepositorio;
	
	public CiudadServiceImpl(CiudadRepositorio ciudadRepositorio) {
		super();
		this.ciudadRepositorio = ciudadRepositorio;
	}

	@Override
	public boolean isVisa(String nombre) {
		String resultado = ciudadRepositorio.isVisa(nombre);
		if(resultado.equals("1")) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
