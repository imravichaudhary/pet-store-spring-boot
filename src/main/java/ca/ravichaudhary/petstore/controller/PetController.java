package ca.ravichaudhary.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.ravichaudhary.petstore.model.Pet;
import ca.ravichaudhary.petstore.service.PetService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/pet", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PetController {

	@Autowired
	private PetService petService;

	@RequestMapping("")
	public List<Pet> getAllPets() {
		return petService.getAllPets();
	}

	@RequestMapping("/{petId}")
	public Pet getPet(@PathVariable long petId) {
		return petService.getPet(petId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "")
	public void savePet(@RequestBody Pet pet) {
		petService.savePet(pet);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{petId}")
	public void deletePet(@PathVariable long petId) {
		petService.deletePet(petId);
	}
}
