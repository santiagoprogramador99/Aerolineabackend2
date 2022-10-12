package com.aerolinea.bebold.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aerolinea.bebold.entity.Pasajero;

public interface PasajeroRepository  extends JpaRepository<Pasajero, Integer>{
	

}
