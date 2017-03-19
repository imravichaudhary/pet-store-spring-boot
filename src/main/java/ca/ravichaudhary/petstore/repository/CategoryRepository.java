package ca.ravichaudhary.petstore.repository;

import org.springframework.data.repository.CrudRepository;

import ca.ravichaudhary.petstore.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}