package com.bae.main.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.main.entities.Club;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest
@AutoConfigureMockMvc // Allows us to send mock requests using MockMvc //
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test") // Switching to test profile H2 database //
public class ClubControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc; // This is for sending mock requests //
	@Autowired
	private ObjectMapper mapper; // Converting to JSON data //
	
	@Test
	public void createTest() {
		
	}
	
	@Test
	public void getAllTest() throws Exception {
		
		List<Club> result = new ArrayList<>();
		result.add(new Club(1L, "Arsenal FC", "England", 13));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/club/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(resultAsJSON));
	}
	@Test
	public void getByIdTest() throws Exception {
		Club result = new Club(1L, "Arsenal FC", "England", 13);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/club/getById/1")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(resultAsJSON));
		
		

	}
	@Test
	public void getByClubNameTest() throws Exception {
		List<Club> result = new ArrayList<>();
		
		result.add(new Club(1L, "Arsenal FC", "England", 13));
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/club/getByClubName/Arsenal FC")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(resultAsJSON));
	}
	@Test
	public void updateTest() throws Exception {
		
	
	}
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/club/delete/1")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string("true"));
		
	}
  	
}
