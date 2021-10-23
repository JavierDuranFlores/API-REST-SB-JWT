package mx.unach.Inmobiliariatap.domain.repository;

import java.util.List;
import java.util.Optional;

import mx.unach.Inmobiliariatap.domain.Building;

public interface BuildingRepository {
	
	public abstract List<Building> listAllBuildings();
	
	public abstract Optional<Building> findByIdBuilding(String id);
	
	public abstract Building updateBuilding(Building building);
		
	public abstract int deleteBuilding(String id);
	
	public abstract Building addBuilding(Building building);

}
