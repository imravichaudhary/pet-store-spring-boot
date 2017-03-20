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

import ca.ravichaudhary.petstore.model.Category;
import ca.ravichaudhary.petstore.service.CategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("")
	public List<Category> getAllCategorys(){
		return categoryService.getAllCategorys();
	}
	
	@RequestMapping("/{categoryId}")
	public Category getCategory(@PathVariable long categoryId){
		return categoryService.getCategory(categoryId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "")
	public void saveCategory(@RequestBody Category category){
		categoryService.saveCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{categoryId}")
	public void deleteCategory(@PathVariable long categoryId){
		categoryService.deleteCategory(categoryId);
	}
}
