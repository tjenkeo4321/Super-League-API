package com.bae.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bae.main.entities.Club;
import com.bae.main.services.ClubService;

@RestController
public class ClubController {

	private ClubService service;
	
	
	public ClubController(ClubService service) {
		super();
		this.service = service;
	}

	// Post Requests (CREATE) //
	@PostMapping("/create")
	public ResponseEntity <Club> create(@RequestBody Club input) {
	return new ResponseEntity<Club>(service.create(input), HttpStatus.CREATED);	
	}
	
	// Get Requests (READ) //
	@GetMapping("/getAll")
	public List<Club> getAll() {
	return service.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public Club getById(@PathVariable long id) {
	return service.getById(id);
	}
	
	@GetMapping("/getByClubName/{clubName}")
	public Club getByClubName(@PathVariable String clubName) {
	return service.getByClubName(clubName);
	}
	
	// Put Requests (UPDATE) //
	@PutMapping("/update/{id}")
	public Club update(@PathVariable long id, @RequestBody Club input) {
	return service.update(id, input);
	}
	
	// Delete Requests (DELETE) //
	@DeleteMapping("/delete")
	public boolean delete(@PathVariable long id) {
	return service.delete(id);	
	}
	
}
