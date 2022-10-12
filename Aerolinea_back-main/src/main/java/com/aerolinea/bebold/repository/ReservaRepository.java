package com.aerolinea.bebold.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aerolinea.bebold.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	
	@Query(value =
			  "select  p.idPasajero,  p.nombre as nombrePasajero, p.apellido, co.nombre as nombreCiudadOrigen, v.fecha as fechaVueloIda, "
			+ "v.isEscala as escalaIda, cd.nombre as nombreCiudadDestino, vv.fecha as fechaVueloVuelta, vv.isEscala as escalaVuelta"
			+ " from reserva as r inner join vuelo as v on r.vueloida=v.idVuelo "
			+ " inner join vuelo as vv on vv.idVuelo = r.vueloVuelta "
			+ " inner join ruta as rut on rut.idRuta=v.ruta "
			+ " inner join ciudad as co on co.idCiudad=rut.ciudadOrigen"
			+ " inner join ciudad as cd on cd.idCiudad=rut.ciudadDestino "
			+ " inner join tiquete as t on r.idReserva=t.reserva "
			+ " inner join pasajero as p on p.idpasajero=t.pasajero",nativeQuery=true)
    List<List<String>> listarReservas();

}
