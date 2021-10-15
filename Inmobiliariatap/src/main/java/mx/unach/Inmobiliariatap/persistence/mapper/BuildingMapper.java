package mx.unach.Inmobiliariatap.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import mx.unach.Inmobiliariatap.domain.Building;
import mx.unach.Inmobiliariatap.persistence.entity.Inmueble;

@Mapper(componentModel = "spring")
public interface BuildingMapper {

	@Mappings({
		@Mapping(source = "idCliente", target = "customerId"),
		@Mapping(source = "municipio", target = "municipality"),
		@Mapping(source = "colonia", target = "colony"),
		@Mapping(source = "codigopostal", target = "postalCode"),
		@Mapping(source = "precio", target = "price"),
		@Mapping(source = "imagen", target = "image"),
	})
	Building toBuilding(Inmueble inmueble);
	List<Building> toBuildings(List<Inmueble> nmuebles);
	
	@InheritInverseConfiguration
	Inmueble toInmueble(Building building);
}
