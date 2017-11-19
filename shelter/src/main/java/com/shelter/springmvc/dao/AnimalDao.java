package com.shelter.springmvc.dao;

import java.util.List;

import com.shelter.springmvc.model.Animal;

public interface AnimalDao {
	Animal findById(int id);
	
	Animal findByName(String name);
	
	void save(Animal animal);
	
	void deletebyID(int id);
	
	List<Animal> findAllAnimals();


}
