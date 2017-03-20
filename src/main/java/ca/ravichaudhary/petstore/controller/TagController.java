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

import ca.ravichaudhary.petstore.model.Tag;
import ca.ravichaudhary.petstore.service.TagService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/tag", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	@RequestMapping("")
	public List<Tag> getAllTags(){
		return tagService.getAllTags();
	}
	
	@RequestMapping("/{tagId}")
	public Tag getTag(@PathVariable long tagId){
		return tagService.getTag(tagId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "")
	public void saveTag(@RequestBody Tag tag){
		tagService.saveTag(tag);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{tagId}")
	public void deleteTag(@PathVariable long tagId){
		tagService.deleteTag(tagId);
	}
}
