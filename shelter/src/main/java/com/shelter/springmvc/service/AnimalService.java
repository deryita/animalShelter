package com.shelter.springmvc.service;

import java.util.List;

import com.shelter.springmvc.model.Animal;

public interface AnimalService {
	Animal findById(int id);
	
	Animal findByName(String name);
	
	void saveAnimal(Animal animal);
	
	void updateAnimal(Animal animal);
	
	void deleteAnimalById(int id);

	List<Animal> findAllAnimals(); 
	
	List<Animal> searchAnimal(String chars); 
	
	//boolean isUserSSOUnique(Integer id, String sso);
}
