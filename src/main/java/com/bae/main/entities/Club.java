package com.bae.main.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Club {

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

// camelCase is used for variable names
// String is the datatype we use for text

@Column(nullable = false, unique = true)
private String clubName;
@Column(nullable = false)
private String clubNationality;
@Column(nullable = false)
private int clubTitles;


// CONSTRUCTORS - a method used to make objects of the class //

// The constructor used for Reading (cRud) //
public Club(long id, String clubName, String clubNationality, int clubTitles) {
	super();
	this.id = id;
	this.clubName = clubName;
	this.clubNationality = clubNationality;
	this.clubTitles = clubTitles;
}

// This constructor is used for creating (Crud)
public Club(String clubName, String clubNationality, int clubTitles) {
	super();
	this.clubName = clubName;
	this.clubNationality = clubNationality;
	this.clubTitles = clubTitles;
}

// This constructor is a default constructor
public Club() {}




// GETTERS AND SETTERS //
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getClubName() {
	return clubName;
}
public void setClubName(String clubName) {
	this.clubName = clubName;
}
public String getClubNationality() {
	return clubNationality;
}
public void setClubNationality(String clubNationality) {
	this.clubNationality = clubNationality;
}
public int getClubTitles() {
	return clubTitles;
}
public void setClubTitles(int clubTitles) {
	this.clubTitles = clubTitles;
}
@Override
public int hashCode() {
	return Objects.hash(clubName, clubNationality, clubTitles, id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Club other = (Club) obj;
	return Objects.equals(clubName, other.clubName) && Objects.equals(clubNationality, other.clubNationality)
			&& clubTitles == other.clubTitles && id == other.id;
}



}
