package mx.unach.Inmobiliariatap.persistence;

import java.util.List;
import java.util.Optional;

import mx.unach.Inmobiliariatap.persistence.crud.InmuebleCrudRepository;
import mx.unach.Inmobiliariatap.persistence.entity.Inmueble;

public class InmuebleRepository {
	
	private InmuebleCrudRepository inmuebleCrudRepository;
	
    public List<Inmueble> listAllInmuebles() {
        return (List<Inmueble>) inmuebleCrudRepository.findAll();
    }
    
    public Optional<Inmueble> findByIdInmueble(String id) {
        return inmuebleCrudRepository.findById(id);
    }

    public Inmueble updateInmueble(Inmueble inmueble) {
        return inmuebleCrudRepository.save(inmueble);
    }

    public int deleteInmueble(String id) {
        return inmuebleCrudRepository.deleteByIdcliente(id);
    }

    public Inmueble addInmueble(Inmueble inmueble) {
        Inmueble nuevo = Inmueble.builder()
        					     .idcliente(inmueble.getIdcliente())
        					     .municipio(inmueble.getMunicipio())
        					     .colonia(inmueble.getColonia())
        					     .codigopostal(inmueble.getCodigopostal())
        					     .precio(inmueble.getPrecio())
        					     .imagen(inmueble.getImagen())
        					     .build();

        		
        return inmuebleCrudRepository.save(nuevo);
    }

}
