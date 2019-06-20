package com.ammon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TrainerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping()
	public String choose() {
		String pokemonName = restTemplate.getForObject("http://pokemon-service", String.class);
		return "I choose you, " + pokemonName;
	}
	
}
