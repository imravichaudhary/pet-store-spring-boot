package ca.ravichaudhary.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.ravichaudhary.petstore.model.Tag;
import ca.ravichaudhary.petstore.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	
	public List<Tag> getAllTags() {
		List<Tag> tags = new ArrayList<>();
		tagRepository.findAll().forEach(tags::add);
		return tags;
	}
	
	public Tag saveTag(Tag tag){
		return tagRepository.save(tag);
	}

	public Tag getPet(long tagId) {
		return tagRepository.findOne(tagId);
	//	return pets.stream().filter(p -> p.getId() == petId).findFirst().get();
	}

	public void deleteTag(long tagId) {
		tagRepository.delete(tagId);
	}
}
