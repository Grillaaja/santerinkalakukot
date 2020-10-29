package fi.jarvine.santerinkalakukot.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SpecieRepository extends CrudRepository<Specie, Long> {

	List<Specie> findByName(String name);
	
}
