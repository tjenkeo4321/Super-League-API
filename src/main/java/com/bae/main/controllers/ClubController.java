package com.bae.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bae.main.entities.Club;

@RestController
public class ClubController {

		// Temporary storage until we implement the real database //
	private List<Club> clubs = new ArrayList<>();
	
	// Get Requests (READ) //
	@GetMapping("/getAll")
	public List<Club> getAll() {
		return clubs;
	}
	
	@GetMapping("/getById")
	public Club getById() {
		
	}
	// Post Requests (CREATE) //
	@PostMapping("/create")
	public Club create(@RequestBody Club input) {
		clubs.add(input);
		
		return clubs.get(clubs.size() - 1);
	}
	// Put Requests (UPDATE) //
	
	// Delete Requests (DELETE) //
	
	
}
