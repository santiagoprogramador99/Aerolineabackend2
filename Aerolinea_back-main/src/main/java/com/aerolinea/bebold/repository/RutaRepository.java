package com.aerolinea.bebold.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aerolinea.bebold.entity.Ruta;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer>{

	
	@Query(value = "select co.nombre from ciudad as co inner join ruta as r on r.ciudadOrigen=co.idCiudad ",nativeQuery=true)
    List<String> listarOrigenes();

	@Query(value = "select cd.nombre from ciudad as co inner join ruta as r on r.ciudadOrigen=co.idCiudad inner join ciudad as cd on cd.idCiudad=r.ciudadDestino  where co.nombre=:origen",nativeQuery=true)
    List<String> listarDestinos(String origen);
}
