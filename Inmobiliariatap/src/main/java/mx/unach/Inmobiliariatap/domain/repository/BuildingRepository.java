package mx.unach.Inmobiliariatap.domain.repository;

import java.util.List;
import java.util.Optional;

import mx.unach.Inmobiliariatap.domain.Building;

public interface BuildingRepository {
	
	public abstract List<Building> listAllInmuebles();
	
	public abstract Optional<Building> findByIdInmueble(String id);
	
	public abstract Building updateInmueble(Building inmueble);
		
	public abstract int deleteInmueble(String id);
	
	public abstract Building addInmueble(Building inmueble);

}
