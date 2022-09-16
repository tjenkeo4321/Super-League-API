package com.bae.main.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bae.main.entities.Club;

@Repository
public interface ClubRepo extends JpaRepository<Club, Long> {
	// Find by ClubName
	// This will return a single record
	// SELECT * FROM clubs WHERE club_name = ?1 //
	Club findClubByClubName(String clubName);
	// This is a completed derived query //
	
	
	
}
