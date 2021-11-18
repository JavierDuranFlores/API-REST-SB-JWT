package mx.unach.Inmobiliariatap.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AuthenticationResponse {

	@Setter @Getter
	private String jwt;
	
}
