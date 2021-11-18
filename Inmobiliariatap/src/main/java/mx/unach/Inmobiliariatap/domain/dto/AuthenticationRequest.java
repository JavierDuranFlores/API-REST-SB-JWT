package mx.unach.Inmobiliariatap.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AuthenticationRequest {

	@Setter @Getter
	private String username;
	
	@Setter @Getter
	private String password;
	
}
