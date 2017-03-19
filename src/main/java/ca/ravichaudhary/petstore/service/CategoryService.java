package ca.ravichaudhary.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.ravichaudhary.petstore.model.Category;
import ca.ravichaudhary.petstore.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllPets() {
		List<Category> categorys = new ArrayList<>();
		categoryRepository.findAll().forEach(categorys::add);
		return categorys;
	}
	
	public Category saveCategory(Category category){
		return categoryRepository.save(category);
	}

	public Category getCategory(long categoryId) {
		return categoryRepository.findOne(categoryId);
	//	return pets.stream().filter(p -> p.getId() == petId).findFirst().get();
	}

	public void deleteCategory(long categoryId) {
		categoryRepository.delete(categoryId);
	}
}