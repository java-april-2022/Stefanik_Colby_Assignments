package repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
