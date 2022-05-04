package repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import models.Dojo;
import models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
	List<Ninja> findAllByDojo(Dojo dojo);
}
