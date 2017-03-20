package ca.ravichaudhary.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.ravichaudhary.petstore.model.Status;
import ca.ravichaudhary.petstore.service.StatusService;

@CrossOrigin(origins = "*")
@RestController
public class StatusController {

	@Autowired
	private StatusService statusService;
	
	@RequestMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Status> getStatus(){
		return statusService.getStatus();
	}
}
