package ec.gob.fge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.fge.domain.Employee;
import ec.gob.fge.services.EmployeeService;
import ec.gob.fge.util.ResponseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

import io.swagger.annotations.ApiResponse;

@RestController
@Api(value = "Rest Api example", tags = "EMPLOYEE")
@RequestMapping("/employee")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Objeto recuperado"),
		@ApiResponse(code = 200, message = "SUCESS"), @ApiResponse(code = 404, message = "RESOURCE NOT FOUND"),
		@ApiResponse(code = 400, message = "BAD REQUEST"), @ApiResponse(code = 201, message = "CREATED"),
		@ApiResponse(code = 401, message = "UNAUTHORIZED"),
		@ApiResponse(code = 415, message = "UNSUPPORTED TYPE - Representation not supported for the resource"),
		@ApiResponse(code = 500, message = "SERVER ERROR") })
public class EmployeeController implements ErrorController {
	private static final String PATH = "/error";

	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;

	@Autowired
	@Qualifier("responseController")
	private ResponseController responseController;

	/**
	 * Busca todos los registros de la entidad
	 * 
	 * @param id: Identificador de la entidad
	 * @return Entidad: Retorna todos los registros.
	 */
	@GetMapping(value = "/")
	@ApiOperation(value = "Obtiene todos los registros de la entidad cliente", response = Employee.class)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> findAll() {
		List<Employee> clientes = employeeService.findAll();
		return ResponseEntity.ok(clientes);
	}

	/**
	 * Busca los registros por Id de la entidad
	 * 
	 * @param id: Identificador de la entidad
	 * @return parametrosCarga: Retorna el registro encontrado
	 */
	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Obtiene el registro por id", response = Employee.class)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Optional<?>> findById(@PathVariable Long id) {
		Optional<Employee> officer = employeeService.findById(id);
		return ResponseEntity.ok(officer);
	}

	/**
	 * Inserta un nuevo registro en la entidad
	 * 
	 * @param entidad: entidad a insertar
	 * @return ResponseController: Retorna el id creado
	 */
	@PostMapping(value = "/")
	@ApiOperation(value = "Crear nuevo registro", response = ResponseController.class)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ResponseController> postEntity(@RequestBody Employee employee) {
		Employee employeeSaved = employeeService.save(employee);
		return ResponseEntity.ok(new ResponseController(employeeSaved.getEmp_no(), "Creado"));
	}

	/**
	 * Actualiza un registro
	 * 
	 * @param usuId:   Identificador del usuario que va a actualizar
	 * 
	 * @param entidad: entidad a actualizar
	 * @return ResponseController: Retorna el id actualizado
	 */
	@PutMapping(value = "/")
	@ApiOperation(value = "Actualizar los registros", response = ResponseController.class)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ResponseController> update(@RequestBody Employee update) {
		Employee employeeUpdated = employeeService.update(update);
		return ResponseEntity.ok(new ResponseController(employeeUpdated.getEmp_no(), "Actualizado"));
	}

	/**
	 * Elimina un registro
	 * 
	 * @param usuId:   Identificador del usuario que va a actualizar
	 * 
	 * @param entidad: entidad a actualizar
	 * @return ResponseController: Retorna el id actualizado
	 */
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Elimina un registro", response = ResponseController.class)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ResponseController> delete(@PathVariable Long id) {
		employeeService.delete(id);
		return ResponseEntity.ok(new ResponseController(id, "Elminado"));
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
