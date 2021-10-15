package mx.unach.Inmobiliariatap.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Building {

	@Getter @Setter
	private String customerId;
	
	@Getter @Setter
	private String municipality;
	
	@Getter @Setter
	private String colony;
	
	@Getter @Setter
	private String postalCode ;
	
	@Getter @Setter
	private Double price;
	
	@Getter @Setter
	private String image;
	
}
