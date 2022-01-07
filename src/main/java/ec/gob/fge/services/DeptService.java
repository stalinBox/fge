package ec.gob.fge.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import ec.gob.fge.domain.Dept;
import ec.gob.fge.exception.MyNotFoundException;
import ec.gob.fge.repository.DeptRepository;

@Service("deptService")
public class DeptService {

	@Autowired
	@Qualifier("deptRepository")
	private DeptRepository deptRepository;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Metodo para encontrar todos los registros
	 * 
	 * @return Todos los registros de la tabla
	 */
	public List<Dept> findAll() {
		List<Dept> template = (List<Dept>) deptRepository.findAll();
		if (template.isEmpty())
			throw new MyNotFoundException(String.format(
					messageSource.getMessage("error.entity_cero_exist.message", null, LocaleContextHolder.getLocale()),
					this.getClass().getName()));
		return template;
	}

	/**
	 * Busca un registro por Id
	 * 
	 * @param id: Identificador del registro
	 * @return entidad: Retorna todos los registros filtrados por el parámetros de
	 *         entrada
	 */
	public Optional<Dept> findById(Long id) {
		Optional<Dept> cialco = deptRepository.findById(id);
		if (!cialco.isPresent())
			throw new MyNotFoundException(String.format(
					messageSource.getMessage("error.entity_cero_exist.message", null, LocaleContextHolder.getLocale()),
					id));
		return cialco;
	}

	/**
	 * Actualiza un registro
	 * 
	 * @param entidad: Contiene todos campos de la entidad para guardar
	 * @return catalogo: La entidad Guardada
	 */
	public Dept update(Dept newEnity) {
		Optional<Dept> oldCialco = findById(newEnity.getDept_no());
		copyNonNullProperties(newEnity, oldCialco.get());
		return deptRepository.save(oldCialco.get());
	}

	public static void copyNonNullProperties(Object src, Object target) {
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	/**
	 * Elimina un registro por id
	 * 
	 * @param id: Identificador del registro
	 */
	public void delete(Long id) {
		deptRepository.deleteById(id);
	}

	/**
	 * Guarda un registro
	 * 
	 * @param entidad: Contiene todos campos de la entidad para guardar
	 * @return catalogo: La entidad Guardada
	 */
	public Dept save(Dept officer) {
		return deptRepository.save(officer);
	}
}
