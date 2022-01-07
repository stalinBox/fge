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
@ToString(of = "emp_no")
@EqualsAndHashCode(of = "emp_no")
@Builder

@Data
@Entity
@Table(name = "employee", schema = "public")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(value = "Este campo es la clave primaria de la tabla", required = true, readOnly = true)
	@Column(name = "emp_no")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("emp_no")
	private Long emp_no;

	@ApiModelProperty(value = "Ejemplo parametro String", example = "Nombres Completos")
	@Column(name = "job")
	@JsonProperty("job")
	@JsonInclude(Include.NON_NULL)
	private String job;

	@ApiModelProperty(value = "Ejemplo parametro String")
	@Column(name = "manager_no")
	@JsonProperty("manager_no")
	@JsonInclude(Include.NON_NULL)
	private Integer manager_no;

	@ApiModelProperty(value = "Ejemplo parametro String")
	@Column(name = "dept_no")
	@JsonProperty("dept_no")
	@JsonInclude(Include.NON_NULL)
	private Integer dept_no;

}
