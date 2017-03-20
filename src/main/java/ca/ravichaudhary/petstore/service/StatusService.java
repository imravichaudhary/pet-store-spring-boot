package ca.ravichaudhary.petstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.ravichaudhary.petstore.model.Status;

@Service
public class StatusService {
	
	public List<Status> getStatus(){
		List<Status> statusList = new ArrayList<>();
		for(Status status : Status.values()){
			statusList.add(status);
		}
		return statusList;
	}
}
