package ec.gob.fge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.gob.fge.domain.Employee;

@Repository("employeeRepository")
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
