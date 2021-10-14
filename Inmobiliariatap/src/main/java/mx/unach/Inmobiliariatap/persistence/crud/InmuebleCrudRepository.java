package mx.unach.Inmobiliariatap.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import mx.unach.Inmobiliariatap.persistence.entity.Inmueble;

public interface InmuebleCrudRepository extends CrudRepository<Inmueble, String>{

	int deleteByIdcliente(String id);
	
}
