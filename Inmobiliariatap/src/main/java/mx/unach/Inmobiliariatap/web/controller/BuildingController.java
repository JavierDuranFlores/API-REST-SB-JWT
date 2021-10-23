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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
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
	@ApiOperation("Get all buildings")
	@ApiResponse(code = 200, message = "OK")
	public List<Building> getBuildings() { 
		return buildingService.listAllBuildings();
	}
	
	@GetMapping(path="/buildings/{id}", produces={"application/json"})
	@ApiOperation("Search a buildings with an ID")
	@ApiResponse(code = 200, message = "OK")
	public Optional<Building> getBuilding(@ApiParam(value = "The id of the building", required = true, example = "C310") 
										  @PathVariable String id) {
		return buildingService.findByIdBuilding(id);
	}

	@PutMapping(path="/buildings/{id}", produces={"application/json"})
	@ApiOperation("Update building with an ID")
	@ApiResponse(code = 200, message = "OK")
	public Building updateInmueble(@ApiParam(value = "The information of the building to update", required = true) @RequestBody Building building, 
			@ApiParam(value = "The id of the building", required = true, example = "C310") @PathVariable String id) {
		Optional<Building> update = buildingService.findByIdBuilding(id);
		
		update.get().setMunicipality(building.getMunicipality());
		update.get().setColony(building.getColony());
		update.get().setPostalCode(building.getPostalCode());
		update.get().setPrice(building.getPrice());
		update.get().setImage(building.getImage());
		
		return buildingService.updateBuilding(update.get());
	}

	@DeleteMapping(path="/buildings/{id}", produces={"application/json"})
	@ApiOperation("Delete building with an ID")
	public int deteleBuilding(@ApiParam(value = "The id of the building", required = true, example = "C321") @PathVariable String id) {
		return buildingService.deleteBuilding(id);
	}

	@PostMapping(path="/buildings", produces={"application/json"})
	@ApiOperation("Creates a new building")
	public Building createBuilding(@ApiParam(value = "The information of the new building", required = true) @RequestBody Building building) {
		return buildingService.addBuilding(building);
	}
	
}
