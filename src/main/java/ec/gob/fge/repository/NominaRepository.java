package ec.gob.fge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.gob.fge.domain.Nomina;

@Repository("nominaRepository")
@Transactional
public interface NominaRepository extends CrudRepository<Nomina, Long> {

}
