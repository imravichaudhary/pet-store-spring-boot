package ca.ravichaudhary.petstore.repository;

import org.springframework.data.repository.CrudRepository;

import ca.ravichaudhary.petstore.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long>{

}
