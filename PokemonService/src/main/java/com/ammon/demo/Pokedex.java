package com.ammon.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokedex {

	private List<String> items;
	
	public Pokedex() {
		this.items = new ArrayList<>();
		
		this.items.add("Bulbasaur");
		this.items.add("Charmander");
		this.items.add("Squirtle");
		this.items.add("Pidgey");
		this.items.add("Psyduck");
		this.items.add("Kyogre");
		this.items.add("Mewtwo");
		this.items.add("Lapras");
		this.items.add("Beedrill");
		this.items.add("Gengar");
		
	}
	
	public String getPokemon() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(this.items.size());
		return this.items.get(randomNumber);
	}
	
	
	
	
}
