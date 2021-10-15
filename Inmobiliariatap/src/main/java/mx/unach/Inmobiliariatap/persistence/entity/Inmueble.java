package mx.unach.Inmobiliariatap.persistence.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="inmuebles")
@Builder
@ToString	
public class Inmueble implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="idc")
	@Getter @Setter
    private String idcliente;

    @Column(name="municipio")
    @Getter @Setter
    private String municipio;

    @Column(name="colonia")
    @Getter @Setter
    private String colonia;

    @Column(name="codigopostal")
    @Getter @Setter
    private String codigopostal;

    @Column(name="precio")
    @Getter @Setter
    private Double precio;

    @Column(name="imagen")
    @Getter @Setter
    private String imagen;
    
}
