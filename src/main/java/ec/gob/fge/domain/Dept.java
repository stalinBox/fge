package ec.gob.fge.domain;

import java.io.Serializable;

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
@ToString(of = "dept_no")
@EqualsAndHashCode(of = "dept_no")
@Builder

@Data
@Entity
@Table(name = "dept", schema = "public")
public class Dept implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(value = "Este campo es la clave primaria de la tabla", required = true, readOnly = true)
	@Column(name = "dept_no")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("dept_no")
	private Long dept_no;

	@ApiModelProperty(value = "Ejemplo parametro String", example = "Nombres Completos")
	@Column(name = "dname")
	@JsonProperty("dname")
	@JsonInclude(Include.NON_NULL)
	private String dname;

	@ApiModelProperty(value = "Ejemplo parametro String", example = "Nombres Completos")
	@Column(name = "loc")
	@JsonProperty("loc")
	@JsonInclude(Include.NON_NULL)
	private String loc;

}
