package mx.unach.Inmobiliariatap.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import io.swagger.annotations.ApiResponses;
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
	public ResponseEntity<List<Building>> getBuildings() { 
		return new ResponseEntity<>(buildingService.listAllBuildings(), HttpStatus.OK);
	}
	
	@GetMapping(path="/buildings/{id}", produces={"application/json"})
	@ApiOperation("Search a buildings with an ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 404, message = "Building not found")
	})
	public ResponseEntity<Building> getBuilding(@ApiParam(value = "The id of the building", required = true, example = "C310") 
										  @PathVariable String id) {
		return buildingService.findByIdBuilding(id)
				.map(building -> new ResponseEntity<>(building, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping(path="/buildings/{id}", produces={"application/json"})
	@ApiOperation("Update building with an ID")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity<Building> updateInmueble(@ApiParam(value = "The information of the building to update", required = true) @RequestBody Building building, 
			@ApiParam(value = "The id of the building", required = true, example = "C310") @PathVariable String id) {
		Optional<Building> update = buildingService.findByIdBuilding(id);
		
		update.get().setMunicipality(building.getMunicipality());
		update.get().setColony(building.getColony());
		update.get().setPostalCode(building.getPostalCode());
		update.get().setPrice(building.getPrice());
		update.get().setImage(building.getImage());
		
		return new ResponseEntity<>(buildingService.updateBuilding(update.get()), HttpStatus.OK);
	}

	@DeleteMapping(path="/buildings/{id}", produces={"application/json"})
	@ApiOperation("Delete building with an ID")
	public ResponseEntity<Building> deteleBuilding(@ApiParam(value = "The id of the building", required = true, example = "C321") @PathVariable String id) {
		if (buildingService.deleteBuilding(id))
			return new ResponseEntity<>(HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(path="/buildings", produces={"application/json"})
	@ApiOperation("Creates a new building")
	public ResponseEntity<Building> createBuilding(@ApiParam(value = "The information of the new building", required = true) @RequestBody Building building) {
		return new ResponseEntity<>(buildingService.addBuilding(building), HttpStatus.CREATED);
	}
	
}
