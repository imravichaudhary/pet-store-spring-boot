package ca.ravichaudhary.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.ravichaudhary.petstore.model.Pet;
import ca.ravichaudhary.petstore.service.PetService;

@RestController
public class PetController {

	@Autowired
	private PetService petService;

	@RequestMapping("/pet")
	public List<Pet> getAllPets() {
		return petService.getAllPets();
	}

	@RequestMapping("/pet/{petId}")
	public Pet getPet(@PathVariable int petId) {
		return petService.getPet(petId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pet", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void savePet(@RequestBody Pet pet) {
		petService.savePet(pet);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/pet/{petId}")
	public void deletePet(@PathVariable long petId) {
		petService.deletePet(petId);
	}
}
