package mx.unach.Inmobiliariatap.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.unach.Inmobiliariatap.domain.Building;
import mx.unach.Inmobiliariatap.domain.repository.BuildingRepository;

@Service("buildingService")
@Transactional
public class BuildingService {
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	public List<Building> listAllBuildings() {
		 return buildingRepository.listAllBuildings();
	}
	
	public Optional<Building> findByIdBuilding(String id) {
		return buildingRepository.findByIdBuilding(id);
	}
	
	public Building updateBuilding(Building building) {
		return buildingRepository.updateBuilding(building);
	}
	
	 public boolean deleteBuilding(String id) {
		 return findByIdBuilding(id).map(building -> {
			 buildingRepository.deleteBuilding(id);
			 return true;
		 }).orElse(false);
	 }
	 
	 public Building addBuilding(Building building) {
		 return buildingRepository.addBuilding(building);
	 }
	
}
