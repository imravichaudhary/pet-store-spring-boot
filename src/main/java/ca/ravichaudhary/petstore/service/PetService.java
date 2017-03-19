package ca.ravichaudhary.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.ravichaudhary.petstore.model.Pet;
import ca.ravichaudhary.petstore.model.Tag;
import ca.ravichaudhary.petstore.repository.PetRepository;
import ca.ravichaudhary.petstore.model.Category;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagService;
	
	public List<Pet> getAllPets() {
		List<Pet> pets = new ArrayList<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}
	
	public void savePet(Pet pet){
		Category c = categoryService.saveCategory(pet.getCategory());
		List<Tag> t = pet.getTags();
		t.stream().forEach(tag -> tagService.saveTag(tag));
		
		Pet p = new Pet(pet.getId(), c, pet.getName(), pet.getPhotoUrls(), t, pet.getStatus());
		petRepository.save(p);
	}

	public Pet getPet(long petId) {
		return petRepository.findOne(petId);
	//	return pets.stream().filter(p -> p.getId() == petId).findFirst().get();
	}

	public void deletePet(long petId) {
		petRepository.delete(petId);
	}
}
