package com.aerolinea.bebold.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aerolinea.bebold.entity.Tiquete;

public interface TiqueteRepository extends JpaRepository<Tiquete, Integer> {

	
	@Query(value = "select count(r.vueloIda), count(r.vueloVuelta) from Tiquete as t inner join Reserva as r on t.reserva=r.idReserva inner join Vuelo as v on r.vueloIda = v.idVuelo where t.pasajero=:idPasajero and v.fecha>=DATE_FORMAT(:fechaInicio,\"%Y-%m-%d\") and v.fecha<=DATE_FORMAT(:fechaFin,\"%Y-%m-%d\")",nativeQuery=true)
    List<Integer> contarVuelos(int idPasajero, Date fechaInicio, Date fechaFin);
}
