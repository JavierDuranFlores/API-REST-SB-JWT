package mx.unach.Inmobiliariatap.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.unach.Inmobiliariatap.persistence.entity.Inmueble;

@Repository("inmuebleCrudRepository")
public interface InmuebleCrudRepository extends CrudRepository<Inmueble, String>{

	int deleteByIdCliente(String id);
	
}
