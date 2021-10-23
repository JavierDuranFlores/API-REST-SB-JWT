package mx.unach.Inmobiliariatap.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unach.Inmobiliariatap.domain.Building;
import mx.unach.Inmobiliariatap.domain.service.BuildingService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class BuildingController {
	
	@Autowired
	@Qualifier("buildingService")
	private BuildingService buildingService;
	
	@GetMapping(path="/buildings", produces={"application/json"})
	public List<Building> getBuildings() { 
		return buildingService.listAllBuildings();
	}
	
	@GetMapping(path="/buildings/{id}", produces={"application/json"})
	public Optional<Building> getBuilding(@PathVariable String id) {
		return buildingService.findByIdBuilding(id);
	}

	@PutMapping(path="/buildings/{id}", produces={"application/json"})
	public Building updateInmueble(@RequestBody Building building, @PathVariable String id) {
		Optional<Building> update = buildingService.findByIdBuilding(id);
		
		update.get().setMunicipality(building.getMunicipality());
		update.get().setColony(building.getColony());
		update.get().setPostalCode(building.getPostalCode());
		update.get().setPrice(building.getPrice());
		update.get().setImage(building.getImage());
		
		return buildingService.updateBuilding(update.get());
	}

	@DeleteMapping(path="/buildings/{id}", produces={"application/json"})
	public int deteleBuilding(@PathVariable String id) {
		return buildingService.deleteBuilding(id);
	}

	@PostMapping(path="/buildings", produces={"application/json"})
	public Building createBuilding(@RequestBody Building building) {
		return buildingService.addBuilding(building);
	}
	
}
