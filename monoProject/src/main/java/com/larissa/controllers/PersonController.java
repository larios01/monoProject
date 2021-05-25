package com.larissa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.larissa.models.Person;
import com.larissa.repositories.PersonRepo;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonRepo personRepo;
	
	@PostMapping("/savePerson")
	public String save(@RequestBody Person person) {
		personRepo.savePerson(person);
		return "success";
	}
	@GetMapping("/getAll")
	public List<Person> getAllPersons(){
		return personRepo.getPersons();
	}

}
