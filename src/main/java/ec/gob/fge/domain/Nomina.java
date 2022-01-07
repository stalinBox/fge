package ec.gob.fge.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@Builder

@Data
@Entity
@Table(name = "nomina", schema = "public")
public class Nomina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(value = "Este campo es la clave primaria de la tabla", required = true, readOnly = true)
	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(value = "Ejemplo parametro String", example = "Nombres Completos")
	@Column(name = "name")
	@JsonProperty("name")
	@JsonInclude(Include.NON_NULL)
	private String name;

	@ApiModelProperty(value = "Ejemplo parametro String")
	@Column(name = "age")
	@JsonProperty("age")
	@JsonInclude(Include.NON_NULL)
	private Integer age;

	@ApiModelProperty(value = "Ejemplo parametro String", example = "Direccion Completa")
	@Column(name = "address")
	@JsonProperty("address")
	@JsonInclude(Include.NON_NULL)
	private String address;

	@ApiModelProperty(value = "Ejemplo parametro String", example = "555.00")
	@Column(name = "salary")
	@JsonProperty("salary")
	@JsonInclude(Include.NON_NULL)
	private Double salary;

	@ApiModelProperty(value = "Ejemplo parametro String")
	@Column(name = "join_date")
	@JsonProperty("join_date")
	@JsonInclude(Include.NON_NULL)
	private Date join_date;

	@ApiModelProperty(value = "Ejemplo parametro String", example = "Nombre@algum.com")
	@Column(name = "email")
	@JsonProperty("email")
	@JsonInclude(Include.NON_NULL)
	private String email;

	@ApiModelProperty(value = "Ejemplo parametro String", example = "algun grupo")
	@Column(name = "blood_group")
	@JsonProperty("blood_group")
	@JsonInclude(Include.NON_NULL)
	private String blood_group;

}
