package ca.ravichaudhary.petstore.repository;

import org.springframework.data.repository.CrudRepository;

import ca.ravichaudhary.petstore.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
