package ca.ravichaudhary.petstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Entity
public enum Status {

	AVAILABLE("available"), 
	PENDING("pending"), 
	SOLD("sold");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String name;

	Status(String name) {
		this.name = name;
	}

	@JsonValue
	public String getName() {
		return name;
	}
	
	@JsonCreator
	public static Status fromString(String name){
		for(Status status : Status.values()){
			if(status.name.equalsIgnoreCase(name)){
				return status;
			}
		}
		return null;
	}
}
