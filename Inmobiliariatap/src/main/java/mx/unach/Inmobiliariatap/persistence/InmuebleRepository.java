package mx.unach.Inmobiliariatap.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mx.unach.Inmobiliariatap.domain.Building;
import mx.unach.Inmobiliariatap.domain.repository.BuildingRepository;
import mx.unach.Inmobiliariatap.persistence.crud.InmuebleCrudRepository;
import mx.unach.Inmobiliariatap.persistence.entity.Inmueble;
import mx.unach.Inmobiliariatap.persistence.mapper.BuildingMapper;

@Repository
public class InmuebleRepository implements BuildingRepository{
	
	@Autowired
	@Qualifier("inmuebleCrudRepository")
	private InmuebleCrudRepository inmuebleCrudRepository;
	
	@Autowired
	private BuildingMapper mapper;
	
	@Override
    public List<Building> listAllBuildings() {
        return mapper.toBuildings((List<Inmueble>) inmuebleCrudRepository.findAll());
    }
    
    @Override
    public Optional<Building> findByIdBuilding(String id) {
        return inmuebleCrudRepository.findById(id).map(producto -> mapper.toBuilding(producto));
    }

    @Override
	public Building updateBuilding(Building building) {
		return mapper.toBuilding(inmuebleCrudRepository.save(mapper.toInmueble(building)));
	}

    @Override
    public int deleteBuilding(String id) {
        return inmuebleCrudRepository.deleteByIdcliente(id);
    }

	@Override
	public Building addBuilding(Building building) {
		return mapper.toBuilding(inmuebleCrudRepository.save(mapper.toInmueble(building)));
	}

}
