package com.bae.main.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bae.main.entities.Club;
import com.bae.main.exceptions.ClubNotFoundException;
import com.bae.main.repos.ClubRepo;

@Service
public class ClubService {

private ClubRepo repo;



public ClubService(ClubRepo repo) {
	super();
	this.repo = repo;
}


public Club create(Club input) {
	return repo.saveAndFlush(input);
}


public List<Club> getAll() {
	return repo.findAll();
}


public Club getById(long id) {
	return repo.findById(id).orElseThrow(ClubNotFoundException::new);
}

public Club getByClubName(String clubName) {
	return repo.findClubByClubName(clubName);
	}

public Club update(long id, Club input) {
	Club existing = repo.findById(id).orElseThrow(ClubNotFoundException::new);
	
	existing.setClubName(input.getClubName());
	existing.setClubNationality(input.getClubNationality());
	existing.setClubTitles(input.getClubTitles());
	
	return repo.saveAndFlush(existing);
	
}



public boolean delete(long id) {
	repo.deleteById(id);
	
	return !repo.existsById(id);
}

}
